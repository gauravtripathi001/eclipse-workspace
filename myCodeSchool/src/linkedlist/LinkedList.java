package linkedlist;

class Node {
	 int data;
	 Node next;
Node(int data){
	this.data=data;
}
}

public class LinkedList {
	private static Node head;
	private static int numNodes=0;
	
	public LinkedList(int data) {
		head=new Node(data);
		numNodes++;
		
}
	//Insert node at the beginning
	public void insertNode(int data) {
	Node temp=head;
	head=new Node(data);
	head.next=temp;
	numNodes++;
	}
	
	public static void printLinkedList(LinkedList l) {
		Node temp=l.head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public void insertNthPosition(int n, int data) {
		if(n>numNodes-1) {
			return;
		}
		Node temp=head;
		int counter=1;
		while(counter<n-1) {
			counter++;
			temp=temp.next;
		}
		Node pLink=temp.next;
		Node nNode=new Node(data);
		temp.next=nNode;
		nNode.next=pLink;
	}
	
public static void main(String[] args) {
	int x=2;
	LinkedList l=new LinkedList(x);
l.insertNode(2);
	l.insertNode(3);
//	l.insertNode(4);
//	
	l.insertNthPosition(2, 1);
	printLinkedList(l);
}	

}
