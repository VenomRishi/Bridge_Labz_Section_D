package com.bridgelabz.datastructure.balancedParanthesis;

public class Stack {
	char[] stack = new char[6];
	int top;

	public void push(char data) {
		if (isFull()) {
			System.out.println("Stack is overflow");
		} else {
			stack[top] = data;
			top++;
		}

	}

	public int pop() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("Stack is underflow");
		} else {
			top--;
			data = stack[top];
			stack[top] = 0;
			return data;
		}

		return data;
	}

	public char peek() {
		char data;
		data = stack[top - 1];
		return data;
	}

	public boolean isEmpty() {
		
		return top==0;
	}

	public boolean isFull() {
		
		return top==stack.length;
	}

	public void show() {
		for (int num : stack) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	public int size() {
		return top;
	}
}
