package com.app.btech.experiments.dllist;

public class DoublyLinkedListDemo {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();

		// Create list
		dll.insert(10);
		dll.insert(20);
		dll.insert(30);
		dll.insert(40);
		dll.insert(50);

		System.out.println("Original list:");
		dll.display();

		// Delete element
		dll.delete(30);

		System.out.println("After deleting 30:");
		dll.display();

		// Try deleting an element not in list
		dll.delete(100);
	}
}

