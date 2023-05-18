/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 2 | SDLC Assignment
 * 
 * This class handles the methods related to manipulating text.
***********************************************************************/
package package1;

import java.util.ArrayList;
import java.util.Collections;

public class TextAnalyzer {
	
	// Output results to the console.
	public void outputMaxWordCount(ArrayList<String> arrayWord, ArrayList<Integer> arrayCount, int numToOutput) {
		
		for(int i = 1; i <= numToOutput; i++) {
					
			int maxVal = Collections.max(arrayCount);
			int maxIdx = arrayCount.indexOf(maxVal);
					
			System.out.println(i + " " + arrayWord.get(maxIdx) + " " + maxVal);
					
			arrayWord.remove(maxIdx);
			arrayCount.remove(maxIdx);
					
		}
		
	}
	
}
