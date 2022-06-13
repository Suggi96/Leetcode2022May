class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(triangle, 0, 0, triangle.size(), memo);
    }
    private int helper(List<List<Integer>> triangle, int r, int c, int rows, Map<String, Integer> memo) {
        if(r>=rows)
            return 0;
        
        String key = r + "-" + c;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int nextR = helper(triangle, r+1, c, rows, memo);
        int nextRC = helper(triangle, r+1, c+1, rows, memo);
        int ans = triangle.get(r).get(c) + Math.min(nextR, nextRC);
        memo.put(key, ans);
        return memo.get(key);
        
       // return triangle.get(r).get(c) + Math.min(helper(triangle, r+1, c, rows), helper(triangle, r+1, c+1, rows));
    }
}