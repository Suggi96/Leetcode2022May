class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int source = image[sr][sc];
        if(source==newColor)
            return image;
        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, rows, cols, newColor, source);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int rows, int cols, int newColor, int source) {
        if(sr<0 || sr>=rows || sc<0 || sc>=cols) 
            return;

        else if(image[sr][sc]!=source)
            return;
        
        image[sr][sc] = newColor;
        
        dfs(image, sr, sc+1, rows, cols, newColor, source);
        dfs(image, sr, sc-1, rows, cols, newColor, source);
        dfs(image,sr+1, sc, rows, cols, newColor, source);
        dfs(image,sr-1, sc, rows, cols, newColor, source);
        
    }
}