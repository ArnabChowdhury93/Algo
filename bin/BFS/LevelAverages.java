/**
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 637. Average of Levels in Binary Tree
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
class LevelAverages {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAverages = new ArrayList<>();
        if(root==null){
            return levelAverages;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double levelSum=0;
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                levelSum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            levelAverages.add(levelSum/levelSize);
        }
        return levelAverages;
    }
}