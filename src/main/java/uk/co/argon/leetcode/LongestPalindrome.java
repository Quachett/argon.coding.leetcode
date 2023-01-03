package uk.co.argon.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome(getArray()));
	}
	
	private static int longestPalindrome(String[] words) {
		Map<String, Integer> aa = new HashMap<>();
		Map<String, Integer> ab = new HashMap<>();
		int pal = 0;
		
		for(String str: words) {
			if(str.charAt(1) == str.charAt(0)) {
				if(aa.containsKey(str))
					aa.put(str, aa.get(str)+1);
				else
					aa.put(str, 1);
			}
			else {
				String rev = str.charAt(1) + "" + str.charAt(0);
				if(ab.containsKey(rev) && ab.get(rev)>0) {
					System.out.println("str: " + str + "\trev: " + rev);
					pal+=4;
					ab.put(rev, ab.get(rev)-1);
					if(!ab.containsKey(str))
						ab.put(str, 0);
				}
				else {
					int v = (ab.get(str)!=null)?ab.get(str)+1:1;
					ab.put(str, v);
				}
			}
		}
		
		if(!aa.isEmpty())
			for(Entry<String, Integer> e: aa.entrySet())
				pal += ((pal/2)%2!=0 && e.getValue()%2!=0)?(e.getValue()-1)*2:e.getValue()*2;
		
		return pal;
	}
	
	private static String[] getArray() {
		//return new String[] {"lc","cl","gg"};
		//return new String[] {"ab","ty","yt","lc","cl","ab"};
		//return new String[] {"ab","ty","yt","lc","cl","ab","aa"};
		//return new String[] {"ab","ty","yt","lc","cl","ab","aa","bb"};
		//return new String[] {"ab","ty","yt","lc","cl","ba","aa","bb","aa","aa"};
		//return new String[] {"aa","aa","aa","aa","aa","bb","bb","bb","bb","cc","cc","cc","dd","dd","ee"};
		return new String[] {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
		//return new String[] {"ab","ba","aa","aa","aa","aa","aa","bb","bb","bb","bb","cc","cc","cc","dd","dd","ee"};
		//return new String[] {"ab","ba","ba","cd","dc","ef","fe","aa","aa","aa","aa","aa","bb","bb","bb","bb","cc","cc","cc","dd","dd","ee"};
		//return new String[] {"cc","ll","xx"};
	}

}
