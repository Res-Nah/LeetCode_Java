/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd) {
            return null;
        }
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootVal) {
                break;
            }
        }
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

        return root;
    }
}
// @lc code=end
