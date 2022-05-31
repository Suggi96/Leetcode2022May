class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cfreq = new int[26];
        for(char c: chars.toCharArray()) {
            cfreq[c - 'a']++;
        }
        int len = 0;
        for(int i=0;i<words.length;i++) {
            int[] wfreq = new int[26];
            for(char c: words[i].toCharArray()) {
            wfreq[c - 'a']++;
        }
            if(isValid(wfreq, cfreq))
                len += words[i].length();
    }
        return len;
    }
    private boolean isValid(int[] wfreq, int[] cfreq) {
        for(int i=0;i<wfreq.length;i++) {
            if(wfreq[i]>cfreq[i])
                return false;
        }
        return true;
    }
}