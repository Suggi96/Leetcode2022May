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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if(root==null)
            return temp;
        TreeNode curRoot = root;
        TreeNode parent = null;
        while(curRoot!=null) {
             parent = curRoot;
            if(val>curRoot.val) {
                curRoot = curRoot.right;
            }
            else {
                curRoot = curRoot.left;
            }
        }
        if(val>parent.val)
            parent.right = temp;
        else
            parent.left = temp;
        return root;
    }
}