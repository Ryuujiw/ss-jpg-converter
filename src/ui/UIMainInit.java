package ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UIMainInit implements ActionListener {

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
		
		return frame;
	}
	
	public void informationPanelCreator(JFrame frame){
		JPanel informationPanel = new JPanel();
		
		JLabel test = new JLabel("Diamonds");
		informationPanel.add(test);
		
		frame.add(informationPanel, BorderLayout.NORTH);
	}
	
	public void fileSystemPanelCreator(JFrame frame){
		JPanel fileSystemPanel = new JPanel();
		
		JLabel test = new JLabel("Bracelets");
		fileSystemPanel.add(test);
		
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
		
	}
}
