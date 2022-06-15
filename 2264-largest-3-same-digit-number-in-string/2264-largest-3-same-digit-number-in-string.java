class Solution {
    public String largestGoodInteger(String num) {
        int maxi = -1;
        int i = 0;
        while(i+3<=num.length()) {
            String s = num.substring(i, i+3);
            boolean valid = true;
            for(int j=1;j<s.length();j++) {
                if(s.charAt(j-1)!=s.charAt(j))
                    valid = false;
            }
            if(valid) 
                maxi = Math.max(maxi, Integer.parseInt(s));
            i++;
        }
        if(maxi==-1)
            return "";
        if(maxi==0)
            return "000";
        
        return maxi + "";
    }
}