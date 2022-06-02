class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backTrack(nums, visited, new ArrayList<>(), set);
        for(List<Integer> l: set) {
            ans.add(l);
        }
        return ans;
    }
    private void backTrack(int[] nums, boolean[] visited, List<Integer> curSubList, Set<List<Integer>> set) {
        if(curSubList.size()==nums.length) {
            set.add(new ArrayList<>(curSubList));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i]==false) {
                curSubList.add(nums[i]);
                visited[i] = true;
                backTrack(nums, visited, curSubList, set);
                visited[i] = false;
                curSubList.remove(curSubList.size()-1);
            }
        }
    }
}