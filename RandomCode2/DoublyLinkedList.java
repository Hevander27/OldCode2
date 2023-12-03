package main.java;

import java.util.*;
import main.java.EmptyNodeException;

/**
 * Name: Hevander Da Costa
 * Class Name:
 * Project Number: 2
 * Project Due Date: 4/28/17
 * Program Title: DoublyLinkedList.java
 * Program Description:
 *    - DoublyLinkedList generic implementation
 *    - Node class implementation
 */

public class DoublyLinkedList<E>  {

	private int size;
	private Node head;
	private Node tail;

	private enum Operation {
		INCREMENT("+"), DECREMENT("-");

		private final String operation;
		Operation(String operation) {
			this.operation = operation;
		}

		private int operate(int value) {
			if (operation.equals("+")) return value + 1;
			if (operation.equals("-")) return value - 1;
			return 0;
		}
    }

	private class Node {
		E element;
		int position;
		Node next;
		Node previous;

		public Node(E element) {
			position = 0;
			this.element = element;
		}
		
		public Node(E element, Node previous, Node next) {
			this.element = element;
			this.previous = previous;
			this.next = next;
			if (previous != null)  {
				previous.next = this;
				this.position = previous.position + 1;
			}
			if (next != null)  {
				next.previous = this;
				this.position = next.position == 0 ? 0 : next.position - 1;
		    }
		}

		public String toString() {
			return element.toString();
		}
	
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)                  return true;
			if (obj == null)                  return false;
			if (getClass() != obj.getClass()) return false;
			
			Node other = (Node) obj;
			if (element == null && other.element != null) return false;
			else if (!element.equals(other.element))      return false;
			return true;
		}
	}

	public DoublyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Adjust position values of nodes to size
	 * @param Operation
	 */
	private void adjust(Operation operation) {
		for (Node current = head; current != null; current = current.next) {
			int newPosition = operation.operate(current.position);
			if (newPosition > 0)
			current.position = operation.operate(current.position);
		}
	}

	/**
	 * Adjust position values from node to size
	 * @param Operation
	 */
	private void adjust(Node from, Operation operation) {
		for (Node current = from; current != null; current = current.next) {
			current.position = operation.operate(current.position);
		}
	}

	/**
	 * Add element to the head of the list
	 * @param E element
	 */
	public void addFirst(E element) {
		Node newNode = new Node(element, null, head);
		if (tail == null) tail = newNode;
		head = newNode;
		size++;
		adjust(Operation.INCREMENT);
	}

	/**
	 * Add element to the tail of the list
	 * @param E element
	 */
	public void addLast(E element) {
		Node newNode = new Node(element, tail, null);
		if (head == null) head = newNode;
		tail = newNode;
		size++;
	}

	/**
	 * Remove head of the list
	 * @return E element
	 */
	public E removeFirst() {
		if (isEmpty()) throw new NoSuchElementException();
		Node temp = head;
		head = head.next;
		head.previous = null;
		size--;
		adjust(Operation.DECREMENT);
		return temp.element;
	}

	/**
	 * Remove tail of the list
	 * @return E element
	 */
	public E removeLast() {
		if (isEmpty()) throw new NoSuchElementException();
		Node temp = tail;
		tail = tail.previous;
		tail.next = null;
		size--;
		return temp.element;
	}

	/**
	 * Add element to the ith position in the list
	 * @param int position, E element
	 */
	public void insert(int i, E element) {
		if (i == 0)         addFirst(element);
		else if (i >= size) addLast(element);
		else {
			Node left = head;
			Node right = tail;
			for (; (left != null && right != null); left = left.next, right = right.previous) {
				Node current = null;
				if (left.position == i)  current = left;
				if (right.position == i) current = right;
				if (current != null) {
					size++;
					Node newNode = new Node(element, current.previous, current);
					adjust(newNode, Operation.INCREMENT);
					break;
				}
			}
	    }
	}

	/**
	 * Remove element from the ith position in the list
	 * @param int position
	 * @return E element
	 */
	public E delete(int i) {
		try {
			if (size == 0 || i > size) throw new IndexOutOfBoundsException();
			else if (i == 0)           return removeFirst();
			else if (i == size - 1)    return removeLast();
			else {
				Node left = head;
				Node right = tail;
				for (; (left != null && right != null); left = left.next, right = right.previous) {
					Node current = null;
					if (left.position == i)  current = left;
					if (right.position == i) current = right;
					if (current != null) {
						size--;
						current.previous.next = current.next;
						current.next.previous = current.previous;
						adjust(current.previous, Operation.DECREMENT);
						return current.element;
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Remove element from the list
	 * @param E element
	 */
	public void delete(E element) {
		try {
			if (size > 0) {
				Node selectedNode = new Node(element);
				Node left = head;
				Node right = tail;
				for (; (left != null && right != null); left = left.next, right = right.previous) {
					Node current = null;
					if (left.equals(selectedNode))  current = left;
					if (right.equals(selectedNode)) current = right;
					if (current != null) {
						size--;
						current.previous.next = current.next;
						current.next.previous = current.previous;
						adjust(current.previous, Operation.DECREMENT);
						return;
					}
				}
			}
			throw new EmptyNodeException("Element does not exist");
		} catch (EmptyNodeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Determine if element is in the list
	 * @param E element
	 * @return boolean
	 */
	public boolean contains(E element) {
		if (size > 0) {
			Node selectedNode = new Node(element);
			for (Node current = head; current != null; current = current.next) {
				if (current.equals(selectedNode)) return true;
			}
		}
		return false;
	}

	/**
	 * Return the size of the list
	 * @return int
	 */
	public int size() { return size; }

	/**
	 * Return whether or not the list is empty
	 * @return boolean
	 */
	public boolean isEmpty() { return size == 0; }

	/**
	 * Return list of elements as string
	 * @return String
	 */
	private String getElements(String input, Node current) {
		if (size == 0)       return input;
		if (current == null) return input;
		input += current.position + " - " + current + "\n";
		return getElements(input, current.next);
	}

	public String toString() {
		String initial = "Size: " + size() + "\n";
		return getElements(initial, head);
	}
}
