# ss-jpg-converter

This program's main purpose is to convert .ss files (FF15 screenshots files) to .jpg image files. 

I will achieve this by first reading the bytes in the individual files. The bytes will be stored in a byte array. 

And then from the byte array, a line of code will copy the bytes (excluding the ss header and trailer) to a new array. I am also assuming that the wrapper length is always fixed. 

Finally the bytes will be encoded using the ImageIO class and then the output will be a .jpg image file. 

