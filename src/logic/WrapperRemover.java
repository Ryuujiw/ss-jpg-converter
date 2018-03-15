package logic;

import java.util.Arrays;

public class WrapperRemover {
	
	private byte[] bytes;
	private int headerLength;
	private int trailerLength;

	public WrapperRemover(byte[] bytes, int headerLength, int trailerLength){
		this.bytes = bytes;
		this.headerLength = headerLength;
		this.trailerLength = trailerLength;
	}
	
	public byte[] removeWrapper(){
		byte[] wrapperRemoved = Arrays.copyOfRange(bytes, headerLength, bytes.length - trailerLength);
		//wrapper removed 
		
		return wrapperRemoved;
	}
}
