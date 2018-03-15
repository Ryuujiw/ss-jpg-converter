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

public class ImageProcessing {
	
	public Image convertBytesToImage(byte[] byteArray) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
		
		//encoding and decoding
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source); 
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        Image image = reader.read(0, param); //got an image file
        
        return image;
	} //converts bytes to image 
	
	public void writeOutput(Image image, String outputDirectory) throws IOException{
		//bufferedImage is the RenderedImage to be written
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
	
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, null, null);
		
		File imageFile = new File(outputDirectory);
		ImageIO.write(bufferedImage, "jpg", imageFile);
		
		System.out.println(imageFile.getPath());
	}
	
	
}
