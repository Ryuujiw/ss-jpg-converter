package tools;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SelectFiles {
	
	public File[] selectFiles(JTextArea txt_files){
		
		File[] files = null;
		
		JButton open = new JButton();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setDialogTitle("Select Files to Convert");
		
		if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
			files = fileChooser.getSelectedFiles();
			
			for(File f: files){
				txt_files.append(f.getName() + "\n");
			}
		}
		
		return files;
	}
	
	public String chooseOutputDirectory(JTextField txt_outputDir){
		
		JButton open = new JButton();
		String outputDir = "";
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select an output directory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) { 

			outputDir = fileChooser.getSelectedFile().getPath();
			
		    txt_outputDir.setText(outputDir);
		}
		
		return outputDir;
	}
}
