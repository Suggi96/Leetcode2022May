class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int oneStep = minCost(cost, 0, new HashMap<>());
        int twoStep = minCost(cost, 1, new HashMap<>());
        return Math.min(oneStep, twoStep);
    }
    private int minCost(int[] cost, int idx, HashMap<Integer, Integer> memo) {
        if(idx>=cost.length) {
            return 0;
        }
        int key = idx;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int a = cost[idx] + minCost(cost, idx+1, memo);
        int b = cost[idx] + minCost(cost, idx+2, memo);
        memo.put(key, Math.min(a,b));
        return Math.min(a, b);
    }
}