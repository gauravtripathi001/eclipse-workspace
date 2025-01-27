package com.synopsys.problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubStringTest {
	
	SubString substring=new SubString();
	
	@Test
	void test1() {
		String small="is a";
		String big="This is a string";
		
		assertEquals("Yes",substring.isSubstring(big, small));
	}
	
	@Test
	void test2() {
		
		String small="This is a string";
		String big="is a";
		
		assertEquals("No",substring.isSubstring(big, small));
	}
	
	@Test
	void test3() {
		
		String small="";
		String big="";
		
		assertEquals("Yes",substring.isSubstring(big,small));
	}
	
	@Test
	void test4() {
		
		String small="s";
		String big="s";
		
		assertEquals("Yes",substring.isSubstring(small, big));
	}
	
	@Test
	void test5() {
		
		String small="substring";
		String big="This is a string";
		
		assertEquals("No",substring.isSubstring(small, big));
	}

}
