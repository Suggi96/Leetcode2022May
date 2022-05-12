class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(nums, 0, set);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l: set) {
            res.add(l);
        }
        return res;
    }
    private void dfs(int[] nums, int start, Set<List<Integer>> set) {
        if(start==nums.length) {
            set.add(addArray(nums));
        }
        for(int i=start;i<nums.length;i++) {
            swap(nums, i, start);
            dfs(nums, start+1, set);
            swap(nums, i, start); //backtracking step
        }
    }
    private List<Integer> addArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i: arr)
            list.add(i);
        return list;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}