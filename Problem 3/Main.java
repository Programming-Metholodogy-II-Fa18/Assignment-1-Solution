public class Main {
	
	public static void main(String[] args) {
		
		GenericStack gs = new GenericStack(); // names will vary
		gs.Push(5); // [5]
		gs.Push(6); // [6 5]
		gs.Push(7); // [7 6 5]
		System.out.println(gs.Pop()); // returns 7
		gs.Push(8); gs.Push(1); gs.Push(3); // [3 1 8 6 5]
		gs.insertionSort(); // should output series of messages
		System.out.println(gs.Peek()); // returns 1
		System.out.println(gs.pastPeek()); // returns 3
		gs.Pop(); // removes ‘1’
		gs.Pop(); // removes ‘3’
		System.out.println(gs.Peek()); // returns 5
		System.out.println(gs.pastPeek()); // returns 8




		
	}
	

	
	

}
