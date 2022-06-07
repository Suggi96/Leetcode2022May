class Solution {
    int[][] dir = {{0,1}, {-1, 0}, {1, 0}, {0, -1}};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int curCol=0;curCol<n;curCol++) {
            if(grid[0][curCol]==0)
                dfs(grid, 0, curCol, m, n);
            
            if(grid[m-1][curCol]==0)
                dfs(grid, m-1, curCol, m, n);
        }
        for(int curRow=0;curRow<m;curRow++) {
            if(grid[curRow][0]==0) 
                dfs(grid, curRow, 0, m, n);
            
            if(grid[curRow][n-1]==0)
                dfs(grid, curRow, n-1, m, n);
        }
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==0) {
                    dfs(grid, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
        
    }
    private void dfs(int[][] grid, int curRow, int curCol, int m, int n) {
        if(curRow<0 || curRow>=m || curCol<0 || curCol>=n || grid[curRow][curCol]==1)
            return;
        grid[curRow][curCol] = 1;
        for(int[] d: dir) {
            int row = curRow + d[0];
            int col = curCol + d[1];
            dfs(grid, row, col, m, n);
        }
    }
}