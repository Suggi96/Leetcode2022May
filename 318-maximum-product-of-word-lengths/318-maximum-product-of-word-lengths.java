class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] states = new int[len];
        for(int i=0;i<len;i++) {
            states[i] = toBin(words[i]);
        }
        int maxi = 0;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if((states[i] & states[j])==0) {
                    maxi = Math.max(maxi, words[i].length() * words[j].length());
                }
            }
        }
        return maxi;
    }
    private int toBin(String s) {
        int state = 0;
        for(char c: s.toCharArray()) {
            int index = c-'a';
            state |= (1<<index);
        }
        return state;
    }
}