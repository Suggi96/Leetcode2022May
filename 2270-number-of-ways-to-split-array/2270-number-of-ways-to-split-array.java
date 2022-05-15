class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long sum = 0;
        for(int i: nums) {
            sum += i;
        }
        long curSum = 0;
        for(int i=0;i<nums.length-1;i++) {
            curSum += nums[i];
            long rightSum = sum - curSum;
            if(curSum>=rightSum)
                count++;
        } 
        return count;
    }
}