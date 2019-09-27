//package tree;
//
//
//class Tree {
//	class Node {
//		char data;
//		Node left, right;
//	}
//	Node root;
//
//	public Node getRoot() {
//		return root;
//	}
//
//	public void setRoot(Node root) {
//		this.root = root;
//	}
//
//	public Node makeTree(Node left, char data, Node right) {
//		Node node = new Node();
//		node.left = left;
//		node.data = data;
//		node.right = right;
//		
//		return node;
//	}
//	
//	public void preorder(Node node) {
//		if(node != null) {
//			System.out.print(node.data + " ");
//			preorder(node.left);
//			preorder(node.right);
//		}
//	}
//	public void inorder(Node node) {
//		if(node != null) {
//			preorder(node.left);
//			System.out.print(node.data + " ");
//			preorder(node.right);
//		}
//	}
//	public void postorder(Node node) {
//		if(node != null) {
//			preorder(node.left);
//			preorder(node.right);
//			System.out.print(node.data + " ");
//		}
//	}
//}
//
//public class TreeTest {
//
//	public static void main(String[] args) {
//		Tree o = new Tree();
//		Tree.Node n1 = o.new Node(); //중첩클래스인 경우
//		n1.data = '1';
//		
//		Tree.Node n2 = new Tree().new Node();
//		n2.data = '2';
//		
//		Tree t=new Tree();
//		Tree.Node d = t.makeTree(null, 'D', null);
//		Tree.Node h = t.makeTree(null, 'H', null);
//		Tree.Node i = t.makeTree(null, 'I', null);
//		Tree.Node f = t.makeTree(null, 'F', null);
//		Tree.Node g = t.makeTree(null, 'G', null);
//		
//		Tree.Node e = t.makeTree(h, 'E', i);
//		Tree.Node b = t.makeTree(d, 'B', e);
//		Tree.Node c = t.makeTree(f, 'C', g);
//		Tree.Node a = t.makeTree(b, 'A', c);
//		
//		t.setRoot(a);
//		t.preorder(t.getRoot());
//		System.out.println();
//		t.inorder(t.getRoot());
//		System.out.println();
//		t.postorder(t.getRoot());
//	}
//}