class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0) {
                    int area = dfs(grid, i, j, m, n);
                    maxArea = Math.max(maxArea, area);
                }
            } 
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int row, int col, int m, int n) {
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==0)
            return 0;
        grid[row][col] = 0;
        int ans = 1;
        for(int[] d: dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            ans += dfs(grid, newRow, newCol, m, n);
        }
        return ans;
        
    }
}