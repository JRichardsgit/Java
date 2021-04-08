import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Assignment4 {

	
	public <T extends Comparable<? super T>> void recursiveSelectionSort (T[] theArray, int n) {
		T lowest=theArray[theArray.length-n];				//the initial guess at lowest is the first element
		int index=0;
		if(n==1)											// base case if n=1 done
			return;
		for(int i=theArray.length-n; i<n;i++) {				//iterate through array starting at length-n initially length = 4, n=4, i=0:
			if(theArray[i].compareTo(lowest)<0) {			//(as n decreases each recursive call index of lowest spot to search i increases)
				lowest=theArray[i];							//if i element is smaller than lowest, set it as new lowest and record index
				index = i;
			}
		}
		T temp=theArray[theArray.length-n];					//store element to be replaced in temp
		theArray[theArray.length-n]=lowest;					// set element to lowest
		theArray[index] = temp;								//set element at index(old lowest index) to temp
		recursiveSelectionSort(theArray,n-1);				//call Selection sort again with reduced n
	}
	
	
	public <T extends Comparable<? super T>> void recursiveBubbleSort (T[] theArray, int n) {
		if(n==1)													//Base case return
			return;

		for(int i=0; i<n-1; i++) {									// take the largest element to the end
				if(theArray[i].compareTo(theArray[i+1])>0) {		//if i is greater than i+1 swap them
					T temp=theArray[i+1];						
					theArray[i+1] = theArray[i];
					theArray[i] = temp;
				}	
		}
		recursiveBubbleSort(theArray,n-1);					// recursive case: call with reduced n
	}
	
	public boolean isInLanguage(String str) {
		Queue<Character> q = new LinkedList <Character>();
		Stack<Character> s = new Stack<Character>();
		boolean found = false;								//initial state of not found $
		for(char ch: str.toCharArray()) {
			if(ch == '$') 									// if found special character set found to true
				found =true;
			else if(found)									// if found push characters to stack
				s.push(ch);
			else
				q.add(ch);									// if not found add to queue
		}
		while(!q.isEmpty()) {								//remove from q and stack	
			if(q.remove()!=s.pop())							//compare characters
				return false;								// return false if any fail
		}
		return true;										//if all match return true
	}
	
	public int convertToNumber(String str) {				
		Queue<Integer> digits = new LinkedList<Integer>();
		for(char ch: str.toCharArray()) {
			if(Character.isDigit(ch)) {						//check if each char is an integer
				digits.add(Character.getNumericValue(ch));	//add to queue
			}
		}

		int result=0;
		while(!digits.isEmpty()) {							//while digits in queue
			result = ((result*10) + digits.remove()); 		//multiply result by 10 then add next digit
		}		
		return result;
	}
	
}
