package eg.edu.alexu.csd.datastructure.linkedList.cs49;

public class Node {
	Object data;
	Node next;

	public Node(final Object data, final Node next) {
		this.data = data;
		this.next = next;
	}

	public Object getElement() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setElement(final Object data) {
		this.data = data;
	}

	public void setNext(final Node next) {
		this.next = next;
	}

	public String toString() {
		return data + "";
	}

}
