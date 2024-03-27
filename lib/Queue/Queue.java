package Queue;

public class Queue<T> implements InterfaceQueue<T> {
	private int start;
	private int end;
	private int size;
	private T value;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public Queue(int size) {
		this.start = -1;
		this.end = -1;
		this.size = size; // Adicione esta linha
		this.queue = (T[]) new Object[size];
	}

	@Override
	public void add(T element) throws Exception {
		if (isFull()) {
			throw new Exception("The queue is full");
		} else {
			this.end = (end + 1) % size;
			queue[end] = element;
			if (start == -1) {
				start = 0;
			}
		}
	}

	@Override
	public T remove() throws Exception {
		if (!isEmpty()) {
			if (this.start == this.end) {
				value = this.queue[this.start];
				this.start = -1;
				this.end = -1;
				return value;
			} else {
				value = this.queue[start];
				this.start++;
				return value;
			}
		} else
			throw new Exception("The queue is empty");
	}

	@Override
	public T peek() throws Exception {
		if (!isEmpty())
			return this.queue[this.start];
		else
			throw new Exception("The queue does not contain elements");
	}

	@Override
	public boolean isEmpty() {
		return this.start == -1;
	}

	@Override
	public boolean isFull() {
		int lastElement = (this.end + 1) % size;
		return lastElement == start;
	}

	@Override
	public void show() {
		if (!isEmpty()) {
			System.out.print("Queue: [");
			for (int i = start; i < end; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.printf("%d]%n", queue[end]);
		} else {
			System.out.println("The queue is empty");
		}
		System.out.println();
	}

}