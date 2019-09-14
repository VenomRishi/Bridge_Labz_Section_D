package com.bridgelabz.datastructure.palindromeChecker;

public class Deque {
	
	char[] deque;
	int front;
	int rear;
	int size;

	Deque(int size) {
		deque = new char[size];
		front = 0;
		rear = size - 1;
		this.size = size;
	}

	public void insertFront(char data) {
		// check whether Deque if full or not
		if (isFull()) {
			System.out.println("Overflow");
			return;
		} else {
			// insert current element into Deque
			deque[front] = data;
			front++;
		}

	}

	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	public void insertRear(char data) {
		if (isFull()) {
			System.out.println(" Overflow ");
			return;
		} else {
			deque[rear] = data;
			rear--;
		}

		// insert current element into Deque

	}

	public void deleteFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println("Queue Underflow\n");
			return;
		}else {
			deque[front]='0';
			front = front + 1;
			
		}
			
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public void deleteRear() {
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
	public char getFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println(" Underflow");
			return 'u';
		}
		return deque[front];
	}

	// function return rear element of Deque
	char getRear() {
		// check whether Deque is empty or not
		if (isEmpty() || rear < 0) {
			System.out.println(" Underflow\n");
			return 'u';
		}
		return deque[rear];
	}
}
