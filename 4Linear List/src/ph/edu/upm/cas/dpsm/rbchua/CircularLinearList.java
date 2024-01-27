package ph.edu.upm.cas.dpsm.rbchua;

public class CircularLinearList<E> {
	private Node<E> list;
	//insert needed instances here
	
	public CircularLinearList() {
		list = null;
	} // end constructor

	//this method should print the elements of the list from left to right
	public String toString() {
		//complete this method
		StringBuilder listString = new StringBuilder("(");
		Node<E>current = list.getNext(); 

		E temp = current.getKey();
		listString.append(current.getKey());
		current = current.getNext();

		while (current.getKey() != temp) {
			listString.append(", ").append(current.getKey());
			current = current.getNext();
		}
		listString.append(")");
		
		return listString.toString();
	} // end toString

	////////
	public void leftInsert(E key) {
		//complete this method
		Node<E> newNode = new Node<>(key);

		if (list == null) { //if the list is null set newNode as the first
			newNode.setNext(newNode);
			list = newNode;
		} 
		else { //link newNode to the previous node
			newNode.setNext(list.getNext());
			list.setNext(newNode); //then link list to the newNode
		}
	}

	////////
	public void rightInsert(E key) {
		//complete this method
		leftInsert(key); //call the left
		list = list.getNext();
	}
	
	/////////
	public E deleteLeft(){
		//complete this method
		if (list == null) //if the list is null return null
			return null;
	
		//if last node
//		else if (list.getNext().getKey() == list.getKey()) {
//		    E key = list.getKey();
//		    list = null;
//			
//			return key;
//		} 
		else { //if not last node
			Node<E> current = list.getNext(); 
			E key = current.getKey(); //place node to key variable
			list.setNext(current.getNext()); //change node pointer

			if (current == list) 
				list = null;
			
			return key;
		}
	}

	////////
	public E deleteRight(){
		//complete this method
		Node<E> current = list;

		if (list == null) //if the list is null return null
			return null;
		
		//if last node, list will be null
//		else if (list.getNext().getKey() == list.getKey()) {
//		    E key = list.getKey();
//		    list = null;
//			
//            return key;
//		}
//		
		else { //if not last node
			while (current.getNext() != list) { //a
				current = current.getNext();
			}
			
			if (list.getNext().getKey() == list.getKey()) {
	          //E key = list.getKey();
	          list = null;
			}
			Node<E>previous = current;
			current = current.getNext();

			previous.setNext(current.getNext());
			E key = current.getKey();
			list = previous;
			
			
			
			return key;
		}
	}
	
	////////
	public static void main(String[] args){
		
		CircularLinearList<String> list = new CircularLinearList<>();
		list.leftInsert("Hello");
		list.rightInsert("World");
		
		System.out.println(list);
		//Should print : (Hello, World)
		
		list.leftInsert("Computer");
		list.rightInsert("Science");
		
		//System.out.println(list);
		System.out.println(list.deleteLeft()); 
		//Should print : Computer
		
		//list.deleteRight();
		System.out.println(list.deleteRight());
		//Should print : Science
		System.out.println(list.deleteRight());
		//world
		//System.out.println(list);
		System.out.println(list.deleteLeft());
		System.out.println(list);
		//System.out.println(list.deleteRight());
	}
}
