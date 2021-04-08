import java.util.LinkedList;

public class StackListBased<T> {		//create generic type stack
private LinkedList<T> stack;

	
	public void createStack(){		
		this.stack = new LinkedList<T>();
	}
	
	public void popAll() {
		this.stack.clear();		
	}
	
	public boolean isEmpty(){
		return this.stack.isEmpty();
	}
	
	public void push(T item) {
		this.stack.add(item);
	}
	public T pop(){
		return this.stack.removeLast();
	}
	
	public T peek() {
		return this.stack.peekLast();
	}

}
