package com.bridgelabz.datastructure.palindromeChecker;

public class Deque {
	/*
	 * // Operations on Deque: void insertfront(int key); void insertrear(int key);
	 * void deletefront(); void deleterear(); bool isFull(); bool isEmpty(); int
	 * getFront(); int getRear();
	 */
	char[] deque;
	int front;
	int rear;
	int size;

	Deque(int size) {
		deque = new char[size];
		front = -1;
		rear = 0;
		this.size = size;
	}

	public void insertFront(char data) {
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
		deque[front] = data;
	}

	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	public void insertRear(char data) {
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
		deque[rear] = data;
	}

	public void deleteFront() {
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
