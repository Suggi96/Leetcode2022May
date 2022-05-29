class Solution {
    public int maxProduct(String[] words) {
        int maxi = 0;
        for(int i=0;i<words.length;i++) {
            for(int j=i+1;j<words.length;j++) {
                if(isUnequal(words[i], words[j])) {
                    int len = words[i].length() * words[j].length();
                    maxi = Math.max(maxi, len);
                }
            }
        }
        return maxi;
    }
    private boolean isUnequal(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for(int i=0;i<arr1.length;i++) {
            for(int j=0;j<arr2.length;j++) {
                if(arr1[i]==arr2[j])
                    return false;
            }
        }
        return true;
    }
}