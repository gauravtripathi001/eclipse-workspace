
//
//public class graphTraversal {
//
//	
//	class Node{
//		int value;
//		Node[] children;
//		boolean visited=false;
//	}
//	
//	public void bfs(Node root) {
//		//reach a node
//		//visit
//		queue q=new queue<>();
//		//add element to queue
//		System.out.println(root.value);
//		
//		while q is not empty{
//			Node r = q.dequeue();
//			visit(r);
//			for (Node n:r.children) {
//				if(n.visited==false) {
//				n.visited=true;
//				q.enqueue(n);
//				}
//			}
//		}
//		
//		
//		
//	}
//	public void dfs(Node root) {
//		//reach a node
//		//visit its neighbors
//		//go to the end
//		//recursively visit all neighbors
//		if(root==null) return;
//		System.out.println(root.value);
//		root.visited=true;
//		
//		for (Node n : root.children) {
//			if(n.visited==false) {
//				dfs(n);
//			}
//		}
//		
//	}
//}