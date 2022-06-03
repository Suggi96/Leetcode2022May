class NumMatrix {
    int[][] grid = null;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        grid = new int[m][n];
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++)
                grid[i][j] = matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int a = row1, b = col1, c = row2, d = col2;
        for(int i=a;i<=c;i++) {
            for(int j=b;j<=d;j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */