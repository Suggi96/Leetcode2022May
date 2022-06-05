class Solution {
    int[][] directions = {{0,1}, {-1,0}, {1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j]!='0') {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return;
        grid[i][j] = '0'; //visit current cell
        for(int[] d: directions) {
            int r = i + d[0];
            int c = j + d[1];
            dfs(grid, r, c, m, n);
        }
    }
}