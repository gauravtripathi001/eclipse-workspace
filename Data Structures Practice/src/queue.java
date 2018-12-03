
public class queue<T> {
	//FIFO
	private static class QueueNode<T>{
		private T data;
		public QueueNode(T data) {
			this.data=data;
		}
		private QueueNode<T> next;
	}
		private QueueNode<T> top;
	
	//add Add to the end of list
	//remove Remove the first item in list
	//peek Return the top of queue
	//isEmpty Return true iff queue is empty
	 void add(T data) {
		if(top==null) {
			top=new QueueNode<T>(data);
		}
		else {
		QueueNode<T> n=new QueueNode<T>(data);
		n.next=top;
		top=n;
		}
	}  
	
	

}
