class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
        private void helper(int[] nums, int index, List<Integer> list, Set<List<Integer>> ans) {
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