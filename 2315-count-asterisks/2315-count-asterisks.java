class Solution {
    public int countAsterisks(String s) {
        boolean pairAst = false;
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='|') {
                pairAst = !pairAst;
            }
            if(c=='*' &&  pairAst==false) 
                count++;
        }
        return count;
    }
}