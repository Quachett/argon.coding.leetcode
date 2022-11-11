package uk.co.argon.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(91));
	}
	
	private static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>(); 
		while(n!=1 && !set.contains(n)) {
			set.add(n);
			n = getSum(n);
		}
		return n==1;
	}
	
	private static int getSum(int n) {
		int sum = 0;
		while(n>0) {
			int r = n%10;
			n=n/10;
			sum+=r*r;
		}
		return sum;
	}

}
