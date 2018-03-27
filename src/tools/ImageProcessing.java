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
import javax.swing.JTextArea;

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
	
	public void writeOutput(ArrayList<Image> imageProcessed, String outputDirectory, File[] files, JTextArea txt_consoleLog) throws IOException{
		
		int index = 0;
		
		for(Image ip: imageProcessed){
			
			//bufferedImage is the RenderedImage to be written
			BufferedImage bufferedImage = new BufferedImage(ip.getWidth(null), ip.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
			Graphics2D g2 = bufferedImage.createGraphics();
			g2.drawImage(ip, null, null);
			
		
			File imageFile = new File(outputDirectory + "\\"+ files[index].getName()+".jpg");
			ImageIO.write(bufferedImage, "jpg", imageFile);
			
			txt_consoleLog.append(imageFile.getPath()+"\n");
			index ++;
		}
	}
}
