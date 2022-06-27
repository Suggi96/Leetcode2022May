class Solution {
    public int countAsterisks(String s) {
        boolean pairAst = true;
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='|') {
                pairAst = !pairAst;
            }
            if(c=='*' &&  pairAst==true) 
                count++;
        }
        return count;
    }
}