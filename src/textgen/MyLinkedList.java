package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(head == null) return false;
		else{
			LLNode<E> cur = head;
			while(cur.next != null){
				cur = cur.next;
			}
			LLNode<E> node = new LLNode<>(cur, element, null);
			cur.next = node;
			size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(head == null) return null;
		try{
			LLNode<E> cur = head;
			int i = 0;
			while(i < index){
				cur = cur.next;
				i++;
			}
			return cur.data;
		}catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(head == null) return;
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		LLNode<E> cur = head;
		int i = 0;
		while(i < index){
			cur = cur.next;
			i++;
		}
		if(cur.prev == null){
			LLNode<E> node = new LLNode<>(null, element, cur);
			cur.prev = node;
			head = node;
		}else {
			LLNode<E> node = new LLNode<>(cur.prev, element, cur);
			cur.prev.next = node;
			cur.prev = node;
		}
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(head == null) return null;
		E element = null;
		try{
			LLNode<E> cur = head;
			int i = 0;
			while(i < index){
				cur = cur.next;
				i++;
			}
			if(cur.next == null){
				element = cur.data;
				cur = cur.prev;
				cur.next = null;
			}else if(cur.prev == null){
				element = cur.data;
				cur = cur.next;
				cur.prev = null;
				head = cur;
			}else{
				element = cur.data;
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
			}
		}catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		size--;
		return element;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(head == null) return null;
		E oldData = null;
		try{
			LLNode<E> cur = head;
			int i = 0;
			while(i < index){
				cur = cur.next;
				i++;
			}
			oldData = cur.data;
			cur.data = element;
		}catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E data) 
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(LLNode<E> prev, E data, LLNode<E> next){
		this.prev = prev;
		this.data = data;
		this.next = next;
	}

}
