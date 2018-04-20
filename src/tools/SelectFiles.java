package tools;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SelectFiles {
	
	private JFileChooser fileChooser;
	private JButton open = new JButton();
	public File[] selectFiles(JTextArea txt_files){
		
		File[] files = null;
		
		fileChooser = new JFileChooser();
		
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setDialogTitle("Select Files to Convert");
		
		if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
			files = fileChooser.getSelectedFiles();
			
			for(File f: files){
				txt_files.append(f.getName() + "\n");
			}
		}
		
		fileChooser = null;
		
		return files;
	}
	
	public String chooseOutputDirectory(JTextField txt_outputDir){
		
		String outputDir = "";
		
		fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Select an output directory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) { 

			outputDir = fileChooser.getSelectedFile().getPath();
			
		    txt_outputDir.setText(outputDir);
		}
		
		fileChooser = null;
		
		return outputDir;
	}
}
