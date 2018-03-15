package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	public Main() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("SS to JPG Converter");
		lbl_title.setBounds(10, 11, 114, 14);
		getContentPane().add(lbl_title);
		
		JTextArea txtrSelectFiles = new JTextArea();
		txtrSelectFiles.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
		txtrSelectFiles.setBounds(10, 36, 308, 63);
		getContentPane().add(txtrSelectFiles);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 305, 544, 93);
		getContentPane().add(textArea);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 280, 46, 14);
		getContentPane().add(lblStatus);
		
		JButton btnBrowseFiles = new JButton("Browse Files");
		btnBrowseFiles.setBounds(10, 115, 106, 23);
		getContentPane().add(btnBrowseFiles);
		
		JButton btnExit = new JButton("Exit ");
		btnExit.setBounds(465, 435, 89, 23);
		getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 246, 106, 23);
		getContentPane().add(btnNewButton);
	}
}
