import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
    TreeNode(int x) {
      val = x;
    }
  };


public class AllPathSum {
    
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> paths  = new ArrayList<>();
    addPaths(root, sum, allPaths, paths);
    return allPaths;
  }

private static void addPaths(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> paths) {
   if(root==null){
       return ;
    }
    paths.add(root.val);
    if(root.left==null && root.right==null && root.val==sum){
        allPaths.add(paths);
    }
    addPaths(root.left, sum-root.val, allPaths, paths);
    addPaths(root.right, sum-root.val, allPaths, paths);
    paths.remove(paths.size()-1);
}

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }   
}


