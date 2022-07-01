class Solution {
    public boolean search(int[] nums, int target) {
                int start = 0, end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target) return true;
            
            if( (nums[start] == nums[mid]) && (nums[end] == nums[mid]) ) {
                start++;
                end--;
            }
            
            //check if left half is sorted
           else if(nums[mid]>=nums[start]) {
                //check if target lies in left half
                if(nums[start]<=target && nums[mid]>=target) 
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else {
                //check if target lies in right half
                if(nums[mid]<=target && nums[end]>=target)
                    start = mid + 1;
                else
                    end = mid -1;
            }
        }
        return false;
    }
}