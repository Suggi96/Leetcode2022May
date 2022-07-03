class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int val = 'a';
        for(char c: key.toCharArray()) {
            if(c!=' ' && map.get(c)==null) {
                map.put(c, (char)val);
                val++;
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c: message.toCharArray()) {
            if(c==' ') {
                res.append(" ");
            }
            else
            res.append(map.get(c));
        }
        return res.toString();
    }
}