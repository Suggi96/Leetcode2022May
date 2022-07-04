class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, down = m-1, left = 0, right = n-1;
        int dir = 0;
        while(top<=down && left<=right) {
            if(dir==0) {
                for(int i=left;i<=right;i++)
                    res.add(matrix[top][i]);
                top++;
            }
            
            else if(dir==1) {
                for(int i=top;i<=down;i++) 
                    res.add(matrix[i][right]);
                 right--;
            }
           
            else if(dir==2) {
                for(int i=right;i>=left;i--)
                    res.add(matrix[down][i]);
                down--;
            }
            
            else {
                for(int i=down;i>=top;i--)
                    res.add(matrix[i][left]);
                left++;
            }
            
            dir = (dir + 1)%4;
        }
        return res;
    }
}