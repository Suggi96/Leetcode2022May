class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if(index>=nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(nums, index+1, list, ans);
        list.remove(list.size()-1);
        helper(nums, index+1, list, ans);
    }
}