class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        backTrack(1, n, k, new HashSet<>(), set);
        return new ArrayList<>(set);
    }
    private void backTrack(int startVal, int remainingSum, int k, Set<Integer> runningSet, Set<List<Integer>> set) {
        if(remainingSum==0) {
            if(k==0) {
                set.add(new ArrayList<>(runningSet));
                return;
            }
            else {
                return;
            }
        }
        if(remainingSum<0)
            return;
        
        for(int i=startVal;i<=9;i++) {
            runningSet.add(i);
            backTrack(i+1, remainingSum-i, k-1, runningSet, set);
            runningSet.remove(i);
        }
    }
}