class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<String, Integer> memo = new HashMap<>();
        int ans = totalWays(coins, amount, 0, memo);
        if(ans==100000)
            return -1;
        return ans;
    }
    private int totalWays(int[] coins, int amount, int currentIdx, HashMap<String, Integer> memo) {
        if(currentIdx>=coins.length)
            return 100000;
        if(amount==0)
            return 0;
            
        String key = currentIdx + "-" + amount;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = 100000;
        if(coins[currentIdx]<=amount)
            consider = 1 + totalWays(coins, amount-coins[currentIdx], currentIdx, memo);
        int notConsider = totalWays(coins, amount, currentIdx+1, memo);
        
        int res = Math.min(consider, notConsider);
        memo.put(key, res);
        return memo.get(key);
        
    } 
}