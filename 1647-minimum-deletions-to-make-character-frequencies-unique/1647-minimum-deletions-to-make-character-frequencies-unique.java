class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int n = 26;
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        int delCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<26;i++) {
            int curFreq = freq[i];
            while(curFreq>0) {
                if(set.contains(curFreq)) {
                    curFreq--;
                    delCount++;
                }
                else {
                    break;
                }
            }
            
            if(curFreq!=0)
                set.add(curFreq);
        }
        return delCount;
    }
}