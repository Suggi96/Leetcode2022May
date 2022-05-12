/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return buildTree(pre, post, 0, post.length - 1, new int[]{0});
}

TreeNode buildTree(int[] pre, int[] post, int left, int right, int[] index) {
    if(left > right) return null;
        
    index[0]++;
    TreeNode root = new TreeNode(post[right]);
    if(left == right) return root;
    
    int i = left;
    while(i <= right && post[i] != pre[index[0]])
        i++;
    
    root.left = buildTree(pre, post, left, i, index);
    root.right = buildTree(pre, post, i + 1, right - 1, index);
    return root;
}
}