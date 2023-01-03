package uk.co.argon.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[] {"ab","a"}));
	}
	
	private static String longestCommonPrefix(String[] strs) {
		String str = strs[0];
		
		if(strs.length==1)
			return str;
		int i = 0;
		
		outerloop:
		while(i<str.length()) {
			for(String s: strs) {
				if(s.length()<=i || s.length()>i && str.charAt(i) != s.charAt(i))
					break outerloop;
			}
			i++;
		}
		
		if(i>0)
			return str.substring(0, i);

		return "";
	}

}
