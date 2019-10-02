package testing;

/**
 * Created by hatim.lokhandwala on 10/05/19.
 */
public class Node<E> {
	E data;
	Node<E> prev;
	Node<E> next;
	Node(E data, Node<E> prev, Node<E> next){
		this.prev = prev;
		this.next = next;
		this.data = data;

	}
}


class NodeList<E>{

	private Node<E> first;
	private Node<E> last;


	NodeList(){
		first = null;
		last = null;
	}

	void insertNode(E data){
		Node<E> newNode = new Node<>(data, null, null);
		Node<E> l = last;
		last = newNode;
		if(first == null){
			first = newNode;
		}
		else{
			l.next = newNode;
		}
	}
}