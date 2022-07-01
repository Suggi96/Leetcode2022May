class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0]<=nums[n-1]) return nums[0]; //edge case when given is not rotated 
        int start = 0, end = n-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid + 1];
            if(nums[mid]<nums[mid-1])
                return nums[mid];
            
            else if(nums[mid]>=nums[start])
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }
}