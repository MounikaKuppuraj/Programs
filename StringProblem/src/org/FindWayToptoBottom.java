package org;

public class FindWayToptoBottom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int path[][]= {{1,0,1,0,0},{1,1,1,1,1},{0,0,0,1,0},{1,0,1,1,1},{0,1,1,0,1}};
			if(findPath(path,0,0)) {
				System.out.println(true);
			}
			else {
				System.out.println(false);
		}
	}

	private static boolean findPath(int[][] path,int i,int j) {
		int row=path.length,col=path[0].length;
		if(i>=row || j>=col || path[i][j]==0) {
			return false;
		}
		if(path[i][j]!=0 && i==row-1 && j==col-1) {
			return true;
		}
		if(findPath(path,i+1,j)) {
			return true;
		}
		if(findPath(path,i,j+1)) {
			return true;
		}
		return false;
	}

}
