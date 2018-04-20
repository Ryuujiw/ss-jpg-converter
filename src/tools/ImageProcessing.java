package tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JTextArea;

public class ImageProcessing {
	
	public Image convertBytesToImage(byte[] byteArrayOfImageRaw) throws IOException{
	
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOfImageRaw);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
			
		//encoding and decoding
	    ImageReader reader = (ImageReader) readers.next();
	    Object source = bis; 
	    ImageInputStream iis = ImageIO.createImageInputStream(source); 
	    reader.setInput(iis, true);
	    ImageReadParam param = reader.getDefaultReadParam();
	    Image imageProcessed = reader.read(0, param); //got an image file
		
		return imageProcessed;
	} //converts bytes to image 
	
	public void writeOutput(Image imageProcessed, String outputDirectory, File file, JTextArea txt_consoleLog) throws IOException{
		//I should use a hashmap arrayList with File[] maybe.
			
		//bufferedImage is the RenderedImage to be written
		BufferedImage bufferedImage = new BufferedImage(imageProcessed.getWidth(null), imageProcessed.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(imageProcessed, null, null);
			
		File imageFile = new File(outputDirectory + "/"+ file.getName()+".jpg");
		ImageIO.write(bufferedImage, "jpg", imageFile);
			
		txt_consoleLog.append(imageFile.getPath()+" created.\n");
	}
}
