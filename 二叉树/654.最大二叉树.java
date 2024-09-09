/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = buildTree(nums, leftIndex, maxIndex);
        root.right = buildTree(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
// @lc code=end

