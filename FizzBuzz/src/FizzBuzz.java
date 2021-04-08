
public class FizzBuzz{

	public void FizzBuzz1() {
		for (int i = 1; i<= 100; i++) {
			if(i%3 == 0 & i%5 == 0)
				System.out.println("Fizz Buzz");
			else if( i%3 ==0)
				System.out.println("Fizz");
			else if( i % 5 ==0)
				System.out.println("Buzz");
			else
				System.out.println(i);
		}
	}
	
	public void FizzBuzz2(int length, int Fizz, int Buzz) {
		
		for(int i =1; i<= length; i++ ) {
			String out = "";
			if( i % Fizz == 0)
				out += "Fizz ";
			if( i % Buzz == 0)
				out += "Buzz ";
			if(out == "")
				out += i ;
			System.out.println(out);
		}
	}
	
	
}
