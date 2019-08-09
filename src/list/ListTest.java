package list;

//class Node {
//	int data;
//	Node link;
//
//	Node() {
//		this(0, null);
//	}
//
//	Node(int data) {
//		this(data, null);
//	}
//
//	Node(int data, Node link) {
//		this.data = data;
//		this.link = link;
//	}
//}


class MyLinkedList {
	Node header = new Node(); // [data:link]

	public void addFirst(int data) {// 첫번째에 추가하는거니까
//		Node n = new Node();
//		n.data = data;
//		n.link = header.link;// 헤더가 가리키고 있던데 첫번째였을테니 그걸 따라가고
//
//		header.link = n;// 이제부터 헤더의 가리키고있는것은 새로 추가된 n이 된다.

		header.link = new Node(data,header.link); //이한줄로 끘.
	}

	public void append(int data) {
		if (header.link == null) {
			addFirst(data);
		} else {
			Node n = new Node();
			n.data = data;
			// end.link = null; 기본적으로 null일테니 생략.

			Node t = header.link;// tmp가 됨
			while (t.link != null) {
				t = t.link;
			}
			t.link = n;
		}
	}

	public void delete(int data) {
		if (header.link == null)
			return;
		Node t = header;
		while (t.link != null) {
			if (t.link.data == data) {
				t.link = t.link.link;
				return;
			} else {
				t = t.link;
			}	
		}
	}

	public void print() {
		if (header.link == null)
			return;
		Node t = header.link;// tmp가 됨
		while (t.link != null) {
			System.out.print(t.data + "->");
			t = t.link;
		}
		System.out.println(t.data);
	}
}

public class ListTest {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addFirst(3);
		ll.print();
		ll.addFirst(2);
		ll.print();
		ll.addFirst(1);
		ll.print();
		ll.append(4);
		ll.print();
		ll.append(5);
		ll.print();
		ll.delete(1);
		ll.delete(3);
		ll.delete(5);
		ll.print();
	}

}
