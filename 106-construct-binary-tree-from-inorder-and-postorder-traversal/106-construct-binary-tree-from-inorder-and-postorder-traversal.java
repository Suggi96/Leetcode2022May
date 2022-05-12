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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = {postorder.length-1};
        return constructTree(postorder, inorder, postIndex, 0, inorder.length-1);
    }
    private TreeNode constructTree(int[] postorder, int[] inorder, int[] postIndex, int inStart, int inEnd) {
        if(postIndex[0] < 0 || inStart>inEnd)
            return null;
        int curValue = postorder[postIndex[0]];
        TreeNode curNode = new TreeNode(curValue);
        postIndex[0] -= 1;
        //finding index of curValue in Inorder Array and then set boundary for left and right subtree using i during recursion
        int i=-1;
        for(i=inStart;i<=inEnd;i++) {
            if(curValue==inorder[i])
                break;
        }
        curNode.right = constructTree(postorder, inorder, postIndex, i+1, inEnd);
        curNode.left = constructTree(postorder, inorder, postIndex, inStart, i-1);
        
        
        return curNode;
    }
}