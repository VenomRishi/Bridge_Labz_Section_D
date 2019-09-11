package com.bridgelabz.datastructure.palindromeChecker;

import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string to check palindrome or not");
//		String str = scanner.next();
		String str = "madam";
		String revFront = "";
		Deque deque = new Deque(str.length());

		for (int i = 0; i < str.length(); i++) {
			deque.insertFront(str.charAt(i));
		}
		for (int i = 0; i < str.length(); i++) {
			revFront += deque.getFront();
			deque.deleteFront();
		}
		
		if(revFront.equals(str)) {
			System.out.println("String is palindrome");
		}else {
			System.out.println("String is not palindrome");
		}
		scanner.close();

	}

}
