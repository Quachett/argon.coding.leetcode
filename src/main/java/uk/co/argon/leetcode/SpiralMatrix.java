package uk.co.argon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(spiralOrder1(new int[][] {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<>();
		int xl = matrix.length;
		int yl = matrix[0].length;
		int x=0,y=0,xx=0,yy=1;
		
		while(true) {
			if(yy==1) {
				if(y==yl-1 || (y<yl-1 && matrix[x][y+1]==-101)) {
					yy=0;
					if(x<xl-1 && matrix[x+1][y]!=-101) xx=1;
				}
			}
			else if(xx==1) {
				if(x==xl-1 || (x<xl-1 && matrix[x+1][y]==-101)) {
					xx=0;
					if(y>0 && matrix[x][y-1]!=-101) yy=-1;
				}
			}
			else if(yy==-1) {
				if(y==0 || (y>0 && matrix[x][y-1]==-101)) {
					yy=0;
					if(x>0 && matrix[x-1][y]!=-101) xx=-1;
				}
			}
			else if(xx==-1) {
				if(x==0 || (x>0 && matrix[x-1][y]==-101)) {
					xx=0;
					if(y<yl-1 && matrix[x][y+1]!=-101) yy=1;
				}
			}
			else
				break;
			//System.out.print(matrix[x][y] + " ");
			spiral.add(matrix[x][y]);
			matrix[x][y]=-101;

			if(xx==1) x++;
			if(xx==-1) x--;
			if(yy==1) y++;
			if(yy==-1) y--;
		}
		
		return spiral;
	}
	
	public static List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> spiral = new ArrayList<>();
		int xl = matrix.length;
		int yl = matrix[0].length;
		int x=0,y=0,xx=0,yy=1,xb=1,yb=0;
		
		while(true) {
			if(yy==1) {
				if(y==yl-1) {
					yy=0;
					yl--;
					if(x<xl-1) xx=1;
				}
			}
			else if(xx==1) {
				if(x==xl-1) {
					xx=0;
					xl--;
					if(y>yb) yy=-1;
				}
			}
			else if(yy==-1) {
				if(y==yb) {
					yy=0;
					yb++;
					if(x>xb) xx=-1;
				}
			}
			else if(xx==-1) {
				if(x==xb) {
					xx=0;
					xb++;
					if(y<yl-1) yy=1;
				}
			}
			else
				break;
			spiral.add(matrix[x][y]);

			if(xx==1) x++;
			if(xx==-1) x--;
			if(yy==1) y++;
			if(yy==-1) y--;
		}
		
		return spiral;
	}

}
