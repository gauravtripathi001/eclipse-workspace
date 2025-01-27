//package com.synopsys.problem;
//
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.HashSet;
//import java.util.Set;
//import org.junit.jupiter.api.Test;
//
//class TwoSumTest {
//	TwoSum twoSum = new TwoSum();
//
//	@Test
//	void test1() {
//		
//		int[] test1 = {1, 8, 2, 3, 5, 7};
//		
//		//Expected results
//		Pair pair1=new Pair(2,8);
//		Pair pair2=new Pair(3,7);
//		Set<Pair> expected = new HashSet<Pair>();
//		expected.add(pair1);
//		expected.add(pair2);
//		String expectedResult=twoSum.getPairs(expected);
//		
//		//Result from created method
//		Set<Pair> uniquePairs1 = twoSum.findPairsWithSum(test1, 10);
//		String result=twoSum.getPairs(uniquePairs1);
//		
//		assertEquals(expectedResult,result);
//	}
//	
//	@Test
//	void test2() {
//		
//		int[] test2 = {1, 8, 4, 9, 5, 7};
//		
//		//Expected results
//		Pair pair1=new Pair(1,9);
//		Set<Pair> expected = new HashSet<Pair>();
//		expected.add(pair1);
//		String expectedResult=twoSum.getPairs(expected);
//		
//		//Result from created method
//		Set<Pair> uniquePairs2 = twoSum.findPairsWithSum(test2, 10);
//		String result=twoSum.getPairs(uniquePairs2);
//		
//		assertEquals(expectedResult,result);
//	}
//	
//	@Test
//	void test3() {
//		
//		int[] test3 = null;
//		
//		//Expected results
//		String expectedResult="No input pairs";
//		
//		//Result from created method
//		Set<Pair> uniquePairs3 = twoSum.findPairsWithSum(test3, 10);
//		String result=twoSum.getPairs(uniquePairs3);
//		
//		assertEquals(expectedResult,result);
//	}
//	
//	@Test
//	void test4() {
//		
//		int[] test4 = {};
//		
//		//Expected results
//		String expectedResult="No input pairs";
//		
//		//Result from created method
//		Set<Pair> uniquePairs4 = twoSum.findPairsWithSum(test4, 10);
//		String result=twoSum.getPairs(uniquePairs4);
//		
//		assertEquals(expectedResult,result);
//	}
//	
//	@Test
//	void test5() {
//		
//		int[] test5 = {1};
//		
//		//Expected results
//		//Expected results
//		String expectedResult="No input pairs";
//		
//		//Result from created method
//		Set<Pair> uniquePairs5 = twoSum.findPairsWithSum(test5, 10);
//		String result=twoSum.getPairs(uniquePairs5);
//		
//		assertEquals(expectedResult,result);
//	}
//
//}
