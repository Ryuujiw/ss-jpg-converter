package main;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

import tools.IOStream;
import tools.ImageProcessing;
import tools.SelectFiles;

public class ButtonListeners implements ActionListener {
	
	private JButton btn_browse, btn_convert, btn_exit;
	private File[] files;
	private JTextArea txt_files;
	private SelectFiles sf;
	private IOStream ios;
	private ImageProcessing ip;
	private ArrayList<byte[]> imagesRaw;
	private ArrayList<Image> imagesProcessed;
	
	public ButtonListeners(JButton btn_browse, JButton btn_convert, JButton btn_exit, JTextArea txt_files){
		this.btn_browse = btn_browse;
		this.btn_convert = btn_convert;
		this.btn_exit = btn_exit;
		this.txt_files = txt_files;
		
		btn_browse.addActionListener(this);
		btn_convert.addActionListener(this);
		btn_exit.addActionListener(this);
		
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
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
		
}
