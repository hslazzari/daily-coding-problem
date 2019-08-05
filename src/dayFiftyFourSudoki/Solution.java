package dayFiftyFourSudoki;

public class Solution {

	public static void main(String[] args) {
	    int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 8, 0, 0, 0, 0, 4, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 6, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                     {2, 0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 2, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0, 0}};    
	
	
	
	    solveSudoku(board, 0, 0, 9);
	    for(int line = 0; line < 9; line++) {
	    	for(int column = 0; column < 9; column++) {
	    		System.out.format("%d ", board[line][column]);
	    	}
	    	System.out.println("");
	    }
	}

	public static boolean solveSudoku(int[][] board, int line, int column, int size) {
	    
	    boolean[] used = new boolean[10];
	
	    int newLine = (column == size - 1) ? line + 1 : line;
	    int newColumn = (column == size - 1) ? 0 : column + 1;
	
	    if(line == size) {
	    	return true;
	    }
	
	    if(board[line][column] != 0) {
	        return solveSudoku(board, newLine, newColumn, size);
	    }
	
	    for(int i = 0; i < size; i++) {
	        used[board[line][i]] = true;
	        used[board[i][column]] = true;
	    }
	    int startLine = (line / 3) * 3;
	    int startColumn = (column / 3) * 3;
	    for(int i = 0; i < 3; i++) {
	    	used[board[startLine + i][startColumn]] = true;
	    	used[board[startLine + i][startColumn + 1]] = true;
	    	used[board[startLine + i][startColumn + 2]] = true;
	    }
	    
	
	    for(int number = 1; number <= 9; number++) {
	        if(!used[number]) {
	            used[number] = true;
	            board[line][column] = number;
	            if(solveSudoku(board, newLine, newColumn, size))
	                return true;
	            board[line][column] = 0;
	            used[number] = false;
	        }
	    }
	    return false;
	}
}
