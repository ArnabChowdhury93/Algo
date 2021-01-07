import java.awt.List;

/**
 * No of Path Sum equals to given Sum. Not necessay to start and end, at root
 * and leaf respectively
 * 
 * https://leetcode.com/problems/path-sum-iii/
 */

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        List<Integer> currentPath = new ArrayList<>();
        return countPaths(root, sum, currentPath);
    }

    public int countPaths(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return 0;
        }
        path.add(root.val);
        int count = 0;
        int currentSum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            currentSum += path.get(i);
            if (sum == currentSum) {
                count++;
            }
        }
        count += countPaths(root.left, sum, path);
        count += countPaths(root.right, sum, path);
        path.remove(path.size() - 1);
        return count;
    }
}
