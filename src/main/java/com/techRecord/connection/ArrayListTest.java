package com.techRecord.connection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		System.out.println(list.get(0));
		list.remove(0); 	//Two前移了
		System.out.println(list.get(0));
	}

}
