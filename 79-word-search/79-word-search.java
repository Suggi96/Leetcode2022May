class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(dfs(board, i, j, 0, m, n, word))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, int i, int j, int idx, int m, int n, String word) {
        if(idx==word.length())
            return true;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=word.charAt(idx) || grid[i][j]=='*')
            return false;
        
        char temp = grid[i][j];
        grid[i][j] = '*';
        boolean result = dfs(grid, i, j+1, idx+1, m, n, word) || dfs(grid, i, j-1, idx+1, m, n, word) ||
                         dfs(grid, i+1, j, idx+1, m, n, word) || dfs(grid, i-1, j, idx+1, m, n, word);
        
        grid[i][j] = temp;
        return result;
        
    }
}