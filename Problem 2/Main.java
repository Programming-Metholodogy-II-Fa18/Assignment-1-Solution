public class Main {
	
	public static void main(String[] args) {
		
		ArbitraryQueueArray<Long> aq = new ArbitraryQueueArray<Long>();
		aq.Push(new Long(5)); // contents: [5]
		aq.Push(new Long(6)); // contents [6 5]
		aq.Enqueue(new Long(7)); // contents [6 5 7]
		System.out.println(aq.Traverse(0)); // prints 6
		System.out.println(aq.Traverse(1)); // prints 5
		System.out.println(aq.Traverse(2)); // prints 7
		System.out.println(aq.Pop()); // prints 6
		System.out.println(aq.Dequeue()); // prints 7
		System.out.println(aq.Pop()); // prints 5
		


		
	}
	

	
	

}
