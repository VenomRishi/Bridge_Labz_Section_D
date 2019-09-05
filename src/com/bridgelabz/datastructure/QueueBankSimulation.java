package com.bridgelabz.datastructure;

import java.util.Scanner;

class QueueBankSimulation {
	private int arr[]; // array to store queue elements
	private int front; // front points to front element in the queue
	private int rear; // rear points to last element in the queue
	private int capacity; // maximum capacity of the queue
	private int count; // current size of the queue
	private static int bankBalance = 50000;
	static Scanner scanner = new Scanner(System.in);

	// Constructor to initialize queue
	QueueBankSimulation(int size) {
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	// Utility function to remove front element from the queue
	public void dequeue() {
		// check for queue underflow
		if (isEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}

		//System.out.println("Removing " + arr[front]);

		front = (front + 1) % capacity;
		count--;
	}

	// Utility function to add an item to the queue
	public void enqueue(int item) {
		// check for queue overflow
		if (isFull()) {
			System.out.println("OverFlow\nProgram Terminated");
			System.exit(1);
		}

		// System.out.println("Inserting " + item);
		System.out.println("For 1.Withdraw\n2.Deposit\n3.enquey");
		int choice = scanner.nextInt();
		int amount;
		switch (choice) {
		case 1:
			System.out.println("how much amount you want to withdraw");
			amount = scanner.nextInt();
			if (amount < bankBalance) {
				bankBalance = bankBalance - amount;
			} else {
				System.out.println("Bank has not enough money to give");
			}
			System.out.println("Bank balance is: "+bankBalance);
			break;
		case 2:
			System.out.println("how much amount you want to deposit");
			amount = scanner.nextInt();
			bankBalance = bankBalance + amount;
			System.out.println("Bank balance is: "+bankBalance);
			break;
		case 3:
			System.out.println("Please call to customer care");
			break;
		default:
			System.out.println("invalid option");
			break;
		}

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	// Utility function to return front element in the queue
	public int peek() {
		if (isEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}
		return arr[front];
	}

	// Utility function to return the size of the queue
	public int size() {
		return count;
	}

	// Utility function to check if the queue is empty or not
	public Boolean isEmpty() {
		return (size() == 0);
	}

	// Utility function to check if the queue is empty or not
	public Boolean isFull() {
		return (size() == capacity);
	}

	// Queue implementation in java
	public static void main(String[] args) {
		// create a queue of capacity 5

		System.out.println("Enter people size");
		int people = scanner.nextInt();// 5
		QueueBankSimulation queue = new QueueBankSimulation(people);
		for (int i = 0; i < people; i++) {
			queue.enqueue(i);
			System.out.println("Customer in row: " + queue.peek());
			queue.dequeue();
		}

		

		if (queue.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");

		scanner.close();
	}
}
