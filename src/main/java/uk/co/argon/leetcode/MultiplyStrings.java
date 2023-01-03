package uk.co.argon.leetcode;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiplyStr("99", "99"));
	}
	
	private static String multiplyStr(String str1, String str2) {
		if(str1.equals("0") || str2.equals("0"))
			return "0";
		
		int[] result = new int[str1.length() + str2.length()];
		
		for(int j=str2.length()-1;j>=0;j--) {
			int i = str1.length() + j;
			int r = 0;
			for(int k=str1.length()-1;k>=0;k--) {
				int p = (str1.charAt(k) - '0')*(str2.charAt(j) - '0') + r;
				r = p/10;
				int v = p%10 + result[i];
				r += v/10;
				result[i--] = v%10;
			}
			result[i] = (r!=0)?r:0;
		}
		String str = (result[0]==0)?Arrays.toString(result).replaceAll("[^0-9]", "").substring(1):Arrays.toString(result).replaceAll("[^0-9]", "");
		
		return str;
	}

}
