package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoublyLinkedList implements ILinkedList {
	int size;
	DoublyNode head;

	public DoublyLinkedList() {
		size = 0;
		head = new DoublyNode(null, null, null);
	}

	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (size == index && index != 0) {
			DoublyNode added = new DoublyNode(element, null, null);
			DoublyNode current = head.getNext();

			for (int i = 0; i < index - 1; i++) {

				current = current.getNext();
			}
			current.setNext(added);
			added.setPre(current);
			size++;
		} else if (size == 0 && index == 0) {
			DoublyNode added = new DoublyNode(element, null, head);
			head.setNext(added);
			size++;
		} else if (size > index) {
			DoublyNode added = new DoublyNode(element, null, null);
			DoublyNode current = head.getNext();

			for (int i = 0; i < index; i++) {

				current = current.getNext();
			}
			DoublyNode pre = current.getPre();
			added.setPre(pre);
			added.setNext(current);
			current.setPre(added);
			pre.setNext(added);
			size++;
		} else {
			throw null;
		}

	}

	@Override
	public void add(Object element) {
		DoublyNode added = new DoublyNode(element, null, null);
		if (head.getNext() == null) {
			head.setNext(added);
			added.setPre(head);
			size++;
		} else {
			DoublyNode current = head;

			for (int i = 0; i < size; i++) {

				current = current.getNext();
			}
			current.setNext(added);
			added.setPre(current);

			size++;
		}

	}

	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		if (size <= index) {
			throw null;
		} else {
			DoublyNode current = head.getNext();

			for (int i = 0; i < index; i++) {

				current = current.getNext();
			}
			return current.getElement();
		}
	}

	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index < size) {
			DoublyNode current = head.getNext();

			for (int i = 0; i < index; i++) {

				current = current.getNext();
			}

			current.setElement(element);

		} else {
			throw null;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.setNext(null);
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head.getNext() == null) {
			return true;
		}
		return false;

	}

	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub
		if (index == size - 1) {
			DoublyNode current = head.getNext();

			for (int i = 0; i < index; i++) {

				current = current.getNext();
			}
			DoublyNode pre = current.getPre();
			pre.setNext(null);
			size--;
		} else if (size > index) {
			DoublyNode current = head.getNext();

			for (int i = 0; i < index; i++) {

				current = current.getNext();
			}
			DoublyNode pre = current.getPre();
			DoublyNode next = current.getNext();
			pre.setNext(next);
			next.setPre(pre);
			size--;
		} else {
			throw null;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;

	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		if (this.size() <= fromIndex || this.size() <= toIndex) {
			throw null;
		} else {
			ILinkedList result = new DoublyLinkedList();
			DoublyNode current = head.getNext();
			for (int i = 0; i < fromIndex; i++) {
				current = current.getNext();
			}

			for (int i = fromIndex; i <= toIndex; i++) {
				result.add(current.getElement());
				current = current.getNext();
			}
			return result;
		}
	}

	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		DoublyNode current = head.getNext();
		while (current != null) {
			if (current.getElement() == o) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

}
