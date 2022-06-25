class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                if(i-1>=0 && i+1<nums.length && nums[i-1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                    count++;
                }
                else {
                    nums[i] = nums[i+1];
                    count++;
                }
            }
            if(count>1) return false;
        }
        return true;
    }
}