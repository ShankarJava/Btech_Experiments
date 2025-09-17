package com.app.btech.experiments.dllist;

public class DoublyLinkedList {
	
	// Node definition
	class Node {
		int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
			prev = next = null;
		}
	}

	private Node head;

	// Insert at the end
	public void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.prev = temp;
	}

	// Delete by value
	public void delete(int key) {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}

		Node temp = head;

		// If head node is to be deleted
		if (temp.data == key) {
			head = temp.next;
			if (head != null)
				head.prev = null;
			return;
		}

		// Search for the node to delete
		while (temp != null && temp.data != key) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Element " + key + " not found in list.");
			return;
		}

		// Adjust links
		if (temp.next != null) {
			temp.next.prev = temp.prev;
		}

		if (temp.prev != null) {
			temp.prev.next = temp.next;
		}
	}

	// Display list contents
	public void display() {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}

		Node temp = head;
		System.out.print("Doubly Linked List: ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

