public class GenericStack {
	
	
	
	// we'll re-use the ArbitraryQueue data structure but just copy its functionality
	// error handling is copied from AQ
	
	public ArbitraryQueue<Integer> aq = new ArbitraryQueue<Integer>();
	public ArbitraryQueue<Integer> sorted = new ArbitraryQueue<Integer>();
	
	public void Push(int data) {
		aq.Push(data);
		sorted.Push(data);
	}
	
	public int Pop() {
		
		Integer a = sorted.Pop();
		
		for(int i = 0; i < aq.totalNodes; i++) {
			Integer b = aq.Traverse(i);
			if (b.equals(a)){
				aq.delete(i);
				break;
			}
		}
		
		return a;
	}
	
	public int Peek() {
		return sorted.Peek();
	}
	
	
	public int pastPeek() {
		return aq.Peek();
	}
	
	
	public void insertionSort() {
		
		for(int i = 1; i < sorted.totalNodes; i++) {
			for(int j = i; j > 0; j--) {
				if(sorted.Traverse(j) < sorted.Traverse(j-1))
					swap(j,j-1);
			}
		}
		
		System.out.println("Sort finished!");
		
		
	}
	
	public void swap(int j, int k) {
		Integer dataj = sorted.Traverse(j);
		Integer datak = sorted.Traverse(k);
		System.out.println("Swapping " + dataj + " with " + datak);
		sorted.setNode(j, datak);
		sorted.setNode(k, dataj);
		printList();
		
		
	}
	
	public void printList() {
		
		String s = "" + sorted.Traverse(0);
		for(int i = 1; i < sorted.totalNodes; i++) {
			s = s + "," + sorted.Traverse(i);
		}
		System.out.println(s);
		

	}
	
	public void printList2() {
		
		String s = "" + aq.Traverse(0);
		for(int i = 1; i < aq.totalNodes; i++) {
			s = s + "," + aq.Traverse(i);
		}
		System.out.println(s);
		

	}
	
	

	
	
	
	

}
