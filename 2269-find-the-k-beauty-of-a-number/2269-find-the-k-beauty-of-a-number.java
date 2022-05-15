class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = num + "";
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(i+k<=s.length()) {
                String subStr = s.substring(i, i+k);
                System.out.print(subStr+" ");
                int val = Integer.parseInt(subStr);
                if(val!=0 && num%val==0) count++;
            }
        }
        return count;
    }
}