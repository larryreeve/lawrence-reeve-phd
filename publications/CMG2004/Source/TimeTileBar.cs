using System;
using System.Collections;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Globalization;

namespace TileBar
{
	public class TimeTileBar
	{
        private const int DEFAULT_BMP_WIDTH  = 400;
        private const int DEFAULT_BMP_HEIGHT = 400;

        private readonly Color[] INTENSITY_COLORS_GREYSCALE = {Color.White, Color.LightGray, Color.DarkGray, Color.Black};
        
//        private readonly Color[] INTENSITY_COLORS_COLOR     = {RGBHSL.SetBrightness(Color.Orange, 0.8), 
//                                                               RGBHSL.SetBrightness(Color.Orange, 0.7), 
//                                                               RGBHSL.SetBrightness(Color.Orange, 0.6), 
//                                                               RGBHSL.SetBrightness(Color.Orange, 0.5)};

//        private readonly Color[] INTENSITY_COLORS_COLOR     = {   RGBHSL.SetSaturation(RGBHSL.SetBrightness(Color.White, 0.6), 1),
//                                                                  RGBHSL.SetSaturation(RGBHSL.SetBrightness(Color.LightSkyBlue, 0.6), 1),
//                                                                  RGBHSL.SetSaturation(RGBHSL.SetBrightness(Color.DeepSkyBlue, 0.6), 1),
//                                                                  RGBHSL.SetSaturation(RGBHSL.SetBrightness(Color.SkyBlue, 0.6), 1)};

        private readonly Color[] INTENSITY_COLORS_COLOR     = {   Color.AliceBlue,
                                                                  Color.LightBlue,
                                                                  Color.SteelBlue,
                                                                  Color.DarkBlue};

        private Bitmap      m_bmp                       = null;
        private Graphics    m_graphics                  = null;
        private ArrayList   m_accountValues             = new ArrayList();
        private ArrayList   m_accountCaptions           = new ArrayList();
        private ArrayList   m_resourceDescriptions      = new ArrayList();
        private int         m_numberOfPeriods           = 0;
        private bool        m_useGreyScale              = false;

		public TimeTileBar() : this(DEFAULT_BMP_WIDTH, DEFAULT_BMP_HEIGHT)
		{
		}

        public bool GreyScale
        {
            get { return m_useGreyScale;    }  
            set { m_useGreyScale = value;   }
        }

        public TimeTileBar(int width, int height)
        {
            if (m_bmp != null)
                m_bmp.Dispose();

            m_bmp = new Bitmap(width, height);
            m_graphics = Graphics.FromImage(m_bmp);

            DefineNumberOfPeriods(12);
            AddResourceDescription("EXEMST");
            AddResourceDescription("EXBYST");
            AddResourceDescription("EXEMRCV");
            AddResourceDescription("EXBYRCV");

            ArrayList valuesAA = new ArrayList();
            valuesAA.Add(new int[] {0, 1, 2, 3, 3, 2, 1, 1, 3, 0, 1, 1});
            valuesAA.Add(new int[] {1, 1, 2, 0, 1, 2, 1, 3, 2, 0, 1, 1});
            valuesAA.Add(new int[] {2, 1, 1, 0, 1, 2, 1, 2, 2, 0, 1, 1});
            valuesAA.Add(new int[] {3, 1, 1, 0, 1, 2, 1, 2, 2, 0, 1, 1});

            ArrayList valuesBB = new ArrayList();
            valuesBB.Add(new int[] {0, 1, 2, 3, 1, 2, 1, 2, 0, 3, 2, 0});
            valuesBB.Add(new int[] {1, 2, 1, 2, 2, 2, 2, 2, 0, 1, 2, 1});
            valuesBB.Add(new int[] {1, 2, 1, 0, 2, 2, 2, 2, 2, 1, 0, 1});
            valuesBB.Add(new int[] {1, 2, 1, 0, 2, 1, 2, 2, 2, 1, 0, 0});

            ArrayList valuesCC = new ArrayList();
            valuesCC.Add(new int[] {1, 1, 2, 0, 2, 1, 1, 2, 0, 1, 2, 2});
            valuesCC.Add(new int[] {0, 2, 1, 0, 2, 2, 0, 1, 0, 1, 2, 2});
            valuesCC.Add(new int[] {1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 0});
            valuesCC.Add(new int[] {1, 1, 1, 0, 2, 3, 2, 2, 2, 1, 2, 0});


            AddAccount("AA",   valuesAA);
            AddAccount("BB",   valuesBB);
            AddAccount("CC",   valuesCC);
        }

        public void ChangeDimensions(int width, int height)
        {
            if (width <= 0) 
            {
                if (m_bmp != null)
                    width = m_bmp.Width;
                else
                    width = DEFAULT_BMP_WIDTH;
            }

            if (height <= 0) 
            {
                if (m_bmp != null)
                    height = m_bmp.Height;
                else
                    height = DEFAULT_BMP_HEIGHT;
            }

            if (m_bmp != null)
                m_bmp.Dispose();

            m_bmp = new Bitmap(width, height);
            m_graphics = Graphics.FromImage(m_bmp);
        }

