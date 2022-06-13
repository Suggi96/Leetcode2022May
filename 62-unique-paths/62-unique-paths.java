class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++)
                dp[i][j] = -1;
        
        return totalWays(0, 0, m , n, dp);
    }
    private int totalWays(int i, int j, int m, int n, int[][] dp) {
        if(i==m-1 && j==n-1)
            return 1;
        if(i>=m || j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        
        int left = totalWays(i+1, j, m, n, dp);
        int right = totalWays(i, j+1, m, n, dp);
        
        dp[i][j] = left+right;
        return dp[i][j];
    }
}