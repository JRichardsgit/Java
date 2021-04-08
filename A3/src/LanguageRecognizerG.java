public class LanguageRecognizerG{
private	String str;

	public LanguageRecognizerG(String string) {	//constructor
		str = string;
	}
	
	public boolean recursiveRecogG(String str) {
		if (str.isEmpty()) {						//check if string is empty base case 1
			return true;
		}
		else {
			if (str.startsWith("&")|str.startsWith("#")) { // base case 2
				return true;
			}
			else if((str.startsWith("W")|str.startsWith("A"))&(str.endsWith("&")|str.endsWith("#"))) {	//Base case 3
				return true;
			}
			else if((str.startsWith("&")|str.startsWith("#"))&(str.endsWith("W")|str.endsWith("A"))) { // recursive case called with smaller string
				return recursiveRecogG(str.substring(1, str.length()));
			}
		}
		return false;
	}
	
	public void recursivePrintG() {
		if(recursiveRecogG(this.str)){					//if no problem found print good
			System.out.println("Recursion: Word "+this.str+" IS a word of the G language");
		}
		else {
			System.out.println("Recursion: Word "+this.str+" IS NOT a word of the G language");
		}	
	}

}
