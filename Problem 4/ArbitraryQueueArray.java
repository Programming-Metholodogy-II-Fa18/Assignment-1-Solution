
public class ArbitraryQueueArray<Item> {
	
	//change name to allow arbitrary array insertion
	public Item[] data;
	public int totalNodes = 0;
	public int head  = 0;
	public int tail = 0;
	
	@SuppressWarnings("unchecked")
	public ArbitraryQueueArray() {
		data =  (Item[]) new Object[4];
		
	}
	
	public void Push(Item data) {
		if(data == null) {
			System.out.println("Null values not allowed!");
			throw new java.lang.IllegalArgumentException();
		}
		
		
		if(totalNodes == this.data.length)
			resizeArray();
		if(this.data[head] == null)
		this.data[head] = data;
		else {
			head = (head+1) % this.data.length;
			this.data[head] = data;
			
		}
		
	
		totalNodes++;
		
		
		
	}
	
	public void Enqueue(Item data) {
		if(data == null) {
			System.out.println("Null values not allowed!");
			throw new java.lang.IllegalArgumentException();
		}
		
		if (totalNodes == this.data.length){
			resizeArray();
		}
		
		if(totalNodes == 0 ) {
			head = tail = 0;
			this.data[tail] = data;
		} else {
		
		int a = (tail-1);
		int length = this.data.length;
		tail = negativeMod(a,length);
		this.data[tail] = data;
		}
		totalNodes++;
	}
	
	public Item Pop() {
		if(totalNodes < 0) {
			System.out.println("The data structure is empty!");
			throw new java.util.NoSuchElementException();
		}
		
		
		Item temp = data[head];
		data[head] = null;
		head = negativeMod(head-1,data.length);

		totalNodes--;
		
		if(head == tail) {
			data[0] = data[head];
			head = tail = 0;
		}
		
		return temp;
	}
	
	public Item Dequeue() {
		if(totalNodes == 0) {
			System.out.println("The data structure is empty!");
			throw new java.util.NoSuchElementException();
		}
		
		
		Item temp = data[tail];
		data[tail] = null;
		tail = (tail+1) % data.length;
		totalNodes--;
		
		if(head == tail) {
			data[0] = data[head];
			head = tail = 0;
		}
		
		return temp;
		
		
	}
	
	public Item Traverse(int index) {
		if(index > totalNodes - 1) {
			System.out.println("Error! Exceeds total number of elements!");
			throw new java.util.NoSuchElementException();
		}
		
		int a = negativeMod(head-index,data.length);
		return data[a];
		
		
	}
	
	
	public void resizeArray() {

		Item[] temp = (Item[]) new Object[data.length*2];
		for(int i = 0; i <= head; i++) {
			temp[i] = data[i];
		}
		
		int count = 0;
		
		if(tail != 0) {
		for(int j = data.length-1; j >= tail; j--) {
			temp[temp.length-1-count] = data[j];
			count = count+1;
		}
		tail = temp.length-count;
		}
		
		this.data = temp;


		
	}
	
	public int negativeMod(int a, int b) {
		return ((a % b) + b) % b;
	}
	
	public void printList() {
		String a = "";
		a = "" + Traverse(0).toString();
		for(int i = 1; i < totalNodes; i++) {
			a = a + "," + Traverse(i).toString();
		}
		
		System.out.println(a);
		
	}
	
	
	

}
