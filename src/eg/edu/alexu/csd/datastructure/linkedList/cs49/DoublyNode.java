package eg.edu.alexu.csd.datastructure.linkedList.cs49;

public class DoublyNode {
	Object data;
	DoublyNode next;
	DoublyNode pre;

	public DoublyNode(Object data, DoublyNode next, DoublyNode pre) {
		this.data = data;
		this.next = next;
		this.pre = pre;
	}

	public Object getElement() {
		return data;
	}

	public DoublyNode getNext() {
		return next;
	}

	public DoublyNode getPre() {
		return pre;
	}

	public void setElement(final Object data) {
		this.data = data;
	}

	public void setNext(final DoublyNode next) {
		this.next = next;
	}

	public void setPre(final DoublyNode pre) {
		this.pre = pre;
	}

	public String toString() {
		return data + "";
	}

}
