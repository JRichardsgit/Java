import java.io.*;
public class Assignment3 {
	public static void main(String[] args) {
		BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
		String input = new String();
		
	
	
	try {
		while(true) {
			System.out.println("Enter the INFIX expression to evaluate: ");
			input = keyboardReader.readLine();
			break;
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}

	InfixCalculator w2 = new InfixCalculator(input);
	w2.evaluateInfix();
	}
}


