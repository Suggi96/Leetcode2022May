class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(1, n, k, temp, res);
        return res;
    }
    private void helper(int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size()==k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++) {
            temp.add(i);
            helper(i+1, n, k, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}