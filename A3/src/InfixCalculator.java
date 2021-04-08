
public class InfixCalculator {
	private StackListBased<Character> astack = new StackListBased<Character>();		//create a character stack for changing infix to postfix
	private StackListBased<Integer> stack = new StackListBased<Integer>();		//create int stack for calculating postfix
	private String infix;
	
	public InfixCalculator(String infix) {			//constructor 
		this.infix = infix; 
	}
	
	
	public void evaluateInfix() {			//printing method
		System.out.println("infix: " + this.infix);
		System.out.println("postfix: " + convertPostfix(this.infix));
		System.out.println("result: " + getPostfix(convertPostfix(this.infix)));
		
	}
	public String convertPostfix(String infix) {		//converts an infix expression to a postfix one
		String postfix = "";							//create an empty string to build on
		astack.createStack();							// create the stack
		for(char ch: infix.toCharArray()) {				//check if each char is a digit 
			if(Character.isDigit(ch)) {
				postfix = postfix + Character.toString(ch);	//if it is append it to the postfix string
			}
			else if(ch=='(') {								// if char is ( add to stack
					astack.push(ch);
			}
			else if(ch==')'){								// if char is ) pop untill you get to the (
					while(astack.peek()!='(') {
						postfix = postfix + Character.toString(astack.pop());
					}
					astack.pop();							// pop leftover (
			}
			else if(ch == '+'| ch == '-') {					// if low priority operator 
				while(!astack.isEmpty() & astack.peek() != '(' ) {		//if stack isnt empty and top isnt (
					postfix = postfix + Character.toString(astack.pop());	//pop and append stack
				}
				astack.push(ch);								//push new operator
			}		
			else if(ch == '*'| ch == '/') {						// if high priority operator
				while(!astack.isEmpty() & astack.peek() != '(' & (astack.peek() != '+' | astack.peek() !='-')) { // pop and append all equal value operators
					postfix = postfix + Character.toString(astack.pop());
				}
				astack.push(ch);				//push new operator
			}
			else {
				System.out.println("Invalid Character Found");
			}

		}
	while(!astack.isEmpty()) {					//add any remainy operators
		postfix = postfix + Character.toString(astack.pop());
	}
	return postfix;
}
	
	
	public int getPostfix(String postfix) {
		stack.createStack();				
		for(char ch: postfix.toCharArray()) { // look through array of chars
			if(Character.isDigit(ch)) {			// if digit push
				stack.push(Character.getNumericValue(ch));
			}
			else {
				int op2 = stack.pop();		//if operator:
				int op1 = stack.pop();     //pop last two numbers
				if(ch=='+') {				//apply appropriate operator
					int result = op1 + op2;
					stack.push(result);		//push result back on stack
				}
				else if(ch== '-') {
					int result1 = op1 - op2;
					stack.push(result1);
				}
				else if(ch== '*') {
					int result2 = op1 * op2;
					stack.push(result2);
				}
				else if(ch== '/') {
					int result3 = op1 / op2;
					stack.push(result3);

				}
			}
		}
		return stack.pop();			//done
	}
	
}
