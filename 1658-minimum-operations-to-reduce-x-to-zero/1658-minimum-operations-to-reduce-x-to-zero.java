class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, res = Integer.MIN_VALUE, target = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //to handle corner case
        for(int i=0;i<n;i++) {
            sum += nums[i];
            map.put(sum, i);
        }
            
        target = sum - x;
        if(target<0) return -1;
        if(target==sum) return n;
        //find longest subarray of sum which is equal to prefixSum - target
        sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            if(map.containsKey(sum-target))
                res = Math.max(res, i-map.get(sum-target));
        }
        return res==Integer.MIN_VALUE? -1:n-res;
    }
}