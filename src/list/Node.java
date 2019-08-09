package list;

public class Node {
	int data;
	Node link;

	Node() {
		this(0, null);
	}

	Node(int data) {
		this(data, null);
	}

	Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}
}
