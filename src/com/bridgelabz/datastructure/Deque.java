package com.bridgelabz.datastructure;

import java.util.Scanner;

public class Deque {
	static final int MAX = 100;
	int arr[];
	int front;
	int rear;
	int size;

	public Deque(int size) {
		arr = new int[MAX];
		front = -1;
		rear = 0;
		this.size = size;
	}

	/*
	 * // Operations on Deque: void insertfront(int key); void insertrear(int key);
	 * void deletefront(); void deleterear(); bool isFull(); bool isEmpty(); int
	 * getFront(); int getRear();
	 */

	// Checks whether Deque is full or not.
	boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	// Checks whether Deque is empty or not.
	boolean isEmpty() {
		return (front == -1);
	}

	// Inserts an element at front
	void insertfront(int key) {
		// check whether Deque if full or not
		if (isFull()) {
			System.out.println("Overflow");
			return;
		}

		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// front is at first position of queue
		else if (front == 0)
			front = size - 1;

		else // decrement front end by '1'
			front = front - 1;

		// insert current element into Deque
		arr[front] = key;
	}

	// function to inset element at rear end
	// of Deque.
	void insertrear(int key) {
		if (isFull()) {
			System.out.println(" Overflow ");
			return;
		}

		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// rear is at last position of queue
		else if (rear == size - 1)
			rear = 0;

		// increment rear end by '1'
		else
			rear = rear + 1;

		// insert current element into Deque
		arr[rear] = key;
	}

	// Deletes element at front end of Deque
	void deletefront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println("Queue Underflow\n");
			return;
		}

		// Deque has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
		// back to initial position
		if (front == size - 1)
			front = 0;

		else // increment front by '1' to remove current
				// front value from Deque
			front = front + 1;
	}

	// Delete element at rear end of Deque
	void deleterear() {
		if (isEmpty()) {
			System.out.println(" Underflow");
			return;
		}

		// Deque has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0)
			rear = size - 1;
		else
			rear = rear - 1;
	}

	// Returns front element of Deque
	int getFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println(" Underflow");
			return -1;
		}
		return arr[front];
	}

	// function return rear element of Deque
	int getRear() {
		// check whether Deque is empty or not
		if (isEmpty() || rear < 0) {
			System.out.println(" Underflow\n");
			return -1;
		}
		return arr[rear];
	}

	public boolean palindromeChecker(String str) {
		
		return false;

	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string to check palindrome or not");
		String str = scanner.next();// bob

		scanner.close();
	}

}