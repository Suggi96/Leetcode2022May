class Solution {
    public int lengthOfLongestSubstring(String s) {
                int ans = 0;
        //valid window = a windows in which a > r and all chars between 
        // r to a is unique
        //key char value index of char
        HashMap<Character, Integer> map = new HashMap<>();
        //two pointers a-> aquire and r -> release 
        //a > r in a valid window with unique chars
        //len = a - r + 1
        int r = 0;
        for(int a=0;a<s.length();a++) {
            char curChar = s.charAt(a);
            if(map.containsKey(curChar) && map.get(curChar)>=r) {
                //set r to next position of prev occured cur char
                // this would make window a valid window 
                r = map.get(curChar) + 1; 
                
            }
            map.put(curChar, a);
            ans = Math.max(ans, a-r+1);
            
        }
        return ans;
    }
}