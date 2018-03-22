package ui;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import tools.IOStream;
import tools.ImageProcessing;
import tools.SelectFiles;

public class UIMainInit implements ActionListener {

	private JButton btn_browse, btn_convert;
	private JTextArea txt_files;
	private JScrollPane scrollFiles;
	private SelectFiles sf;
	private IOStream ios;
	private ImageProcessing ip;
	private File[] files; 
	
	public UIMainInit(){
		JFrame frame = initialize();
		informationPanelCreator(frame);
		fileSystemPanelCreator(frame);
		consoleLogPanelCreator(frame);
	}
	
	public JFrame initialize(){
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		sf = new SelectFiles();
		ios = new IOStream();
		ip = new ImageProcessing();
		
		return frame;
	}
	
	public void informationPanelCreator(JFrame frame){
		JPanel informationPanel = new JPanel();
		
		JLabel lbl_title = new JLabel(".ss to .jpg image converter.");
		lbl_title.setPreferredSize(new Dimension(400, 30));
		
		JTextArea txt_instructions = new JTextArea();
		txt_instructions.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
		txt_instructions.setPreferredSize(new Dimension(400, 90));
		txt_instructions.setEditable(false);
		
		informationPanel.add(lbl_title);
		informationPanel.add(txt_instructions);
		
		frame.add(informationPanel, BorderLayout.NORTH);
	}
	
	public void fileSystemPanelCreator(JFrame frame){
		JPanel fileSystemPanel = new JPanel();
		fileSystemPanel.setLayout(new FlowLayout());
		
		btn_browse = new JButton("Browse");
		btn_browse.setPreferredSize(new Dimension(100, 25));
		btn_browse.addActionListener(this);
		
		txt_files = new JTextArea(7,35);
		txt_files.setEditable(false);
		
		scrollFiles = new JScrollPane(txt_files);
		scrollFiles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		btn_convert = new JButton("Convert");
		btn_convert.addActionListener(this);
		
		fileSystemPanel.add(btn_browse);
		fileSystemPanel.add(scrollFiles);
		fileSystemPanel.add(btn_convert);
		
		frame.add(fileSystemPanel, BorderLayout.CENTER);
	}
	
	public void consoleLogPanelCreator(JFrame frame){
		JPanel consoleLogPanel = new JPanel();
		
		JLabel test = new JLabel("Log");
		consoleLogPanel.add(test);
		
		frame.add(consoleLogPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new UIMainInit();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btn_browse){
			
			files = sf.selectFiles(txt_files);
			
		} else if(obj == btn_convert){
			
			try {
				ios.filterBytes(files);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
