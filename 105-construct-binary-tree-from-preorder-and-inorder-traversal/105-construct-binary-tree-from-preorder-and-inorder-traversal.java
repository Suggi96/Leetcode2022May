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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
        if(start>end)
            return null;
        
        TreeNode root = new TreeNode(preorder[preIdx++]);
        
        if(root==null)
            return null;
        if(start==end)
            return root;
        int idx = map.get(root.val);
        root.left = dfs(preorder, inorder, start, idx-1);
        root.right = dfs(preorder, inorder, idx+1, end);
        
        return root;
    }
}