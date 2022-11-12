
public class LinkedBasedStack<T> implements Stack<T> {
	
	private Node<T> head;
	private int size;
	
	public LinkedBasedStack() {
		head = null;
		size = 25;
	}
	

	@Override
	public boolean isEmpty() {
		
		if(head == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isFull() {
		Node<T> walk = head;
		int numberOfElements = 0;
		
		while(walk != null) {
			numberOfElements++;
			walk = walk.getNext();
		}
		
		if(numberOfElements == size) {
			return true;
		}
		return false;
	}

	@Override
	public void push(T itm) {
		
		if(isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		
		Node<T> newNode = new Node<T>(itm);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node<T> walk = head;
		while(walk != null) {
			if(walk.getNext() == null) {
				walk.setNext(newNode);
				break;
			}
			walk = walk.getNext();
		}
		
		
	}

	@Override
	public T pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		Node<T> walk = head;
		Node<T> prev = null;
		
		if(head.getNext() == null) {
			T data = head.getData();
			head = null;
			return data;
		}
		
		while(walk != null) {
			if(walk.getNext() == null) {
				T data = walk.getData();
				prev.setNext(null);
				return data;
			}
			prev = walk;
			walk = walk.getNext();
		}
		
		return null;
	}

	@Override
	public T peek() {
		
		if(isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		Node<T> walk = head;
		while(walk != null) {
			if(walk.getNext() == null) {
				return walk.getData();
			}
			walk = walk.getNext();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		
		String str = "---";
		Node<T> walk = head;
		
		while(walk != null) {
			str = String.valueOf(walk.getData()) + "\n" + str;
			walk = walk.getNext();
		}

		return str;
		
	}

}
