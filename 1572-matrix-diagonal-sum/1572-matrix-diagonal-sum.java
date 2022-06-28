class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        int r = 0, c = 0;
        while(r<n && c<n) {
            sum += mat[r][c];
            r++;
            c++;
        }
        r = 0;
        c = n-1;
        while(r<n && c>=0) {
            sum += mat[r][c];
            r++;
            c--;
        }
        if(n%2==1) sum -= mat[n/2][n/2];
        return sum;
    }
}