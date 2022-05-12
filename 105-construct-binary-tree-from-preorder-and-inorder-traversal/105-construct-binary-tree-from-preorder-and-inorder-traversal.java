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
        int[] preIndex = {0};
        return constructTree(preorder, inorder, preIndex, 0, inorder.length-1);
    }
    private TreeNode constructTree(int[] preorder, int[] inorder, int[] preIndex, int inStart, int inEnd) {
        if(preIndex[0] >= preorder.length || inStart>inEnd)
            return null;
        int curValue = preorder[preIndex[0]];
        TreeNode curNode = new TreeNode(curValue);
        preIndex[0] += 1;
        //finding index of curValue in Inorder Array and then set boundary for left and right subtree using i during recursion
        int i=-1;
        for(i=inStart;i<=inEnd;i++) {
            if(curValue==inorder[i])
                break;
        }
        curNode.left = constructTree(preorder, inorder, preIndex, inStart, i-1);
        curNode.right = constructTree(preorder, inorder, preIndex, i+1, inEnd);
        
        return curNode;
    }
}