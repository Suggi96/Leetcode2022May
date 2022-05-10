/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null)
            return root;
        q.add(root);
        while(!q.isEmpty()) {
            int curSize = q.size();
            Node prevNode = null;
            for(int i=0;i<curSize;i++) {
                Node curNode = q.remove();
                if(i!=0)
                    prevNode.next = curNode;
                prevNode = curNode;
                if(curNode.left!=null) 
                    q.add(curNode.left);
                if(curNode.right!=null)
                    q.add(curNode.right);
            }
        }
        return root;
    }
}