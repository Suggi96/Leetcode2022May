class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<=2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0, e = n-1;
        while(s+1<n && nums[s]==nums[s+1]) s++;
        while(e-1>=0 && nums[e-1]==nums[e]) e--;
        int count = 0;
        for(int i=s+1;i<e;i++) 
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        for(int freq: map.values()) {
            count += freq;
        }
        return count;
        
    }
}