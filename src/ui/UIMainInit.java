package ui;

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

import main.ButtonListeners;

public class UIMainInit {

	private JButton btn_browse, btn_convert, btn_exit, btn_chooseDir;
	private JTextArea txt_files, txt_consoleLog;
	private JScrollPane scrollFiles, scrollConsole;
	private JTextField txt_outputDir;
	
	public UIMainInit(){
		JFrame frame = initialize();
		informationPanelCreator(frame);
		fileSystemPanelCreator(frame);
		consoleLogPanelCreator(frame);
		ButtonListeners btnListen = new ButtonListeners(btn_browse, btn_convert, btn_exit, btn_chooseDir, txt_files, txt_consoleLog, txt_outputDir);
	}
	
	public JFrame initialize(){
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		return frame;
	}
	
	public void informationPanelCreator(JFrame frame){
		JPanel informationPanel = new JPanel();
		
		JLabel lbl_title = new JLabel(".ss to .jpg image converter.");
		lbl_title.setPreferredSize(new Dimension(400, 30));
		
		JTextArea txt_instructions = new JTextArea(5, 40);
		txt_instructions.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
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
		
		txt_files = new JTextArea(7,40);
		txt_files.setEditable(false);
		
		scrollFiles = new JScrollPane(txt_files);
		scrollFiles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFiles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		txt_outputDir = new JTextField(29);
		txt_outputDir.setEditable(false);
		
		btn_chooseDir = new JButton("...");
		
		btn_convert = new JButton("Convert");

		txt_consoleLog = new JTextArea(7,40);
		txt_consoleLog.setEditable(false);
		
		scrollConsole = new JScrollPane(txt_consoleLog);
		scrollConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		fileSystemPanel.add(btn_browse);
		fileSystemPanel.add(scrollFiles);
		fileSystemPanel.add(txt_outputDir);
		fileSystemPanel.add(btn_chooseDir);
		fileSystemPanel.add(btn_convert);
		fileSystemPanel.add(scrollConsole);
		
		frame.add(fileSystemPanel, BorderLayout.CENTER);
	}
	
	public void consoleLogPanelCreator(JFrame frame){
		JPanel consoleLogPanel = new JPanel();
		
		btn_exit = new JButton("Exit");
		btn_exit.setPreferredSize(new Dimension(100, 25));
		
		consoleLogPanel.add(btn_exit);
		
		frame.add(consoleLogPanel, BorderLayout.SOUTH);
	}
}
