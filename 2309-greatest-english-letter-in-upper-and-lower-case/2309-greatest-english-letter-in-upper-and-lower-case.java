class Solution {
    public String greatestLetter(String s) {
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for(char c: s.toCharArray()) {
            if(c>='a' && c<='z') {
                lower[c - 'a'] = true;
            }
            else {
                upper[c - 'A'] = true;
            }
        }
        for(int i=25;i>=0;i--) {
            if(lower[i]==true && upper[i]==true)
                return (char)(i + 'A') + "";
        }
        return "";
    }
    
}