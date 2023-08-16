using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace TileBar
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
    public class Form1 : System.Windows.Forms.Form
    {
        private int m_lastWidth = 0;
        private System.Windows.Forms.MainMenu mainMenu1;
        private System.Windows.Forms.MenuItem menuFile;
        private System.Windows.Forms.MenuItem menuFileExit;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage2;
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.Container components = null;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox checkGreyScale;
        private System.Windows.Forms.Button buttonCopy;
        private System.Windows.Forms.Panel panel1;
        private TimeTileBar m_tb = null;

        public Form1()
        {
            //
            // Required for Windows Form Designer support
            //
            InitializeComponent();

            //
            // TODO: Add any constructor code after InitializeComponent call
            //

            m_tb = new TimeTileBar();
        }

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        protected override void Dispose( bool disposing )
        {
            if( disposing )
            {
                if (components != null) 
                {
                    components.Dispose();
                }
            }
            base.Dispose( disposing );
        }

        #region Windows Form Designer generated code
        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.mainMenu1 = new System.Windows.Forms.MainMenu();
            this.menuFile = new System.Windows.Forms.MenuItem();
            this.menuFileExit = new System.Windows.Forms.MenuItem();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.checkGreyScale = new System.Windows.Forms.CheckBox();
            this.buttonCopy = new System.Windows.Forms.Button();
            this.tabControl1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // mainMenu1
            // 
            this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                      this.menuFile});
            // 
            // menuFile
            // 
            this.menuFile.Index = 0;
            this.menuFile.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                     this.menuFileExit});
            this.menuFile.Text = "&File";
            // 
            // menuFileExit
            // 
            this.menuFileExit.Index = 0;
            this.menuFileExit.Text = "E&xit";
            this.menuFileExit.Click += new System.EventHandler(this.menuFileExit_Click);
            // 
            // tabControl1
            // 
            this.tabControl1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
                | System.Windows.Forms.AnchorStyles.Left) 
                | System.Windows.Forms.AnchorStyles.Right)));
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Location = new System.Drawing.Point(16, 16);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(568, 296);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.panel1);
            this.tabPage2.Controls.Add(this.label1);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Size = new System.Drawing.Size(560, 270);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Display";
            // 
            // panel1
            // 
            this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
                | System.Windows.Forms.AnchorStyles.Left) 
                | System.Windows.Forms.AnchorStyles.Right)));
            this.panel1.AutoScroll = true;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Location = new System.Drawing.Point(16, 40);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(528, 216);
            this.panel1.TabIndex = 2;
            this.panel1.Resize += new System.EventHandler(this.panel1_Resize);
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(16, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(528, 16);
            this.label1.TabIndex = 1;
            this.label1.Text = "Resource Usage by Month - 1/1/03 through 12/31/03";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // checkGreyScale
            // 
            this.checkGreyScale.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkGreyScale.Location = new System.Drawing.Point(40, 328);
            this.checkGreyScale.Name = "checkGreyScale";
            this.checkGreyScale.Size = new System.Drawing.Size(88, 16);
            this.checkGreyScale.TabIndex = 3;
            this.checkGreyScale.Text = "Grey Scale";
            this.checkGreyScale.CheckedChanged += new System.EventHandler(this.checkGreyScale_CheckedChanged_1);
            // 
            // buttonCopy
            // 
            this.buttonCopy.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonCopy.Location = new System.Drawing.Point(352, 328);
            this.buttonCopy.Name = "buttonCopy";
            this.buttonCopy.Size = new System.Drawing.Size(72, 24);
            this.buttonCopy.TabIndex = 4;
            this.buttonCopy.Text = "Copy";
            this.buttonCopy.Click += new System.EventHandler(this.buttonCopy_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
            this.ClientSize = new System.Drawing.Size(616, 361);
            this.Controls.Add(this.buttonCopy);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.checkGreyScale);
            this.Menu = this.mainMenu1;
            this.Name = "Form1";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Tile Bar";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tabControl1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.ResumeLayout(false);

        }
        #endregion

        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main() 
        {
            Application.Run(new Form1());
        }

        private void menuFileExit_Click(object sender, System.EventArgs e)
        {
            Application.Exit();
        }

        private void checkGreyScale_CheckedChanged_1(object sender, System.EventArgs e)
        {
            m_tb.GreyScale = (checkGreyScale.Checked);
            //pictTileBar.Image = m_tb.Render();
            panel1.BackgroundImage = m_tb.RenderOriginal();
        }

        private void buttonCopy_Click(object sender, System.EventArgs e)
        {
            Clipboard.SetDataObject(m_tb.RenderOriginal());
        }

        private void Form1_Load(object sender, System.EventArgs e)
        {
            panel1.BackgroundImage = m_tb.RenderOriginal();
            //pictTileBar.Image = m_tb.Render();
        }

        private void panel1_Resize(object sender, System.EventArgs e)
        {
            if (m_lastWidth != panel1.Width)
            {
                m_lastWidth = panel1.Width;
                m_tb.ChangeDimensions(panel1.Width, -1);
                //pictTileBar.Image = m_tb.Render();
                panel1.BackgroundImage = m_tb.RenderOriginal();
            }
        }
	}
}