        public void DefineNumberOfPeriods(int numPeriods)
        {
            m_numberOfPeriods = numPeriods;
        }

        public void AddResourceDescription(string description)
        {
            m_resourceDescriptions.Add(description);
        }

        public void AddAccount(string    caption,
                               ArrayList resourceIntensityValues)
        {
            m_accountCaptions.Add(caption);
            m_accountValues.Add(resourceIntensityValues);
        }

        public Bitmap Clear()
        {
            m_graphics.Clear(Color.White);

            return m_bmp;
        }

        public Bitmap Render()
        {
            m_graphics.Clear(Color.White);

            if (m_accountCaptions.Count <= 0)
                return m_bmp;

            Pen penBorder = new Pen(Color.Black);
            penBorder.Width = 1;

            Font fontCaption = new Font("Arial", 10);
            SizeF sizePaddingCaption = m_graphics.MeasureString("  ", fontCaption);
            
            Font fontDescription = new Font("Arial", 8);
            SizeF sizePaddingDescription = m_graphics.MeasureString("  ", fontDescription);

            // Calculate maximum caption width
            float maxCaptionWidth = 0;
            for (int idx=0; idx < m_accountCaptions.Count-1; idx++)
            {
                SizeF size = m_graphics.MeasureString((string) m_accountCaptions[idx], fontCaption);
                if (size.Width > maxCaptionWidth) 
                    maxCaptionWidth = size.Width;
            }
            
            // Calculate maximum resource description width
            float maxDescriptionWidth = 0;
            for (int idx=0; idx < m_accountCaptions.Count-1; idx++)
            {
                SizeF size = m_graphics.MeasureString((string) m_resourceDescriptions[idx], fontDescription);
                if (size.Width > maxDescriptionWidth) 
                    maxDescriptionWidth = size.Width;
            }

            // Draw border
            m_graphics.DrawRectangle(penBorder, 0, 0, m_bmp.Width-1, m_bmp.Height-1);

            // Calculate height & width of individual tilebar
            SizeF sizeTile = new SizeF();
            sizeTile.Height = m_graphics.MeasureString(" ", fontDescription).Height;
            sizeTile.Width  = (m_bmp.Width - 
                                ((penBorder.Width * 2) + 
                                 (sizePaddingCaption.Width * 3) +
                                 maxCaptionWidth +
                                 maxDescriptionWidth)) / m_numberOfPeriods;

            // Draw tilebars
            float curY = (penBorder.Width * 1) + sizePaddingCaption.Height;
            DateTimeFormatInfo dtInfo = new DateTimeFormatInfo();

            for (int monthIdx=0; monthIdx < dtInfo.MonthNames.Length; monthIdx++)
            {
                m_graphics.DrawString(
                    dtInfo.AbbreviatedMonthNames [monthIdx], 
                    fontCaption, 
                    Brushes.Black, 
                    ((penBorder.Width * 2) + 
                    (sizePaddingCaption.Width * 1) +
                    maxCaptionWidth) + (sizeTile.Width * monthIdx), 
                    curY);
            }
            curY += sizePaddingCaption.Height;
            //curY += sizePaddingCaption.Height;
            

            for (int accountIdx=0; accountIdx < m_accountCaptions.Count; accountIdx++)
            {
                //  Account Code
                float x = ((sizePaddingDescription.Height * m_resourceDescriptions.Count) - sizePaddingCaption.Height) / 2;
                if (x < 0)
                    x = 0;
                m_graphics.DrawString((string) m_accountCaptions[accountIdx], fontCaption, Brushes.Black, sizePaddingCaption.Width, curY + x);
                ArrayList accountValues = (ArrayList) m_accountValues[accountIdx];


                // Tile Bars
                for (int barIdx=0; barIdx < m_resourceDescriptions.Count; barIdx++)
                {
                    m_graphics.DrawString((string) m_resourceDescriptions[barIdx], fontDescription, Brushes.Black, m_bmp.Width - sizePaddingCaption.Width - penBorder.Width - maxDescriptionWidth, curY);

                    int[] resourceIntensityValues = (int[]) accountValues[barIdx];

                    for (int tileIdx=0; tileIdx < m_numberOfPeriods; tileIdx++)
                    {
                        m_graphics.DrawRectangle(
                            Pens.Black, 
                            ((penBorder.Width * 2) + 
                                (sizePaddingCaption.Width * 1) +
                                maxCaptionWidth) + (sizeTile.Width * tileIdx),
                            curY,
                            sizeTile.Width ,
                            sizeTile.Height);

                            // tile bar quarter calculation
                            //* ((resourceIntensityValues[tileIdx] + 1) * 0.25F)

                            Color fillColor = Color.White;
                            if (m_useGreyScale)
                                fillColor = INTENSITY_COLORS_GREYSCALE[resourceIntensityValues[tileIdx]];
                            else
                                fillColor = INTENSITY_COLORS_COLOR[resourceIntensityValues[tileIdx]];

                            m_graphics.FillRectangle(
                                new SolidBrush(fillColor),
                                ((penBorder.Width * 2) + 
                                (sizePaddingCaption.Width * 1) +
                                maxCaptionWidth) + (sizeTile.Width * tileIdx)+1,
                                curY+1,
                                sizeTile.Width  - 2,
                                sizeTile.Height - 2);

                                // tile bar quarter calculation
                                //(sizeTile.Width * ((resourceIntensityValues[tileIdx] + 1) * 0.25F))-2
                    }

                    curY += sizePaddingDescription.Height;
                }
                curY += sizePaddingCaption.Height;
            }

            return m_bmp;
        }

