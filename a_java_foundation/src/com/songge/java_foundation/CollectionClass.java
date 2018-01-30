package com.songge.java_foundation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionClass {

	public static void main(String[] args) {
		Map<String,String> treeMapTest = new TreeMap<String,String>();
		treeMapTest.put("key1", "v1");
		treeMapTest.put("key2", "v2");
		treeMapTest.put("key3", "v3");
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("key1", "v1");
		linkedHashMap.put("key2", "v2");
		linkedHashMap.put("key3", "v3");
		
	}
	
	public void test() {
		
	}

}
