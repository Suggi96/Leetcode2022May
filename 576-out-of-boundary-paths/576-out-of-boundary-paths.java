class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    Long[][][] memo = null;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Long[51][51][51];
        return (int)dfs(m,n,maxMove,startRow,startColumn);
    }
    private long dfs(int m, int n, int maxMove, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n)
            return 1;
        
        if(maxMove<=0)
            return 0;
        
        if(memo[i][j][maxMove]!=null)
            return memo[i][j][maxMove];
        
        long res = 0;
        res += dfs(m, n, maxMove-1, i, j+1);
        res += dfs(m, n, maxMove-1, i+1, j);
        res += dfs(m, n, maxMove-1, i-1, j);
        res += dfs(m, n, maxMove-1, i, j-1);
        
        memo[i][j][maxMove] = res % mod;
        return memo[i][j][maxMove];
    }
}