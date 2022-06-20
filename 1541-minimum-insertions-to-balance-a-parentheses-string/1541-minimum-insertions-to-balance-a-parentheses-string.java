class Solution {
    public int minInsertions(String s) {
        int invalidCnt = 0, stSize = 0;
        String S = s.replace("))", "}");
        for(int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if(c=='(') {
                stSize++;
            }
            else {
                if(c==')') {
                    invalidCnt++;
                }
                if(stSize==0) { //stack is empty 
                    invalidCnt++;
                } 
                else { //stack is not empty
                    stSize--; //pop the ( from stack
                }       
            }
        }
        return invalidCnt + 2*stSize;
    }
}