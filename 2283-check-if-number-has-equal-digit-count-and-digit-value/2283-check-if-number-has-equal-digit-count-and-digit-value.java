class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] freq = new int[10];
        for(char c: num.toCharArray()){
            int val = c - '0';
            freq[val]++;
        }
        for(int i=0;i<n;i++) {
            int key = num.charAt(i) - '0';
            if(freq[i]!=key)
                return false;
        }
        return true;
    }
}