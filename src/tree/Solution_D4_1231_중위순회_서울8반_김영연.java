/*package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Tree{
	class Node {
		char data;
		Node left;
		Node right;
	}
	Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node add(Node left, char data, Node right) {
		Node node = new Node();
		node.left = left;
		node.data = data;
		node.right = right;
		
		return node;
	}
}
public class Solution_D4_1231_중위순회_서울8반_김영연 {
	
	static int n;
	public static void dfs(int v) {
		if (v * 2 <= n && Tree[v * 2] != null)
				dfs(v * 2);
		System.out.print(Tree[v]);
		if (v * 2 + 1 <= n && Tree[v * 2 + 1] != null)
				dfs(v * 2 + 1);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Inorder.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			Tree tree = new Tree();
			n = Integer.parseInt(br.readLine());
			for (int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				if(s.length > 2) {
				}
				else {
					
				}
			}
			System.out.print("#"+t+" ");
			dfs(1);
			System.out.println();
		}
	}
}
*/