package uk.co.argon.leetcode;

import java.util.Arrays;

public class BallFall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(findBall(new int[][] {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}})));
		System.out.println(Arrays.toString(findBall(new int[][] {{-1}})));
		System.out.println(Arrays.toString(findBall(new int[][] {{1}})));
		System.out.println(Arrays.toString(findBall(new int[][] {{}})));
		System.out.println(Arrays.toString(findBall(new int[][] {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}})));
	}
	
	private static int[] findBall(int[][] grid) {
		int[] result = new int[grid[0].length];
		for(int i=0; i<grid[0].length; i++)
			result[i] = findBallExit(grid, 0, i);
		return result;
	}
	
	private static int findBallExit(int[][] grid, int i, int j) {
		if(i==grid.length)
			return j;
		
		int jj =  j+grid[i][j];
		if(jj<0 || jj>grid[i].length-1 || (grid[i][j] + grid[i][jj])==0)
			return -1;
		
		return findBallExit(grid, ++i, jj);
	}

}
