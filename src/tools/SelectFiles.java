package tools;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

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
	
}
