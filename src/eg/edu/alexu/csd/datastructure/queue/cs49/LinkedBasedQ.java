package eg.edu.alexu.csd.datastructure.queue.cs49;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.cs49.SinglyLinkedList;;

public class LinkedBasedQ implements IQueue, ILinkedBased {
	private SinglyLinkedList q = new SinglyLinkedList();

	@Override
	public void enqueue(final Object item) {
		q.add(item);
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (q.size == 0) {
			throw null;
		}
		Object temp = q.get(0);
		q.remove(0);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (q.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return q.size;
		
	}

}
