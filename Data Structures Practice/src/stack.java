import java.util.EmptyStackException;


public class stack<T> {
	private static class StackNode<T>{
	private T data;
	private StackNode<T> next;
	public StackNode(T data) {
		this.data=data;
	}
	}
	private StackNode<T> top;
	
	public T pop() {
		if(top==null)
			throw new EmptyStackException();
		T item=top.data;
		top=top.next;
		return item;
	}
	public void push(T item) {
		StackNode<T> t=new StackNode<T>(item);
		t.next=top;
		top=t;
	}
	public T peek() {
		if (top==null) throw new EmptyStackException();
	return top.data;
	}
	public boolean isEmpty() {	
		return top==null;
	}
	public static void main(String[] args){
        stack<Integer> s=new stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
    }
	}




