package eg.edu.alexu.csd.datastructure.queue.cs49;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayBasedQ implements IQueue, IArrayBased {
	private int size = 0;
	private int f = -1;
	private int l = -1;
	private int max;
	Object[] q;

	public ArrayBasedQ(final int n) {
		// TODO Auto-generated constructor stub
		q = new Object[n];
		max = n - 1;
	}

	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (this.size == max + 1 && item != null) {
			throw null;
		}
		if (l == max) {
			l = 0;
		} else {
			l++;
		}
		size++;
		q[l] = item;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw null;
		}
		if (f == max) {
			f = 0;
		} else {
			f++;
		}
		size--;
		return q[f];

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
