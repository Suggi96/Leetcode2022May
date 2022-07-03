class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        
        int up = 1;
        int down = 1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]==nums[i+1]) continue;
            else if(nums[i]<nums[i+1]) {
                up = down + 1; //uphill case
            }
            else {
                down = up + 1; //downhill case
            }
        }
        return Math.max(up, down);
    }
}