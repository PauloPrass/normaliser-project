package com.backend.normaliser.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Normaliser {
	
	final List<String> jobTitles = new ArrayList<>();
	
	public Normaliser() {
		jobTitles.add("architect");
		jobTitles.add("software engineer");
		jobTitles.add("quantity surveyor");
		jobTitles.add("accountant");
	}

	public Map<String, Double> normaliseScore(String text) {
		Map<String, Double> map = new HashMap<>();
		String[] strings = text.toLowerCase().split(" ");
		for(int i = 0; i < strings.length; i++) {
			for (String string : jobTitles) {
				checkValue(strings, map, string, i);
			}
		}
		return map;
	}
	
	private void checkValue(String[] strings, Map<String, Double> map, String string, int i) {
		if(strings[i].contains(string)) {
			if(map.containsKey(string)) map.put(string, map.get(string) + (1.0/(double)strings.length));
			else map.put(string, (1.0/(double)strings.length));
		} else if(string.contains(strings[i])) {
			if(map.containsKey(string)) map.put(string, map.get(string) + (1.0/(double)strings.length));
			else map.put(string, (1.0/(double)strings.length));
		} else if(!map.containsKey(string)) map.put(string, 0.0);
	}
	
	public String normalise(String text) {
		Map<String, Double> map = new HashMap<>();
		String[] strings = text.toLowerCase().split(" ");
		for(int i = 0; i < strings.length; i++) {
			for (String string : jobTitles) {
				checkValue(strings, map, string, i);
			}
		}
		Double score = 0.0;
		String value = "";
		for (Entry<String, Double> entry : map.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			if(score < val) {
				score = val;
				value = key;
			}
		}
		return value;
	}
}
