class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        int prefixSum = 0;
        for(int a=0;a<nums.length;a++) {
            int el = nums[a];
            prefixSum += el;
            if(map.containsKey(el) && map.get(el)<= a) {
                int old_r = r;
                r = map.get(el) + 1;
                prefixSum = prefixSum - diffUpto(old_r, r-1, map, nums);
            }
            map.put(el, a);
            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum;
    }
    private int diffUpto(int start, int end, Map<Integer, Integer> map, int[] nums) {
        int curSum = 0;
        for(int i=start;i<=end;i++) {
            curSum += nums[i];
            map.remove(nums[i]);
        }
        return curSum;
    }
}