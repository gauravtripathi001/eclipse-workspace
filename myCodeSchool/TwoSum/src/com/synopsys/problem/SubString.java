package com.synopsys.problem;

//Java program to check if a string is 
//substring of other. 
class SubString { 
	
	// Returns true if s1 is substring of s2 
	String isSubstring(String bigString, String smallString) 
	{ 
		int smallLen = smallString.length(); 
		int bigLen = bigString.length();
		
		if(smallLen>bigLen)
			return "No";
	
		/* A loop to check for s1 in s2 index by index */
		for (int bigIndex = 0; bigIndex <= bigLen - smallLen; bigIndex++) { 
			int smallIndex; 
	
			/* For current index i, check for 
			pattern match */
			for (smallIndex = 0; smallIndex < smallLen; smallIndex++) 
				if (bigString.charAt(bigIndex + smallIndex) != smallString.charAt(smallIndex)) 
					break; 
	
			if (smallIndex == smallLen) 
				return "Yes"; 
		} 
	
		return "No"; 
	} 
	
//	/* Driver program to test above function */
//	public static void main(String args[]) 
//	{ 
//		String s1 = "fora"; 
//		String s2 = "geeksforgeeks"; 
//		
//		String res = isSubstring(s1, s2); 
//		
//		if (res == "No") 
//			System.out.println("Not present"); 
//		else
//			System.out.println("Present"); 
//	} 
} 



//package com.synopsys.problem;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Program to solve the 2 sum problem
// * Problem statement - Write classes to find any pairs of numbers in a sequence that add up to 10.
// * 
// * 
// *
// */
//public class TwoSum {
//	
//	/**
//	 * Method to return all the unique pairs in a given integer array that sum up to a target value
//	 * Time complexity - O(n)
//	 * Space complexity - Best/Average of O(1) and Worst case of O(n)
//	 * 
//	 * @param array
//	 * @param target
//	 * @return
//	 */
//	public Set<Pair> findPairsWithSum(int[] array, int target) {
//		if(array == null || array.length == 0) {
//			return null;
//		}
//		Set<Pair> uniquePairs = new HashSet<Pair>();
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i=0; i<array.length; i++) {
//			int difference = target - array[i];
//			if(map.containsKey(array[i])) {
//				Pair pair = new Pair(difference, array[i]);
//				uniquePairs.add(pair);
//			} else {
//				map.put(difference, array[i]);
//			}
//		}
//		return uniquePairs;
//	}
//	
//	
//	//Output formatted strings 
//	
//	void printPairs(Set<Pair> pairs) {
//		if(pairs != null && !pairs.isEmpty()) {
//			String previousSeparator = "";
//			for(Pair pair : pairs) {
//				System.out.print(previousSeparator + "(" + pair.getFirst() + "," + pair.getSecond() + ")");
//				previousSeparator = ",";
//			}
//		} else {
//			System.out.println("No input pairs");
//		}
//	}
//	
//	//Get the result as a string
//	
//	String getPairs(Set<Pair> pairs) {
//		if(pairs != null && !pairs.isEmpty()) {
//			StringBuilder sb=new StringBuilder();
//			String previousSeparator = "";
//			for(Pair pair : pairs) {
//				sb.append(previousSeparator + "(" + pair.getFirst() + "," + pair.getSecond() + ")");
//				previousSeparator = ",";
//			}
//			return sb.toString();
//		}
//			
//		return "No input pairs";
//		
//	}
//	
//
//}
//
///**
// * Class to store the integer pairs
// * 
// *
// */
//class Pair{
//	private int first;
//	private int second;
//	
//	public int getFirst() {
//		return first;
//	}
//	public void setFirst(int first) {
//		this.first = first;
//	}
//	public int getSecond() {
//		return second;
//	}
//	public void setSecond(int second) {
//		this.second = second;
//	}
//
//	
//	
//	/*
//	 * Overriding the constructor to maintain unique pairs
//	 * This avoids pairs like (2,4) and (4,2)
//	 */
//	Pair(int first, int second) {
//		if(first > second) {
//			this.first = second;
//			this.second = first; 
//		} else {
//			this.first = first;
//			this.second = second; 
//		}
//	}
//	
//	
//	
//	@Override
//	public int hashCode() {
//		return this.first + this.second;
//	}
//	
//	@Override
//	public boolean equals(Object object) {
//		Pair pair = (Pair)object;
//		return(pair.first == this.first && pair.second == this.second);
//	}
//}