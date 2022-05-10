class Solution {
    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target, new HashMap<Integer, Integer>());
    }
    private int helper(int[] nums, int target, HashMap<Integer, Integer> memo) {
        if(target==0)
            return 1;
        
        int key = target;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int res = 0;
        for(int i: nums) {
            if(i<=target) {
                res += helper(nums, target-i, memo);
            }
        }
        
        memo.put(key, res);
        return memo.get(key);
    }
}