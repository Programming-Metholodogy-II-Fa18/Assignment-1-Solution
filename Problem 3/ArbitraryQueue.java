
@SuppressWarnings("hiding")
public class ArbitraryQueue<Object> {
	
	
	public Node<Object> head;
	public Node<Object> tail;
	public int totalNodes = 0;
	
	public ArbitraryQueue(){
		
		head = new Node<Object>();
		tail = head;
		
	}
	
	public void Push(Object data) {
		if(data == null) {
			System.out.println("Null values not allowed!");
			throw new java.lang.IllegalArgumentException();
		}

		

		Node<Object> temp = head;
		head = new Node<Object>();
		head.data = data;
		head.next = temp;
		temp.prev = head;
		
		if( totalNodes == 0) tail = head;
		
		totalNodes++;
		
	}
	
	public void Enqueue(Object data) {
		Node<Object> temp = tail;
		tail = new Node<Object>();
		tail.data = data;
		tail.next = null;
		
		if(totalNodes == 0) head = tail;
		else {
			temp.next = tail;
			tail.prev = temp;
		}
				
		
		totalNodes++;
	}
	
	
	public Object Pop() {
		
		if(totalNodes == 0) {
			System.out.println("The data structure is empty!");
			throw new java.util.NoSuchElementException();
		}
		
		Object data = head.data;
		head = head.next;
		totalNodes--;
		return data;
	}
	
	public Object Dequeue() {
		
		
		
		if(totalNodes == 0) {
			System.out.println("The data structure is empty!");
			throw new java.util.NoSuchElementException();
		}
		
		
		Object data = tail.data;
		tail = tail.prev;
		totalNodes--;

		return data;
	}
	
	

	
	
	public Object Traverse(int index) {
		
		Node<Object> temp = head;
		
		int i = 0;
		
		if(index > totalNodes - 1) {
			System.out.println("Error! Exceeds total number of elements!");
			throw new java.util.NoSuchElementException();
		}
		else {
			while(i < index) {
				temp = temp.next;
				i = i+1;
			}
			
			
		}

			
		return temp.data;
			
	}
	
	public Object Peek() {
		return head.data;
	}
	
	
	/*
	 * Non-mandatory classes below
	 * Implemented to make other problems easy to attack :)
	 */
	
	

	public Object tailPeek() {
		return tail.data;
	}
	
	
	
	public void setNode(int index, Object data) {
		
		Node<Object> temp = head;
		
		int i = 0;
		
			while(i < index) {
				temp = temp.next;
				i = i+1;
			}
			
		temp.data = data;
			
		
	}
	
	
	public void delete(int index) {
		
		totalNodes--;

		
		Node<Object> temp = head;
		if (index == 0){
			head = head.next;
			return;
		}
		
		
		int i = 0;
		
			while(i < index-1) {
				temp = temp.next;
				i = i+1;
			}
			
			
		temp.next = temp.next.next;
		
		
	}
	
	
	public void printList() {
		Node<Object> iterator = head;
		String s = "";
		while(iterator.next != null) {
			s = s +iterator.data.toString();
			
		}
		System.out.println(s);
	}
	
	
	
	
	
	
	

}
