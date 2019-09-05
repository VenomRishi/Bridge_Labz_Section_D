package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LinkedListOrdered {
	Node head;
	Node sorted;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	void push(int data) {
		/* allocate node */
		Node new_node = new Node(data);
		/* link the old list off the new node */
		new_node.next = head;
		/* move the head to point to the new node */
		head = new_node;
	}

	// function to sort a singly linked list using insertion sort
	void insertionSort(Node headref) {
		// Initialize sorted linked list
		sorted = null;
		Node currentNode = headref;
		// Traverse the given linked list and insert every
		// node to sorted
		while (currentNode != null) {
			// Store next for next iteration
			Node next = currentNode.next;
			// insert current in sorted linked list
			sortedInsert(currentNode);
			// Update current
			currentNode = next;
		}
		// Update head_ref to point to sorted linked list
		head = sorted;
	}

	/*
	 * function to insert a new_node in a list. Note that this function expects a
	 * pointer to head_ref as this can modify the head of the input linked list
	 * (similar to push())
	 */
	void sortedInsert(Node new_node) {
		/* Special case for the head end */
		if (sorted == null || sorted.data >= new_node.data) {
			new_node.next = sorted;
			sorted = new_node;
		} else {
			Node current = sorted;
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.data < new_node.data) {
				current = current.next;
			}
			new_node.next = current.next;
			current.next = new_node;
		}
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(int key) {
		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key) {
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	/* Function to print linked list */
	void printlist(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private void saveInFile(Node head2) {
		// TODO Auto-generated method stub
		String str = "";
		while (head2 != null) {

			str += head2.data + ",";
			head2 = head2.next;
		}
		String str2 = str.substring(0, str.lastIndexOf(","));

		// code for saving into the file
		File file2 = new File(
				"/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/numbersoutput");
		FileWriter fileWriter;

		try {
			fileWriter = new FileWriter(file2);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(str2);
			bufferedWriter.close();
			System.out.println("\nFile Write successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Driver program to test above functions
	public static void main(String[] args) {
		LinkedListOrdered list = new LinkedListOrdered();
		int[] integerArr = null;
		String[] strArr;
		File file = new File("/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/numbers");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String str = bufferedReader.readLine();

			strArr = str.split(",");

			integerArr = new int[strArr.length];

			for (int i = 0; i < strArr.length; i++) {
				integerArr[i] = Integer.parseInt(strArr[i]);
			}
			int j = integerArr.length - 1;
			for (int i = 0; i < integerArr.length; i++) {
				list.push(integerArr[j]);
				j--;
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		list.insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);
		System.out.println();
		System.out.println("Enter value to search");
		Scanner scanner = new Scanner(System.in);
		int key;
		key = scanner.nextInt();
		boolean keyfound = false;
		for (int i = 0; i < integerArr.length; i++) {
			if (integerArr[i] != key) {
				keyfound = false;
			} else {
				keyfound = true;
				break;
			}
		}
		if (keyfound) {
			list.deleteNode(key);
			System.out.println("Deleting...");
		} else {
			// key not found
			list.push(key);
			System.out.println("Adding...");
		}

		System.out.println("\nLinkedList After sorting");
		list.insertionSort(list.head);
		list.printlist(list.head);
		list.saveInFile(list.head);
		scanner.close();
	}

}
