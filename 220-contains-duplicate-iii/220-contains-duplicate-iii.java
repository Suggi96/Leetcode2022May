class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0 || k<0 || t<0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        //floor -> <=
        //ceiling -> >=
        for(int i=0;i<nums.length;i++) {
            Long el = new Long(nums[i]);
            Long floor = set.floor(el);
            if(floor!=null && Math.abs(floor - el) <=t)
                return true;
            Long ceil = set.ceiling(el);
            if(ceil!=null && Math.abs(ceil - el) <=t)
                return true;
            set.add(el);
            if(i>=k)
                set.remove(new Long(nums[i-k]));
        }
        return false;
        
    }
}