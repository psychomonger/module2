/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 2 | SDLC Assignment
 * 
 * This class handles the methods related to accessing files.
***********************************************************************/
package package1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
	
	// Get text from file.
	public String readFileAsString(String fileURL) {
		
		String text = "";
		
		try {  
			
			text = new String(Files.readAllBytes(Paths.get(fileURL)));
		
		} catch (IOException e) {
			
			e.printStackTrace();	    
		
		}

	    return text;
	  }
		
}
