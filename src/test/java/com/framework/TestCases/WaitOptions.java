package com.framework.TestCases;

import java.util.Arrays;
import java.util.List;

public class WaitOptions {
	
public static void main(String[] args) {
	
	//inline initialization
	String[] strArray1 = new String[] {"A","B","C"};
	String[] strArray2 = {"A","B","C"}; 
	System.out.println(strArray2);

	//initialization after declaration
	String[] strArray3 = new String[3];
	strArray3[0] = "A";
	strArray3[1] = "B";
	strArray3[2] = "C";
	
	List<String> vowelsList = Arrays.asList(strArray1);
	System.out.println("vowelsList = "+vowelsList);
}

}

