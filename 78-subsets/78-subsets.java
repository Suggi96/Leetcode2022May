class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        answer.add(new ArrayList<>());
        helper(nums, 0, list, answer);
        return answer;
    }
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> answer) {
        if(index>=nums.length) {
            return;
        }
        for(int i=index;i<nums.length;i++) {
            list.add(nums[i]);
            answer.add(new ArrayList<>(list));
            helper(nums, i+1, list, answer);
            list.remove(list.size()-1);
        }
    }
}