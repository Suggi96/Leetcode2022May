class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] words = s.split(" ");
        if(pattern.length()!=words.length)
            return false;
        
        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            if(map1.containsKey(c)) {
                if(map1.get(c).equals(w)==false) return false;
            }
            else {
                if(map2.get(w)!=null && map2.get(w) != c) {
                    return false;
                }
                else {
                    map1.put(c, w);
                    map2.put(w, c);
                }
            }
                
        }
        return true;                                          
    }
}