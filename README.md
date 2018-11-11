# ss-jpg-converter

This program is for converting SS files (Final Fantasy 15 screenshots files) to the JPG format. 

SS is a file format introduced in Final Fantasy 15. It is comprised of JPG data being wrapped in some custom header bits.

This program carries out the conversion process by extracting the JPG data out of the SS files. This is achieved by first reading the bytes in the individual SS files. The bytes are then stored in a byte array. The wrapper length for the custom header bits are assumed to be fixed (corresponding to Final Fantasy 15). The data after the custom header bits are then copied into a new array. The bytes are then encoded using the ImageIO class to output JPG image files.

Dependencies:
1. Java Swing (used for program's GUI)

Java Swing is included in all JDK releases from Oracle. This project can be built with just a standard Java JDK.

This project also includes Eclipse setting files for those who want to build in Eclipse directly.

Use case:
1. Build project (optionally: import project into Eclipse and directly Build) with any Java JDK.
2. Run built JAR.