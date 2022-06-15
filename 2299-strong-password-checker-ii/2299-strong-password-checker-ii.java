class Solution {
    public boolean strongPasswordCheckerII(String password) {
       if(password.length()<8) return false;
       String specialStr = "!@#$%^&*()-+";
       boolean lower = false, upper = false, digit = false, special = false;
       for(char c: password.toCharArray()) {
           if(c>='a' && c<='z') lower = true;
           if(c>='A' && c<='Z') upper = true;
           if(c>='0' && c<='9') digit = true;
           for(char s: specialStr.toCharArray()) {
               if(c==s)
                   special = true;
           }
       }
        if(!lower || !upper || !digit || !special)
            return false;
        for(int i=1;i<password.length();i++) {
            if(password.charAt(i-1)==password.charAt(i))
                return false;
        }
        return true;
    }
}