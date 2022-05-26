class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
       // List<List<String>> answer = new ArrayList<>();
        solveQueen(board, 0, n);
        return count;
    }
    private void solveQueen(char[][] board, int curRow, int n) {
        if(curRow==n) {
            count++;
            return;
        }
        //travel board columnwise and call recursively row+1
        for(int i=0;i<n;i++) {
            if(isValid(board, curRow, i, n)) {
                board[curRow][i] = 'Q';
                solveQueen(board, curRow+1, n);
                board[curRow][i] = '.';
            }
        }
        
    }
    private boolean isValid(char[][] board, int curRow, int curCol, int n) {
        return rowValid(board, curRow, n) && colValid(board, curCol, n) && diaValid(board, curRow, curCol, n);
    }
    private boolean rowValid(char[][] board, int curRow, int n) {
        for(int i=0;i<n;i++) {
            if(board[curRow][i]=='Q')
                return false;
        }
        return true;
    }
    private boolean colValid(char[][] board, int curCol, int n) {
        for(int i=0;i<n;i++) {
            if(board[i][curCol]=='Q')
                return false;
        }
        return true;
    }
    private boolean diaValid(char[][] board, int curRow, int curCol, int n) {
        int row = curRow;
        int col = curCol;
        //check left upper diagonal r-- c--
        while(row>=0 && col>=0) {
            if(board[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        //check right upper diagonal r-- c++
        row = curRow;
        col = curCol;
        while(row>=0 && col<n) {
            if(board[row][col]=='Q')
                return false;
            row--;
            col++;
        }
        return true;
    }
    
}