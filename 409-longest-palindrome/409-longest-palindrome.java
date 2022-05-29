class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        boolean oddFound = false;
        int maxLen = 0;
        for(int i: map.values()) {
            if(i%2==0)
                maxLen += i;
            else {
                oddFound = true;
                maxLen += i - 1;
            }
        }
        if(oddFound)
            maxLen = maxLen + 1;
        return maxLen;
    }
}