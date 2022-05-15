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
   //     int h = findHeight(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curNode = q.remove();
                    sum += curNode.val;
                if(curNode.left!=null)
                    q.add(curNode.left);
                if(curNode.right!=null)
                    q.add(curNode.right);
            }
        }
        return sum;
        
    }
}