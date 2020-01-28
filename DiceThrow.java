package lab3;
import cse131.ArgsProcessor;
public class DiceThrow {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		int numDie= ap.nextInt("How many die will you throw? ");
		int numThrows = ap.nextInt("How many times will you throw them?");

		int[][] roll = new int[numThrows][numDie];
		int sum=0;

		int[] counter = new int[numDie*numThrows];

		System.out.println("Numbers shown on die");
		System.out.println("----------");

		//makes a new array for sums that is the length of number of throws
		for (int i=0;i<numThrows; ++i) {
			sum=0;

			for (int j=0; j<numDie; ++j) {


				int dieSide = (int)(Math.random()* 6 +1);

				roll[i][j] = dieSide;
				sum=sum+dieSide;
				counter[i]=sum;


			}

		}
		//this gives me the TOTAL sum of all the rows and also lets me roll random values. 


		for (int i=0; i<numThrows; ++i) {
			for (int j=0; j<numDie; ++j) {
				System.out.print(roll[i][j] + " ");

			}
			System.out.println();

		}
		System.out.println("-----------");

		
		int t=0;

		for (int i=0;i<numThrows; ++i) {
			int sameNumber = 0;
			
			for (int j=1; j<numDie; ++j) {

				boolean same = (roll[i][j] == roll[i][j-1]);
				if (same) {
					sameNumber = sameNumber +1;
				}
			}


			if (sameNumber == (numDie-1)) {
				t=t+1;
			}
		}




		double percent = (((double)t/numThrows));

		System.out.println("the die rolled the same number " + 100*percent + " percent of the time");
		System.out.println();


		System.out.println("Sum of Die Rolls");
		System.out.println();



		int[] sumCounter = new int[6*numDie];

		//below I successfully compute the sum of each throw. 
		for (int i=0; i<numThrows; ++i) {

			sumCounter[counter[i]-1]=sumCounter[counter[i]-1] + 1;
			System.out.println("Sum of roll " + (i+1) + ": " + counter[i]);

		}
		System.out.println();
		System.out.println("__________");


		//below here says how many times the sum shows up. 
		for (int i=0; i<sumCounter.length; ++i) {

			if (sumCounter[i]>0){
				System.out.println("the sum " + (i+1) + " shows up " + sumCounter[i] + " times");

			}


		}
	}
}


