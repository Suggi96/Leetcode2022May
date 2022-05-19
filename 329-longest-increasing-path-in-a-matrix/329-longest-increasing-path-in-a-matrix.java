class Solution {
    int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null) return 0;
        int m = matrix.length, n = matrix[0].length;
        int longestPath = 0;
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int path = dfs(matrix, m, n, i, j, memo);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }
    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memo) {
        if(memo[i][j]>0)
            return memo[i][j];
        int len = 0;
        for(int[] d: dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x>=0 && y>=0 && x<m && y<n && matrix[x][y]>matrix[i][j])
                len = Math.max(len, dfs(matrix, m, n, x, y, memo));
        }
        memo[i][j] = len+1;
        return len+1;
    }
}