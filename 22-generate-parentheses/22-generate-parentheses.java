class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        findAllComb(0, 0, "", n, ans);
        return ans;
    }
    private void findAllComb(int opc, int cpc, String s, int n, List<String> ans) {
        if(opc+cpc==2*n) {
            ans.add(s);
            return;
        }
        if(opc<n) {
            findAllComb(opc+1, cpc, s + "(", n, ans);
        }
        
        if(cpc<opc) {
            findAllComb(opc, cpc+1, s + ")", n, ans);
        }
        return;
        
    }
}