package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Main extends JFrame {
	private JTextField txt_outputDirectory;
	public Main() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("SS to JPG Converter");
		lbl_title.setBounds(10, 11, 114, 14);
		getContentPane().add(lbl_title);
		
		JTextArea txt_instructions = new JTextArea();
		txt_instructions.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
		txt_instructions.setBounds(10, 36, 308, 63);
		getContentPane().add(txt_instructions);
		
		JTextArea txt_log = new JTextArea();
		txt_log.setBounds(10, 305, 544, 93);
		getContentPane().add(txt_log);
		
		JLabel lbl_status = new JLabel("Status");
		lbl_status.setBounds(10, 280, 46, 14);
		getContentPane().add(lbl_status);
		
		JButton btn_browseFiles = new JButton("Browse Files");
		btn_browseFiles.setBounds(10, 115, 106, 23);
		getContentPane().add(btn_browseFiles);
		
		JButton btn_exit = new JButton("Exit ");
		btn_exit.setBounds(465, 435, 89, 23);
		getContentPane().add(btn_exit);
		
		JButton btn_convert = new JButton("Convert");
		btn_convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_convert.setBounds(10, 246, 106, 23);
		getContentPane().add(btn_convert);
		
		txt_outputDirectory = new JTextField();
		txt_outputDirectory.setBounds(10, 183, 456, 23);
		getContentPane().add(txt_outputDirectory);
		txt_outputDirectory.setColumns(10);
		
		JLabel lbl_saveTo = new JLabel("Save to.. ");
		lbl_saveTo.setBounds(10, 163, 65, 14);
		getContentPane().add(lbl_saveTo);
	}
}
