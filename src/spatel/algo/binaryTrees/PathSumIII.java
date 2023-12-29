

public class PathSumIII {

 public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
 private int pathHelper(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) +  
            pathHelper(root.left, sum - root.val) + pathHelper(root.right, sum - root.val);
 }

  public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
