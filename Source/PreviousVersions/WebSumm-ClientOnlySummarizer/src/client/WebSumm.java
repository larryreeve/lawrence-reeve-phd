package client;

import java.util.List;

import client.freqdist.FreqDistSummarizer;
import client.freqdist.Sentence;
import client.splitters.SentenceSplitter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebSumm implements EntryPoint, WindowResizeListener
{
	public void onModuleLoad() 
	{
	    // Left input
	    final Label inputCaption = new Label("Input text to be summarized:");
	    final TextArea inputText = new TextArea();
	    inputText.setCharacterWidth(80);
	    inputText.setVisibleLines(25);
      
	    final Button buttonSummarize = new Button("Summarize");
      
	    final Label summarySizeCaption = new Label("Summary Size (% of original):");
	    final ListBox summarySizeListBox = new ListBox();
	    for (int idx=1; idx <= 100; idx++)
	        summarySizeListBox.addItem(Integer.toString(idx));
	    summarySizeListBox.setMultipleSelect(false);
	    summarySizeListBox.setVisibleItemCount(1);
	    summarySizeListBox.setItemSelected(9, true);
      
	    HorizontalPanel inputOptions  = new HorizontalPanel();
	    inputOptions.setWidth("100%");
	    inputOptions.add(buttonSummarize);
	    inputOptions.add(summarySizeCaption);
	    inputOptions.add(summarySizeListBox);
	    inputOptions.setCellHorizontalAlignment(summarySizeCaption, HasHorizontalAlignment.ALIGN_RIGHT);
	    inputOptions.setCellHorizontalAlignment(summarySizeListBox, HasHorizontalAlignment.ALIGN_RIGHT);
	    
	    HTML inputPaperReference = new HTML("<br>" + 
	                                        "<br>" + 
	                                        "<br>" +
	                                        "This summarizer implements the frequency distribution summarization algorithm using terms and is based on the following paper:" +
	                                        "<br>" +
	                                        "Lawrence Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006)." + 
	                                        "<br>" + 
	                                        "<EM><A href=\"pubs/2006CIKM.pdf\" onClick=\"javascript:urchinTracker ('pubs/CIKM2006');\">Concept Frequency Distribution in Biomedical Text Summarization</A>.</EM>" +
	                                        "<br>" +
	                                        "<A href=\"http://sa1.sice.umkc.edu/cikm2006/\"> <FONT face=\"Times New Roman\">Proceedings of the 15th Conference on Information and Knowledge Management</FONT></A>" +
	                                        "<FONT face=\"Times New Roman\"></FONT><A href=\"http://www.cs.iupui.edu/%7Ebioin/\"></A>." +
	                                        "<br>" +
	                                        "<br>");

      
	    VerticalPanel panelInput = new VerticalPanel();
	    panelInput.add(inputCaption);
	    panelInput.add(inputText);
	    panelInput.add(inputOptions);
	    panelInput.add(inputPaperReference);
	    panelInput.setWidth("100%");
		  
	    // Right output
        final Label outputCaption = new Label("System-generated Summary:");
          
        final TextArea outputText = new TextArea();
        outputText.setCharacterWidth(80);
        outputText.setVisibleLines(25);
        outputText.setReadOnly(true);
          
        VerticalPanel panelOutput = new VerticalPanel();
        panelOutput.add(outputCaption);
        panelOutput.add(outputText);
        panelOutput.setWidth("100%");

		// Main Panel
        HorizontalSplitPanel panelMain = new HorizontalSplitPanel();      
		panelMain.setLeftWidget(panelInput);
		panelMain.setRightWidget(panelOutput);
		panelMain.setWidth("100%");
		panelMain.setHeight("100%");

		Window.addWindowResizeListener(this);
		RootPanel.get().add(panelMain);
		  
		DeferredCommand.addCommand(
		        new Command() 
		        {
		            public void execute() 
		            {
		                onWindowResized(Window.getClientWidth(), Window.getClientHeight());
		            }
		        });

		onWindowResized(Window.getClientWidth(), Window.getClientHeight());
		  
		  
		inputText.addChangeListener(new ChangeListener() 
		{
		    public void onChange(Widget sender) 
		    {
		        //outputText.setText("");
		    }
		});
		  
		inputText.addKeyboardListener(new KeyboardListenerAdapter() 
		{
		    public void onKeyPress(Widget sender, char keyCode, int modifiers) 
		    {
		        String outputTextValue = outputText.getText();
	    	  
		        if (outputTextValue != null && outputTextValue.length() > 0)
		            outputText.setText("");
		    }
	    });

		  
		buttonSummarize.addClickListener(new ClickListener() 
		{
		    SentenceSplitter splitter = new SentenceSplitter();

			public void onClick(Widget sender) 
			{
			    buttonSummarize.setEnabled(false);
			      
				outputText.setText("Please wait...summarizing the source text.");
				  
				String inputTextValue = inputText.getText();
				if (inputTextValue != null && inputTextValue.length() > 0)
				{
				    List sourceSentences = this.splitter.split(inputTextValue);
				      
				    long startSummaryTime = System.currentTimeMillis();
				    List summarySentences = FreqDistSummarizer.summarize(sourceSentences, Integer.valueOf(summarySizeListBox.getValue(summarySizeListBox.getSelectedIndex())).intValue());
				    long endSummaryTime = System.currentTimeMillis();
				    long elapsedSummaryTime = endSummaryTime - startSummaryTime;
				      
                    StringBuffer outputTextValue = new StringBuffer();

                    // Display summary information
                    outputTextValue.append("Summary Generation Information:\n");
				    outputTextValue.append("    There are " + sourceSentences.size() + " source sentences.\n");
				    outputTextValue.append("    There are " + summarySentences.size() + " summary sentences.\n");
				    outputTextValue.append("    Summary generation time: " + elapsedSummaryTime + " milliseconds.\n");
				    outputTextValue.append("\n\n");
				      
                    outputTextValue.append("The following source sentences were selected as summary sentences:\n");
                    outputTextValue.append("  (Bracketed numbers indicate the original source sentence number)\n");
                    outputTextValue.append("\n\n");
				      
					for (int idx=0; idx < summarySentences.size(); idx++)
					{
					    Sentence sentence = (Sentence) summarySentences.get(idx);
					    
					    outputTextValue.append("[" + sentence.getSentenceNumber() + "]: " + sentence.getSentenceText());
						outputTextValue.append("\n");
						  
//						  List words = sentence.getWords();
//						  for (int idx2=0; idx2 < words.size(); idx2++)
//						  {
//						      outputTextValue.append((String) words.get(idx2) + "\n");
//						  }
						  
						outputTextValue.append("\n\n");
					}
					outputText.setText(outputTextValue.toString());
				}
				else
				{
				    outputText.setText("");				      
				}
				buttonSummarize.setEnabled(true);
			}
		});
	}
	  
    public void onWindowResized(int width, int height) 
    {
        //inputText.setText(width + ", " + height + "\n" + inputText.getOffsetWidth() + ", " + inputText.getOffsetHeight());
    }
}
