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
    public int deepestLeavesSum(TreeNode root) {
        int h = findHeight(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curNode = q.remove();
                if(curNode.left==null && curNode.right==null && level==h)
                    sum += curNode.val;
                if(curNode.left!=null)
                    q.add(curNode.left);
                if(curNode.right!=null)
                    q.add(curNode.right);
            }
        }
        return sum;
        
    }
    private int findHeight(TreeNode root) {
        if(root==null)
            return 0;
        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);
        return 1 + Math.max(leftH, rightH);
    }
}