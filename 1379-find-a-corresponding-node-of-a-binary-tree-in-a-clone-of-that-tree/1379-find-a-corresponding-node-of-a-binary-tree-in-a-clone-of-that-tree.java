/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return PreOrder(cloned, target);
    }
    private final TreeNode PreOrder(final TreeNode root, final TreeNode target) {
        if(root==null)
            return null;
        if(root.val==target.val)
            return root;
        
        TreeNode left = PreOrder(root.left, target);
        TreeNode right = PreOrder(root.right, target);
        
        if(left!=null)
            return left;
        return right;
        
    }
}