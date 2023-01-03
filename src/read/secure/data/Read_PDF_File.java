package read.secure.data;

import java.io.File;

public class Read_PDF_File {
	
	private static final String locationFile="";
	
	
	public static File getPDFile()
	{
			
		return readFile();
	}
	
	
	
	
	private static File readFile()
	{
		
		  File file = new File(locationFile);
		    if (file.exists()) {
		        return file;
		    } else {
		        throw new RuntimeException("File not found: " + locationFile);
		    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
