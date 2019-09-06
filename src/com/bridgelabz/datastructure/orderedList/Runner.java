package com.bridgelabz.datastructure.orderedList;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		list.insert(10);
		list.insert(5);
		list.insert(15);
		list.insert(100);
		list.insert(500);
		list.insert(200);
		list.show();
		list.sort();
		System.out.println();
		list.show();
	}

}
