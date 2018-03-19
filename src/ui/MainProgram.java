package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.*;
import tools.*;
import javax.swing.JScrollPane;

public class MainProgram {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProgram window = new MainProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainProgram() {
		initialize();
		UICreator();
		ButtonCreator();
	}
	/**
	 * Initialize the contents of the frame
	 * then the UI and the buttons.
	 */
	
	private void ButtonCreator(){
		JButton btn_browse = new JButton("Browse Files");
		btn_browse.setBounds(10, 115, 158, 23);
		frame.getContentPane().add(btn_browse);
		
		JButton btn_convert = new JButton("Convert");
		btn_convert.setBounds(10, 272, 158, 23);
		frame.getContentPane().add(btn_convert);
		
		JButton btn_exit = new JButton("Exit ");
		btn_exit.setBounds(465, 435, 89, 23);
		frame.getContentPane().add(btn_exit);
		
	}
	
	private void UICreator(){
		JLabel lbl_title = new JLabel("SS to JPG Converter");
		lbl_title.setBounds(10, 11, 228, 14);
		frame.getContentPane().add(lbl_title);	
	
		JLabel lbl_outputDir = new JLabel("Save to.. ");
		lbl_outputDir.setBounds(10, 218, 158, 14);
		frame.getContentPane().add(lbl_outputDir);
		
		JLabel lbl_status = new JLabel("Status");
		lbl_status.setBounds(10, 306, 46, 14);
		frame.getContentPane().add(lbl_status);
		
		JTextField txt_outputDir = new JTextField();
		txt_outputDir.setColumns(10);
		txt_outputDir.setBounds(10, 238, 456, 23);
		frame.getContentPane().add(txt_outputDir);
		
		JTextArea instructions = new JTextArea();
		instructions.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
		instructions.setBounds(10, 36, 308, 63);
		frame.getContentPane().add(instructions);
		//instructions
		
		JTextArea txt_log = new JTextArea();
		txt_log.setBounds(10, 331, 544, 93);
		frame.getContentPane().add(txt_log);
	
	}

	private void ActionListener(){
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
}
