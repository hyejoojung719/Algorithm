import java.util.ArrayList;

public class temp {
	public class MyQueue<T>{
		private ArrayList<T> queue = new ArrayList<>();
		
		public void enqueue(T item) {
			queue.add(item);
		}
		
		public T dequeue() {
			if(queue.isEmpty()) {
				return null;
			}
			return queue.remove(0);
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
	}
}
