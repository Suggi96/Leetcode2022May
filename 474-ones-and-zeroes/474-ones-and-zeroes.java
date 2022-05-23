class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0, new HashMap<String, Integer>());
    }
    private int helper(String[] strs, int zero, int one, int index, HashMap<String, Integer> memo) {
        if(index==strs.length || zero+one==0)
            return 0;
        String key = zero + "-" + one + "-" + index;
        if(memo.containsKey(key))
            return memo.get(key);
        int[] count = countZO(strs[index]);
        int consider = 0;
        if(zero>=count[0] && one>=count[1])
            consider = 1 + helper(strs, zero-count[0], one-count[1], index+1, memo);
        int notConsider = helper(strs, zero, one, index+1, memo);
        
        int ans = Math.max(consider, notConsider);
        memo.put(key, ans);
        return memo.get(key);
    }
    private int[] countZO(String s) {
        int count[] = new int[2];
        for(char c: s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}