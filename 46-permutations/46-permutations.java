class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }
    private void dfs(int[] nums, int start, List<List<Integer>> res) {
        if(start==nums.length) {
            res.add(addArray(nums));
        }
        for(int i=start;i<nums.length;i++) {
            swap(nums, i, start);
            dfs(nums, start+1, res);
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