package main;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tools.IOStream;
import tools.ImageProcessing;
import tools.SelectFiles;

public class ButtonListeners implements ActionListener {
	
	private JButton btn_browse, btn_convert, btn_exit, btn_chooseDir;
	private File[] files;
	private JTextArea txt_files, txt_consoleLog;
	private JTextField txt_outputDir;
	private SelectFiles sf;
	private IOStream ios;
	private ImageProcessing ip = new ImageProcessing();
	private ArrayList<byte[]> imagesRaw;
	private ArrayList<Image> imagesProcessed;
	private String outputDirectory;
	
	public ButtonListeners(JButton btn_browse, 
						   JButton btn_convert, 
						   JButton btn_exit, 
						   JButton btn_chooseDir, 
						   JTextArea txt_files, 
						   JTextArea txt_consoleLog,
						   JTextField txt_outputDir){
		
		this.btn_browse = btn_browse;
		this.btn_convert = btn_convert;
		this.btn_exit = btn_exit;
		this.btn_chooseDir = btn_chooseDir;
		this.txt_files = txt_files;
		this.txt_consoleLog = txt_consoleLog;
		this.txt_outputDir = txt_outputDir;
		
		btn_browse.addActionListener(this);
		btn_convert.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_chooseDir.addActionListener(this);
		
		sf = new SelectFiles();
		ios = new IOStream();
		imagesRaw = new ArrayList<byte[]>();
		imagesProcessed = new ArrayList<Image>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btn_browse){
			
			files = sf.selectFiles(txt_files);
			
			
		} else if(obj == btn_convert){
			
			try {
				imagesRaw = ios.filterBytes(files);
				imagesProcessed = ip.convertBytesToImage(imagesRaw);
				//output to dir
				
				ip.writeOutput(imagesProcessed, outputDirectory, files, txt_consoleLog);
				
				clearMemory(); //setting unused objects to null.
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if(obj == btn_exit){
			System.exit(0);
			
		} else if(obj == btn_chooseDir){
			outputDirectory = sf.chooseOutputDirectory(txt_outputDir);
		
		}
	}
	
	public void clear(){
		files = null;
		imagesRaw = null;
		imagesProcessed = null;
		outputDirectory = null;
		ip = null;
		ios = null;
	}
		
}
