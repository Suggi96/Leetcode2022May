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
    TreeNode t,res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        t = target;
        preOrder(original, cloned);
        return res;
    }
    private void preOrder(TreeNode original, TreeNode cloned) {
        if(original!=null) {
            if(original==t)
                res = cloned;
            preOrder(original.left, cloned.left);
            preOrder(original.right, cloned.right);
        }
    }
}