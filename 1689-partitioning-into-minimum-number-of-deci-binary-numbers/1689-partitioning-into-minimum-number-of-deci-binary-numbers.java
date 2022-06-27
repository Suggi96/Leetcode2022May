class Solution {
    public int minPartitions(String n) {
        int res = -1;
        for(char c: n.toCharArray()) {
            res = Math.max(res, c - '0');
            if(res==9) return 9;
        }
        return res;
    }
}