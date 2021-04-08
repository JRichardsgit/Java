
public class TestTowersofHanoi {
	private int stepNumber = 1;
	public void solveTowers(int n, String start, String end, String spare) {
		if (n==1) {	
			System.out.println(stepNumber++ + ": Move disk from " + start + " to " + end);
		}
		else {
			solveTowers(n-1, start, spare, end);
			System.out.println(stepNumber++ + ": Move disk from " + start + " to " + end);
			solveTowers(n-1, spare, end, start);
		}
	}	

	public static void main(String[] args) {
		TestTowersofHanoi Tower = new TestTowersofHanoi();
		Tower.solveTowers(4, "a", "c", "b");

	}

}
