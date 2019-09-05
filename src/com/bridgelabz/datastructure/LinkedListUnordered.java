package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LinkedListUnordered {
	Node head; // head of list

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	static class Node {

		String data;
		Node next;

		// Constructor
		Node(String data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String args[]) throws IOException {
		LinkedListUnordered list = new LinkedListUnordered();

		File file = new File("/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/names");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String str = bufferedReader.readLine();
		String[] strArr = str.split(",");
		// inserting into linkedlist and then printing the same list
		for (int i = 0; i < strArr.length; i++) {
			list = insertNode(list, strArr[i]);
		}
		printList(list);

		// search for node of data if found then delete node from data
		// else insert that data into new next node at the end

		// code for taking input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter key to search");
		String key = scanner.next();
		list = deleteByTheKeyNode(list, key);
		System.out.println();
		// once operation perform well come backs here and print list
		printList(list);
		saveInFile(list);
		bufferedReader.close();
		scanner.close();

	}

	private static void saveInFile(LinkedListUnordered list) {
		// TODO Auto-generated method stub
		Node currNode = list.head;

		String str = "";

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			str += currNode.data + ",";

			// Go to next node
			currNode = currNode.next;
		}
		String str2 = str.substring(0, str.lastIndexOf(","));
		
		// code for saving into the file
		File file2 = new File("/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/namesoutput");
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

	public static LinkedListUnordered insertNode(LinkedListUnordered list, String data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	private static LinkedListUnordered deleteByTheKeyNode(LinkedListUnordered list, String key) {
		// Store head node
		Node currNode = list.head, prev = null;

		//
		// CASE 1:
		// If head node itself holds the key to be deleted

		if (currNode != null && currNode.data.equals(key)) {
			list.head = currNode.next; // Changed head

			// Display the message
			System.out.println(key + " found and deleted");

			// Return the updated List
			return list;
		}

		//
		// CASE 2:
		// If the key is somewhere other than at head
		//

		// Search for the key to be deleted,
		// keep track of the previous node
		// as it is needed to change currNode.next
		while (currNode != null && !currNode.data.equals(key)) {
			// If currNode does not hold key
			// continue to next node
			prev = currNode;
			currNode = currNode.next;
		}

		// If the key was present, it should be at currNode
		// Therefore the currNode shall not be null
		if (currNode != null) {
			// Since the key is at currNode
			// Unlink currNode from linked list
			prev.next = currNode.next;

			// Display the message
			System.out.println(key + " found and deleted");
		}

		//
		// CASE 3: The key is not present
		//

		// If key was not present in linked list
		// currNode should be null
		if (currNode == null) {
			// Display the message
			insertNode(list, key);
		}

		// return the List
		return list;

	}

	private static void printList(LinkedListUnordered list) {
		// TODO Auto-generated method stub.
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
		}

	}
}
