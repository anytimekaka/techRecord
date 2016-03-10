package com.techRecord.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String args[]){
		
		ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>(15, 0.75f, 14);
		map.put(1, 1);
		map.put(5, 5);
		map.put(7, 7);
		map.put(2, null);
		
		System.out.println(15>>>2);
		System.out.println(15>>2);
		
		System.out.println(-15>>>2);
		System.out.println(-15>>2);
	}
}
