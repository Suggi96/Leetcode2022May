class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> answer = new ArrayList<>();
        solveQueen(board, 0, n, answer);
        return answer.size();
    }
    private void solveQueen(char[][] board, int curRow, int n, List<List<String>> answer) {
        if(curRow==n) {
            answer.add(genString(board, n));
            return;
        }
        //travel board columnwise and call recursively row+1
        for(int i=0;i<n;i++) {
            if(isValid(board, curRow, i, n)) {
                board[curRow][i] = 'Q';
                solveQueen(board, curRow+1, n, answer);
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
    
    private List<String> genString(char[][] board, int n) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String s = "";
            for(int j=0;j<n;j++) {
                s += board[i][j];
            }
            list.add(s);
        }
        return list;
    }
}