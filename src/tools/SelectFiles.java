package tools;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class SelectFiles {
	
	public File[] selectFiles(){
		
		File[] files = null;
		
		JButton open = new JButton();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setDialogTitle("Select Files to Convert");
		fileChooser.showOpenDialog(null);
		
		if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
			files = fileChooser.getSelectedFiles();
		}
		
		return files;
	}
	
}
