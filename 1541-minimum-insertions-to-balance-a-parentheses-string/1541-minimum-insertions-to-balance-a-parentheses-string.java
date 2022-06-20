class Solution {
    public int minInsertions(String s) {
        int stSize = 0, invalidCnt = 0;
        s = s.replace("))", "}");
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(') {
                stSize++;
            }
            else {
                if(c==')') {
                    invalidCnt++;
                }
                if(stSize==0) {
                    invalidCnt++;
                }
                else {
                    stSize--;
                }
            }
        }
        return invalidCnt + 2*stSize;
    }
}