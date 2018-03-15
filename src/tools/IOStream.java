package tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ui.Main;

public class IOStream {
	
	public ByteArrayOutputStream filterBytes(File[] files) throws FileNotFoundException{
		
		ByteArrayOutputStream bos = null;
		
		for(File f: files){
			FileInputStream fis = new FileInputStream(f);
			//input raw bytes from file system
			
			bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			
			try{
				for(int readNum; (readNum = fis.read(buf)) != -1;){
					bos.write(buf, 0, readNum);
					System.out.println("read "+readNum +" bytes,");
				}
			} catch (IOException e){
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
			}
			
			//implement WrapperRemover.java
			
		}
		
		return bos;
		
	}
}
