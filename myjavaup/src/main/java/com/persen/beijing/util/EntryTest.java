package com.persen.beijing.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by persen on 2016/11/6.
 */
public class EntryTest {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");

		List<Map.Entry<String, String>> listEntry = new ArrayList<>();

		for (Map.Entry<String, String> entry : map.entrySet()) {
			HashMap.SimpleEntry<String, String> tmp = new HashMap.SimpleEntry<String, String>(entry.getKey(), entry.getValue());
			listEntry.add(tmp);
		}

		for (int i = 0; i < listEntry.size(); i++) {
			System.out.println(listEntry.get(i).getKey() + " " + listEntry.get(i).getValue());
		}
	}
}
