/**
 *
 *
 *
 *
 *
 *
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
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
class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listOfLevel  = new ArrayList<>();
        if(root==null){
            return listOfLevel;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean isForward = true;
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            List<Integer> level = new ArrayList<>(currentSize);
            for(int i=0; i<currentSize; i++){
                TreeNode node = queue.poll();
                if(isForward){
                    level.add(node.val);
                }
                else{
                    level.add(0, node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            listOfLevel.add(level);
            isForward = !isForward;
        }
        return listOfLevel;
    }
}