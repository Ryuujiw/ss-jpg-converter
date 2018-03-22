package tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageProcessing {
	
	public ArrayList<Image> convertBytesToImage(ArrayList<byte[]> byteArrayOfImagesRaw) throws IOException{
		
		ArrayList<Image> imageProcessed = new ArrayList<Image>();
		
		for(byte[] ba: byteArrayOfImagesRaw){
			ByteArrayInputStream bis = new ByteArrayInputStream(ba);
			Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
			
			//encoding and decoding
	        ImageReader reader = (ImageReader) readers.next();
	        Object source = bis; 
	        ImageInputStream iis = ImageIO.createImageInputStream(source); 
	        reader.setInput(iis, true);
	        ImageReadParam param = reader.getDefaultReadParam();
	        Image image = reader.read(0, param); //got an image file
	        
	        imageProcessed.add(image);
		}
		return imageProcessed;
	} //converts bytes to image 
	
	public void writeOutput(ArrayList<Image> imageProcessed, String outputDirectory) throws IOException{
		
		for(Image ip: imageProcessed){
			//bufferedImage is the RenderedImage to be written
			BufferedImage bufferedImage = new BufferedImage(ip.getWidth(null), ip.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
			Graphics2D g2 = bufferedImage.createGraphics();
			g2.drawImage(ip, null, null);
			
			File imageFile = new File(outputDirectory);
			ImageIO.write(bufferedImage, "jpg", imageFile);
			
			System.out.println(imageFile.getPath());			
		}
	}
}
