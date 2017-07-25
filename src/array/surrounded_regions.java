package array;

/**
 * @Description:Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
A region is captured by flipping all'O's into'X's in that surrounded region .
For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
 * @author:王丽雪
 * @time:2017年6月13日下午3:19:49
 */
public class surrounded_regions {
	int dir[][] = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
	public void solve(char[][] board) {
		 if(board == null || board.length <= 0|| board[0].length <= 0){
	        return;
	    }
		int row = board.length;
		int col = board[0].length;
		for(int i = 0; i < col; i++){
			char ch = board[0][i];
			if(ch == 'O'){
				dfs(0,i,board,row,col);
			}
			ch = board[row - 1][i];
			if(ch == 'O'){
				dfs(row - 1,i,board,row,col);
			}
		}
		for(int j = 0; j < row; j++){
			char ch = board[j][0];
			if(ch == 'O'){
				dfs(j,0,board,row,col);
			}
			ch = board[j][col - 1];
			if(ch == 'O'){
				dfs(j,col-1,board,row,col);
			}
		}
	
		for(int i = 0; i < row; i++){
			for(int j = 0;j < col; j++){
				if(board[i][j] == '*'){
					board[i][j] = 'O';
				}else if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
    }
	public void dfs(int curRow,int curCol,char[][] board,int row,int col){
		board[curRow][curCol] = '*';
		for(int i = 0; i < 4; i++){
			int newRow = curRow + dir[i][0];
			int newCol = curCol + dir[i][1];
			if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && board[newRow][newCol] == 'O'){
				dfs(newRow, newCol, board, row, col);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		surrounded_regions surrounded_regions = new surrounded_regions();
		char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		surrounded_regions.solve(board);
		System.out.println();
	}
}
