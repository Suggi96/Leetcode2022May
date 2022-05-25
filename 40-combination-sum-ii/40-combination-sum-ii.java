class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, temp, res);
        return res;
    }
    private void helper(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> res) {
        if(target<0)
            return;
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<candidates.length;i++) {
            if(i>start && candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, temp, res);
            temp.remove(temp.size()-1); //backtracking step
        }
    }
}