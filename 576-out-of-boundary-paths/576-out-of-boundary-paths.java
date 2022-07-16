class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        HashMap<String,Long> memo = new HashMap<>();
        return (int)dfs(m,n,maxMove,startRow,startColumn, memo);
    }
    private long dfs(int m, int n, int maxMove, int i, int j, HashMap<String,Long> memo) {
        if(i<0 || i>=m || j<0 || j>=n)
            return 1;
        
        if(maxMove<=0)
            return 0;
        
        String key = maxMove + "-" + i + "-" + j + "";
        if(memo.containsKey(key))
            return memo.get(key);
        
        long res = 0;
        res += dfs(m, n, maxMove-1, i, j+1, memo);
        res += dfs(m, n, maxMove-1, i+1, j, memo);
        res += dfs(m, n, maxMove-1, i-1, j, memo);
        res += dfs(m, n, maxMove-1, i, j-1, memo);
        
        memo.put(key, res%mod);
        return memo.get(key);
    }
}