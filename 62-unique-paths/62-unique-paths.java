class Solution {
    public int uniquePaths(int m, int n) {
        
        return totalWays(0, 0, m , n, new HashMap<>());
    }
    private int totalWays(int i, int j, int m, int n, HashMap<String, Integer> memo) {
        if(i==m-1 && j==n-1)
            return 1;
        if(i>=m || j>=n)
            return 0;
        String key = i + "-"  + j;
        if(memo.containsKey(key))
            return memo.get(key);
        
        
        int left = totalWays(i+1, j, m, n, memo);
        int right = totalWays(i, j+1, m, n, memo);
        
        memo.put(key, left + right);
        return memo.get(key);
    }
}