        public Bitmap RenderOriginal()
        {
            m_graphics.Clear(Color.White);

            if (m_accountCaptions.Count <= 0)
                return m_bmp;

            Pen penBorder = new Pen(Color.Black);
            penBorder.Width = 1;

            Font fontCaption = new Font("Arial", 10);
            SizeF sizePaddingCaption = m_graphics.MeasureString("  ", fontCaption);
            
            Font fontDescription = new Font("Arial", 8);
            SizeF sizePaddingDescription = m_graphics.MeasureString("  ", fontDescription);

            // Calculate maximum caption width
            float maxCaptionWidth = 0;
            for (int idx=0; idx < m_accountCaptions.Count-1; idx++)
            {
                SizeF size = m_graphics.MeasureString((string) m_accountCaptions[idx], fontCaption);
                if (size.Width > maxCaptionWidth) 
                    maxCaptionWidth = size.Width;
            }
            
            // Calculate maximum resource description width
            float maxDescriptionWidth = 0;
            for (int idx=0; idx < m_accountCaptions.Count-1; idx++)
            {
                SizeF size = m_graphics.MeasureString((string) m_resourceDescriptions[idx], fontDescription);
                if (size.Width > maxDescriptionWidth) 
                    maxDescriptionWidth = size.Width;
            }

            // Draw border
            m_graphics.DrawRectangle(penBorder, 0, 0, m_bmp.Width-1, m_bmp.Height-1);

            // Calculate height & width of individual tilebar
            SizeF sizeTile = new SizeF();
            sizeTile.Height = m_graphics.MeasureString(" ", fontDescription).Height;
            sizeTile.Width  = 10; //(m_bmp.Width - 
                //((penBorder.Width * 2) + 
                //(sizePaddingCaption.Width * 3) +
                //maxCaptionWidth +
                //maxDescriptionWidth)) / m_numberOfPeriods * 0.25f;

            // Draw tilebars
            float curY = (penBorder.Width * 1) + sizePaddingCaption.Height;
            DateTimeFormatInfo dtInfo = new DateTimeFormatInfo();

            curY += sizePaddingCaption.Height;
            //curY += sizePaddingCaption.Height;
            

            for (int accountIdx=0; accountIdx < m_accountCaptions.Count; accountIdx++)
            {
                //  Account Code
                float x = ((sizePaddingDescription.Height * m_resourceDescriptions.Count) - sizePaddingCaption.Height) / 2;
                if (x < 0)
                    x = 0;
                m_graphics.DrawString((string) m_accountCaptions[accountIdx], fontCaption, Brushes.Black, sizePaddingCaption.Width, curY + x);
                ArrayList accountValues = (ArrayList) m_accountValues[accountIdx];

                // Tile Bars
                for (int barIdx=0; barIdx < m_resourceDescriptions.Count; barIdx++)
                {
                    int[] resourceIntensityValues = (int[]) accountValues[barIdx];

                    float curX = ((penBorder.Width * 2) + 
                        (sizePaddingCaption.Width * 1) +
                        maxCaptionWidth);

                    if (accountIdx == 0)
                    {
                        if (barIdx == 0)
                            sizeTile.Width = 15;
                        else if (barIdx == 1)
                            sizeTile.Width = 15;
                        else if (barIdx == 2)
                            sizeTile.Width = 15;
                        else if (barIdx == 3)
                            sizeTile.Width = 15;
                    }
                    else if (accountIdx == 1)
                        sizeTile.Width = 12;
                    else
                        sizeTile.Width = 10;


                    for (int tileIdx=0; tileIdx < m_numberOfPeriods; tileIdx++)
                    {
                         curX += (sizeTile.Width) + 1;

                        m_graphics.DrawRectangle(
                            Pens.Black, 
                            curX,
                            curY,
                            sizeTile.Width ,
                            sizeTile.Height);

                        // tile bar quarter calculation
                        //* ((resourceIntensityValues[tileIdx] + 1) * 0.25F)

                        Color fillColor = Color.White;
                        fillColor = INTENSITY_COLORS_GREYSCALE[resourceIntensityValues[tileIdx]];

                        m_graphics.FillRectangle(
                            new SolidBrush(fillColor),
                            curX,
                            curY+1,
                            sizeTile.Width  - 2,
                            sizeTile.Height - 2);


                    }

                    curX += sizeTile.Width*2;
                    m_graphics.DrawString((string) m_resourceDescriptions[barIdx], fontDescription, Brushes.Black, 
                        curX, curY);



                    curY += sizePaddingDescription.Height;
                }
                curY += sizePaddingCaption.Height;
            }

            return m_bmp;
        }
    }
}
