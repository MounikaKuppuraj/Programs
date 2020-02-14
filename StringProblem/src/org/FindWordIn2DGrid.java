package org;

public class FindWordIn2DGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][]= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="SEE";
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(dp(i,j,word,board)) {
					System.out.println(true);
				}
			}
		}
	}

	private static boolean dp(int i, int j, String word, char[][] board) {
		int row=board.length,col=board[0].length;
		if(i<0 || i>=row || j<0 || j>=col || board[i][j]=='.') {
			return false;
		}
		if(word.charAt(0)==board[i][j] && word.length()==1) {
			return true;
		}
		if(word.charAt(0)!=board[i][j]) {
			return false;
		}
		char c=board[i][j];
		board[i][j]='.';
		if(dp(i+1,j,word.substring(1),board)) {
			return true;
		}
		if(dp(i-1,j,word.substring(1),board)) {
			return true;
		}
		if(dp(i,j+1,word.substring(1),board)) {
			return true;
		}
		if(dp(i,j-1,word.substring(1),board)) {
			return true;
		}
		board[i][j]=c;
		return false;
	}

}
