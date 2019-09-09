package com.bridgelabz.datastructure.orderedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedListProgram {
	
	public static int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		String[] strArr = readDataFromFile().split(",");
		int[] integerArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			integerArr[i] = Integer.parseInt(strArr[i]);
			list.insert(integerArr[i]);
		}
		size = integerArr.length;
		list.show();
		System.out.println("\nSorting");
		list.sort();
		list.show();
		System.out.println("\nEnter key to search in list:");
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();
		list.searchKey(key);
		scanner.close();
		System.out.println("\nSorting");
		list.sort();
		list.show();
		String strList = list.getListInString();
		saveInFile(strList);

	}

	public static String readDataFromFile() {
		BufferedReader bufferedReader = null;
		String str = "";
		try {
			bufferedReader = new BufferedReader(new FileReader(
					"/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/numbers"));
			str = bufferedReader.readLine();
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	private static void saveInFile(String strList) {
		// TODO Auto-generated method stub
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(
					"/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/numbersoutput"));
			bufferedWriter.write(strList);
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nFile is Written");

	}

}
