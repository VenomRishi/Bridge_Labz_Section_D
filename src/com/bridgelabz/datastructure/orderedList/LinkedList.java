package com.bridgelabz.datastructure.orderedList;

import com.bridgelabz.datastructure.orderedList.OrderedListProgram;

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
		if (isFound) {
			System.out.println("key found and deleting...");
			OrderedListProgram.size -= 1;
			deleteAt(counter);
		} else if (n.data == key) {
			System.out.println("key found at last and deleting...");
			OrderedListProgram.size -= 1;
			counter++;
			deleteAt(counter);
			}
		 else {
			System.out.println("key not found and inserting...");
			OrderedListProgram.size += 1;
			insertAt(counter, key);
		}

	}

	private void insertAt(int index, int data) {
		Node new_node = new Node();
		new_node.data = data;
		if (index == 0) {
			new_node.next = head;
			head = new_node;
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;
		}

	}

	public void sort() {
		Node n = head;
		Node n1 = n.next;
		int temp;

		for (int i = 0; i < OrderedListProgram.size - 1; i++) {
			for (int j = 0; j <= (OrderedListProgram.size - 1) - i - 1; j++) {
				if (n.data > n1.data) {
					temp = n.data;
					n.data = n1.data;
					n1.data = temp;
				}
				n1 = n1.next;
			}
			n = n.next;
			n1 = n.next;
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
