package com.bridgelabz.datastructure.unorderedList;

public class LinkedList {
	Node head;

	public void insert(String data) {
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

	public void insertAt(int index, String data) {
		Node new_node = new Node();
		new_node.data = data;
		if (index == 0) {
			insertAtStart(data);
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;
		}
	}

	public void insertAtStart(String data) {
		Node new_node = new Node();
		new_node.data = data;
		new_node.next = head;
		head = new_node;
	}

	public void deleteAt(int index) {
		if (index == 0) {
			deleteAtStart();
		} else {
			Node n = head;
			Node n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
		}
	}

	public void deleteAtStart() {
		Node n = head;
		head = head.next;
		n = null;
	}

	public void deleteByKey(String key) {

		Node n = head;
		int counter = -1;
		while (n.next != null) {
			counter++;
			if (n.data.equals(key)) {
				break;
			}
			n = n.next;
		}
		if(n.data.equals(key))
			counter++;
		deleteAt(counter);
		System.out.println("key found and deleted");

	}

	public void searchNode(String key) {
		Node n = head;
		boolean isFound = false;
		while (n.next != null) {
			if (n.data.equals(key)) {
				isFound = true;
				break;
			}
			n = n.next;
		}
		// for seeking the last index
		if (n.data.equals(key))
			isFound = true;

		if (isFound) {
			deleteByKey(key);
		} else {
			insert(key);
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
