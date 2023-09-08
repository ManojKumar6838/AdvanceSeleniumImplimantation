package com.TestScripts;

public class CreateRandomAlphaNumeric {

	public static void main(String[] args) {
		int n=20;
		
		//Choose a char randomly from the below String
		String alphaNnumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		//Create String Builder of the size
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++) {
			//Create a random num b/w 0 to length of alphaNnumericString
			int index=(int) ((int)alphaNnumericString.length()*Math.random());
			//Add char one by @ end of sb
			sb.append(alphaNnumericString.charAt(index));
			
		}
		System.out.println(sb);
	}
}
