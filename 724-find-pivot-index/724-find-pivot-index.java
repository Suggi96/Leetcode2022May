class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i: nums)
            total += i;
        int curSum = 0;
        for(int i=0;i<nums.length;i++) {
            if(total==2*curSum+nums[i])
                return i;
            curSum += nums[i];
        }
        return -1;
    }
}