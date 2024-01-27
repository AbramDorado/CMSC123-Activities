public class LinkedQueue<E> implements Queue<E>{
	
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	private static class Node<E>{ 
		
		private E data;
		private Node<E> next;
		public E element; 
		
		private Node(E data) {this(data, null);}

		private Node(E data, Node<E> nodeRef) {
			this.data = data;
			this.next = nodeRef;
		}
	}

	@Override
	public int size() { //initialize the size
		front = null;
        rear  = null;
        size = 0;
        assert condition();
        return size;
	}
	
	@Override
	public boolean isEmpty() { //check if empty
		return front == null;
	}

	@Override
	public E front() throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("Queue underflow");
		return null;
	}

	@Override
	public void enqueue(E element) {
		
		Node<E> pastRear = rear; //set rare to the past rear
		rear = new Node<E>(element);
        rear.element = element;
        rear.next = null;
        if (isEmpty()) 
        	front = rear;
        else           
        	pastRear.next = rear;
        
        size ++;
        assert condition();
	}

	@Override
	public E dequeue() throws QueueEmptyException {
		
		if (isEmpty()) throw new QueueEmptyException("Queue underflow");
        E element = front.element;
        front = front.next;
        size--;
        
        if (isEmpty())
        	rear = null;
        assert condition();
        return element;
	}
	
	private boolean condition() { //checking if null or not
		// return false if size is less than zero
        if (size < 0) {return false;}
        
        else if (size == 0) { //if size is zero
            if (front != null) return false;
            if (rear != null) return false;
        }
        
        else if (size == 1) {//if size is one
            if (front == null || rear == null) return false;
            
            if (front != rear) return false;
            
            if (front.next != null) return false;
        }
        
        else { // if the front and rear are empty
            if (front == null || rear == null) return false;
            
            if (front == rear) return false;
            
            if (front.next == null) return false;
            
            if (rear.next  != null) return false;

            int totalnodes = 0; //initialize the number of nodes
            for (Node<E> key = front; key != null && 
            		totalnodes <= size; key = key.next) {
                totalnodes++;
            }
            if (totalnodes != size) return false;

            Node<E> rearNode = front;
            
            while (rearNode.next != null) {
                rearNode = rearNode.next;
            }
            if (rear != rearNode) 
            	return false;
        }
        return true;
    } 
}
