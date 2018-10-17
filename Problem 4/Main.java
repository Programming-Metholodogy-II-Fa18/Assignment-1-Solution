public class Main {
	
	static ArbitraryQueueArray<Integer> sums = new ArbitraryQueueArray<Integer>();
	
	public static void main(String[] args) {
		
		System.out.println(ProblemFourA("testing"));
		
		int[][] a = {
				{1,2,3,4,5},
				{1,2,3,4,5}
		};
		
		ProblemFourB(a,6);
		
		System.out.println(ProblemFourC(100));
		
		
	}
	
	
	public static String ProblemFourA(String input) {
		// this is also easily solved by doing a reverse for loop over the string
		ArbitraryQueue<Character> aq = new ArbitraryQueue<Character>();
		for(int i = 0; i < input.length(); i++) {
			aq.Push(input.charAt(i));
		}

		String output = "";
		int j = aq.totalNodes;
		for(int i = 0; i < j; i++) {
			output = output + aq.Pop();
		}

		return output;

		
		
	}
	

	
	public static void ProblemFourB (int[][] a, int sum) {
		
		// we can solve this by using recursion repeatedly over the elements of the array while keeping track of prior numbers in a stack
		
		
		int[] b = new int[a.length*a[0].length];
		int k = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				b[k] = a[i][j];
				k++;
			}
			
		}
		
		recursiveHelper(b, 0, sum, 0);	
		

	}
	
	public static void recursiveHelper(int[] b, int currentSum, int sum, int index) {
		
		for(int i = index; i < b.length; i++) {
			int value = b[i];
			currentSum = currentSum + value;
			sums.Push(value);
			if(currentSum < sum) {
				recursiveHelper(b,currentSum,sum,i+1);
			}
			if(currentSum == sum) {
				System.out.println("Sum found!");
				sums.printList();
				currentSum = currentSum - sums.Pop();
				continue;
			}
			currentSum = currentSum - sums.Pop();
			
			
		}
		
	
		
		
	}
	
	
	public static int ProblemFourC(int smallestNumber) {
		
		//classic solution is to maintain a stack or queue for powered numbers of 'smallestNumber'
		
		ArbitraryQueue<Integer> qk = new ArbitraryQueue<Integer>();
		ArbitraryQueue<Integer> qi = new ArbitraryQueue<Integer>();
		ArbitraryQueue<Integer> qj = new ArbitraryQueue<Integer>();
		
		// initialize the check numbers with impossible values to bypass i = 0 on for loop
		int number = 0;
		int i = -1;
		int j = -1;
		int k = -1;

		// Initialize the first queue with '1' to get the '0' result
		qk.Push(1);
		
		
		for(int a = 0; a <= smallestNumber; a++) {
			
			if(qi.totalNodes == 0 && qj.totalNodes == 0) {
				number = qk.Peek();
				k = qk.Peek();
			}
			
			else {
				
				i = qi.tailPeek();
				j = qj.tailPeek();
				k = qk.tailPeek();
				
				// trick is here, select the smallest number of the three queues
				number = Math.min(i, Math.min(j, k));
				
			}
			
			
			if(number == i) {
				
				
				qi.Dequeue();
				qi.Push(9*number);
				
			} else if(number == j) {
				
				qj.Dequeue();

				

			} else if (number == k) {
				
				qk.Dequeue();
				
				qk.Push(7*number);
				qi.Push(9*number);
				
			}
			
			qj.Push(15*number);


		}
		
		return number;
		
		
		

		
	}
	
	
	

	
	

}
