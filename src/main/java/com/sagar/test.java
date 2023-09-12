package com.sagar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] inputArray = { 2, 3, 4, 3, 4, 3, 4, 5, 6 };
		int[] result = getDuplicateArray(inputArray);
		for (int i : result) {
			System.out.println(i);
		}
	}

	@Override
	public String toString() {
		return "test []";
	}

	public static int[] getDuplicateArray(int[] inputArray) {
		int[] outputArray = new int[0];
		if (inputArray == null || inputArray.length <= 2) {
			return outputArray;
		} else {
			Set tempSet = new HashSet();
			Map tempMap = new HashMap();
			try {
				System.out.println("Before for loop:");
				for (int i = 0; i < inputArray.length; i++) {
					System.out.println("In for loop:" + inputArray[i]);
					if (!tempSet.add(inputArray[i])) {
						if (tempMap.get(inputArray[i]) != null) {
							outputArray = Arrays.copyOf(outputArray, outputArray.length + 1);
							outputArray[outputArray.length - 1] = inputArray[i];
						} else {
							tempMap.put(inputArray[i], 2);
						}
					}
				}
				System.out.println(tempSet);
				System.out.println(tempMap);
				return outputArray;
			} catch (Exception e) {
				e.printStackTrace();
				return outputArray;
			} finally {
				tempSet = null;
				tempMap = null;
			}
		}
	}

}
