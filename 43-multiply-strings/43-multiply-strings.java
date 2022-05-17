class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1"))
            return num2;
        if(num2.equals("0"))
            return num1;
        
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[i+j+1] + mul;
                res[i+j] += sum/10; //carry
                res[i+j+1] = sum%10; //remainder
            }
        }
        int k = 0;
        while(res[k]==0) k++; //skipping leading zeroes
        
        StringBuilder sb = new StringBuilder();
        for(int i=k;i<res.length;i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}