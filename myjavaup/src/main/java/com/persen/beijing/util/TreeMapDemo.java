package com.persen.beijing.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by persen on 16/9/26.
 */
public class TreeMapDemo {
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "1");
		map.put(2, "1");

		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			System.out.println(i);
		}
		// creating tree map
		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
		// populating tree map
		treemap.put(1, "two");
		treemap.put(2, "one");
		treemap.put(4, "three");
		treemap.put(7, "four");
		treemap.put(9, "five");

		System.out.println("Checking floor entry for 6");
		System.out.println("Value is: " + treemap.floorEntry(2));

//		System.out.println(treemap.lowerEntry(2));
//
//		System.out.println(treemap.ceilingEntry(2));
//		System.out.println(treemap.higherEntry(2));
//
//		System.out.println(treemap.firstEntry());
//		System.out.println(treemap.lastEntry());

//		System.out.println(treemap.pollFirstEntry());
//		System.out.println(treemap);
//		System.out.println(treemap.pollLastEntry());
//		System.out.println(treemap);
//		System.out.println(treemap.descendingMap());
//
//		System.out.println(treemap.navigableKeySet());
//		System.out.println(treemap.descendingKeySet());

//		System.out.println(treemap.subMap(2, 9));
//
//		System.out.println(treemap.headMap(4, true));
//		System.out.println(treemap.tailMap(4, false));
	}
}
