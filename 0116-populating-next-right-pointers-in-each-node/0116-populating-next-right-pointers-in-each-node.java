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

        if (root == null) return null;
        traversal(root);
        return root;
    }

    private void traversal(Node node){

        if (node.left == null) return;

        node.left.next = node.right;

        if (node.next != null){

            if (node.next.left != null){
                node.right.next = node.next.left;
            }
            else{
                node.right.next = node.next.right;
            }
        }
        traversal(node.left);
        traversal(node.right);
    }
}