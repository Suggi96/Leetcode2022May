class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void backTrack(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || index==candidates.length) {
            return;
        }
        for(int i=index;i<candidates.length;i++) {
                if(candidates[i]<=target) {
                list.add(candidates[i]);
                backTrack(candidates, i, target-candidates[i], list, ans);
                list.remove(list.size()-1);
                }
        }
    }
}