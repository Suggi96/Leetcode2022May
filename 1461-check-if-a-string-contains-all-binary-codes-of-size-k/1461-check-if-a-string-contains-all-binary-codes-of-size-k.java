class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            if(i+k<=s.length()) {
                String str = s.substring(i, i+k);
             //   System.out.print(str+" ");
                set.add(str);
            }
            
        }
        return set.size()==Math.pow(2,k);
    }
}