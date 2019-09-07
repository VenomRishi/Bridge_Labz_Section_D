package com.bridgelabz.datastructure.orderedList;

public class LinkedList {
	Node head;

	public void insert(int data) {
		Node new_node = new Node();
		new_node.data = data;
		if (head == null) {
			head = new_node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = new_node;
		}
	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			Node n1 = null;
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
		}
	}

	public void searchKey(int key) {
		boolean isFound = false;
		int counter = -1;
		Node n = head;
		while (n.next != null) {
			counter++;
			if (n.data == key) {
				isFound = true;
				break;
			}
			n = n.next;
		}
		if (n.data == key) {
			isFound = true;
		}
		if (isFound) {
			System.out.println("key found and deleting...");
			deleteAt(counter);
		} else {
			System.out.println("key not found and inserting...");
			insert(key);
		}

	}

	public void sort() {
		Node n = head;
		Node n1 = n.next;
		int temp;
		while (n.next != null) {
			if (n.data > n1.data) {
				temp = n.data;
				n.data = n1.data;
				n1.data = temp;
			}
			n = n.next;
			n1 = n1.next;
		}

	}

	public void show() {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.print(n.data);
	}

	public String getListInString() {
		String str = "";
		Node n = head;
		while (n.next != null) {
			str += n.data + ",";
			n = n.next;
		}
		str += n.data;
		return str;
	}

}
