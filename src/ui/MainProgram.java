package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainProgram {

	private JFrame frame;
	private JTextField textField;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("SS to JPG Converter");
		label.setBounds(10, 11, 114, 14);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("1. Select files and output directory. \r\n2. Click Convert. \r\n3. Done. ");
		textArea.setBounds(10, 36, 308, 63);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("Browse Files");
		button.setBounds(10, 115, 106, 23);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("Save to.. ");
		label_1.setBounds(10, 163, 65, 14);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 183, 456, 23);
		frame.getContentPane().add(textField);
		
		JButton button_1 = new JButton("Convert");
		button_1.setBounds(10, 246, 106, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("Status");
		label_2.setBounds(10, 280, 46, 14);
		frame.getContentPane().add(label_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 305, 544, 93);
		frame.getContentPane().add(textArea_1);
		
		JButton button_2 = new JButton("Exit ");
		button_2.setBounds(465, 435, 89, 23);
		frame.getContentPane().add(button_2);
	}
}
