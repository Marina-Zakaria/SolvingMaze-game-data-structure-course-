package eg.edu.alexu.csd.datastructure.stack.cs49;

import eg.edu.alexu.csd.datastructure.linkedList.cs49.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {
	private SinglyLinkedList stack = new SinglyLinkedList();

	@Override
	public void add(final int index, final Object element) {
		if (index >= 0 && index <= stack.size) {
			if (element != null) {
				stack.add(stack.size - index, element);
			}
		} else {
			throw null;
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (stack.size == 0) {
			throw null;
		}
		Object element = stack.get(0);
		stack.remove(0);
		return element;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (stack.size == 0) {
			throw null;
		}

		return stack.get(0);
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		stack.add(0, element);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size;
	}

}
