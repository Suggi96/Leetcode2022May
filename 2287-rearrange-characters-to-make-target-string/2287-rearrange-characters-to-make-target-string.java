class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];
        for(char c: s.toCharArray()) {
            sfreq[c - 'a']++;
        }
        for(char c: target.toCharArray()) {
            tfreq[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(char c: target.toCharArray()) {
            ans = Math.min(ans, sfreq[c - 'a']/tfreq[c - 'a']);
        }
        return ans;
    }
    
}