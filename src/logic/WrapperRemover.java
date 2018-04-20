package logic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WrapperRemover {

	private int headerLength;
	private int trailerLength;

	public WrapperRemover(int headerLength, int trailerLength){
		this.headerLength = headerLength;
		this.trailerLength = trailerLength;
	}
	
	public byte[] removeWrapper(byte[] bytes) throws FileNotFoundException, IOException{
		
		byte[] wrapperRemoved = Arrays.copyOfRange(bytes, headerLength, bytes.length - trailerLength);
		
		//wrapper removed 
		
		return wrapperRemoved;
	}
}
