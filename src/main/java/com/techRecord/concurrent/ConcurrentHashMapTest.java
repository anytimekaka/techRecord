package com.techRecord.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	private static ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>();
	
	public static void main(String args[]){
		map.put(1, 1);
		System.out.println(15>>>2);
		System.out.println(15>>2);
		
		System.out.println(-15>>>2);
		System.out.println(-15>>2);
	}
}
