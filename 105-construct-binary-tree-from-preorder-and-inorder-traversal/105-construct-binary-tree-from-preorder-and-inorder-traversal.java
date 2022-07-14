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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length-1, 0);
    }
    private TreeNode dfs(int[] preOrder, int[] inOrder, int inStart, int inEnd, int preIdx) {
        if(inStart>inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preIdx]);
        int inIdx = inStart;
        while(preOrder[preIdx]!=inOrder[inIdx]) inIdx++;
        
        root.left = dfs(preOrder, inOrder, inStart, inIdx-1, preIdx+1);
        root.right = dfs(preOrder, inOrder, inIdx+1, inEnd, preIdx+1+inIdx-inStart);
        
        return root;
    }
}