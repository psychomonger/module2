/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 2 | SDLC Assignment
 * 
 * This application reads an HTML file to extract a poem for analysis;
 * specifically to count the number of occurrences of each word and
 * output a list of the most used words. This is achieved by creating 
 * two parallel arrays lists, one to record the word itself and the other 
 * to record the number of occurrences. 
***********************************************************************/
package package1;
import java.util.Arrays;
import java.util.ArrayList;


public class Application {

	public static void main(String[] args) {
		
		// Declare objects and variables.
		FileManager fm = new FileManager();
		TextAnalyzer ta = new TextAnalyzer();
		ArrayList<String> arrayWord = new ArrayList<String>();
		ArrayList<Integer> arrayCount = new ArrayList<Integer>();
		String text;
		String[] array;
		int posStartOfPoem;
		int posEndOfPoem;
		String oldWord = "";
		String newWord = "";
		int count = 0;
		
		// Input values.
		String fileURL = "C://TheRavenPoemWithHTMLTags.txt";
		String startOfTextDelim = "<h1>The Raven</h1>";
		String endOfTextDelim = "<!--end chapter-->";
		int numToOutput = 20;
		
		// Get text from file.		
		text = fm.readFileAsString(fileURL);
		
		// Get position of the start of the poem.
		posStartOfPoem = text.indexOf(startOfTextDelim);
		
		// Remove ALL text prior to the start of the poem.
		text = text.substring(posStartOfPoem);
		
		// Get position of end of the poem.
		posEndOfPoem = text.indexOf(endOfTextDelim);
		
		// Remove ALL text after the end of the poem.
		text = text.substring(0, posEndOfPoem);
		
		// Convert all HTML tags to spaces		
		text = text.replaceAll("<[^>]*>", " ");
		
		// Remove all line breaks.
		text = text.replace("\n", "").replace("\r", "");
		
		// Remove all non-alpha characters.
		text = text.replaceAll("[^A-Za-z0-9]", " ");
		
		// Replace all multiple spaces with a single space.
		text = text.trim().replaceAll(" +", " ");
		
		// Convert text to lower case.
		text = text.toLowerCase();
		
		// Covert text to array.
		array = text.split(" ");
		
		// Sort array by alphabetical order.
		Arrays.sort(array);
		
		// Iterate array to create arrayWord to create distinct list of words.
		for (int i = 0; i < array.length; i++) {
			newWord = array[i];
			if(newWord.equals(oldWord) != true) {	
				arrayWord.add(newWord);
				oldWord = newWord;
			}
		}
		
		// Iterate arrayWord and count number of occurrences in array.
		for (String word : arrayWord) {
			count = 0;
			for (int i = 0; i < array.length; i++) {
				if(word.equals(array[i])) {
					count ++;
				}
			}
			arrayCount.add(count);
		}
		
		// Output list to console.
		ta.outputMaxWordCount(arrayWord, arrayCount, numToOutput);
	
	}
	
}
