/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 116. Populating Next Right Pointers in Each Node
 *
 *
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, Node _left, Node _right, Node _next) {
 *         val = _val;
 *         left = _left;
 *         right = _right;
 *         next = _next;
 *     }
 * };
*/

class LevelOrderSiblings {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node prev = null;
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                Node node = queue.poll();
                if(prev!=null){
                    prev.next = node;
                }
                prev=node;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            // prev.next=null;
        }
        return root;
    }
}