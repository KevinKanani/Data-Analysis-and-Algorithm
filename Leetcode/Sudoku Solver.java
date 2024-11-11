class Solution {
 	public void solveSudoku(char[][] board) {
 		dfs(board, 0, 0);
 	}
 	private boolean dfs(char[][] board, int iStart, int jStart){
 		for(int i = iStart; i < 9; i++, jStart = 0){
 			for(int j = jStart; j < 9; j++){
 				if(board[i][j] != '.') continue;
 				for(char c = '1'; c <= '9'; c++){
 					if(check(board, c, i, j)){
 						board[i][j] = c;
 						if(dfs(board, i, j + 1)) return true;
 						else board[i][j] = '.';
 					}
 				}
 				return false;
 			}
 		}
 		return true;
 	}
 	private boolean check(char[][] board, char c, int row, int col){
 		for(int i = 0; i < 9; i++){
 			if(board[row][i] == c) return false;
 			if(board[i][col] == c) return false;
 			if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] == c)
 				return false;
 		}
 		return true;
 	}
 }
