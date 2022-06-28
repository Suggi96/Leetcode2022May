class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int n = 26;
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        for (int i = 0; i < n / 2; i++) { 
           int temp = freq[i]; 
            freq[i] = freq[n - i - 1]; 
            freq[n - i - 1] = temp; 
        }
        int count = 0;
        int f = freq[0];
        for(int i: freq) {
            if(i>f) {
                if(f>0) count += (i-f);
                else count += i;
            }
            f = Math.min(f-1, i-1);
        }
        return count;
    }
}