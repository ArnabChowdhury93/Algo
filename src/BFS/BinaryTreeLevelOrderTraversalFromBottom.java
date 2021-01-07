/**
 *
 *
 *
 *
 *
 *
 *107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
class BinaryTreeLevelOrderTraversalFromBottom {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listOfLevel  = new ArrayList<>();
        if(root==null){
            return listOfLevel;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            List<Integer> level = new ArrayList<>(currentSize);
            for(int i=0; i<currentSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //To print reverse
            listOfLevel.add(0, level);
        }
        return listOfLevel;
    }
}