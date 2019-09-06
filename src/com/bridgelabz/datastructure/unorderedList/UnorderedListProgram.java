package com.bridgelabz.datastructure.unorderedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnorderedListProgram {

	public static void main(String[] args) throws IOException {

		String str = getFromFile();
		String[] strArr = str.split(",");
		LinkedList list = new LinkedList();
		for (int i = 0; i < strArr.length; i++) {
			list.insert(strArr[i]);
		}
		System.out.println("list is : ");
		list.show();
		String key;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the name you want to search in list");
		key = scanner.next();
		list.searchNode(key);
		System.out.println("After performing task of key");
		System.out.println("list is : ");
		list.show();
		// code for savingintofile
		String strList = list.getListInString();
		saveInFile(strList);
		scanner.close();

	}

	

	private static String getFromFile() {
		BufferedReader bufferedReader = null;
		String str = "";
		try {
			bufferedReader = new BufferedReader(
					new FileReader("/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/names"));
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
					"/home/admin1/eclipse-workspace/BridgelabzSectionD/src/com/bridgelabz/files/namesoutput"));
			bufferedWriter.write(strList);
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nFile is Written");

	}

}
