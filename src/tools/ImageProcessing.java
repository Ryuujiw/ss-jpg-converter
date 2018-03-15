package tools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageProcessing {
	
	public void convertBytesToImage(byte[] byteArray) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
		
		//encoding and decoding
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source); 
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
	} //converts bytes to image 
	
	
	
}
