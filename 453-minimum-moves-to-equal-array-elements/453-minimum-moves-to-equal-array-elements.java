class Solution {
    public int minMoves(int[] nums) {
        int minEl = Integer.MAX_VALUE;
        for(int i: nums) 
            minEl = Math.min(minEl, i);
        
        int steps = 0;
        for(int i=0;i<nums.length;i++) 
            steps += nums[i] - minEl;
        
        return steps;
    }
}