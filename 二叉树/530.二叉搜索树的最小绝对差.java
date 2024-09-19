/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start

import java.util.ArrayList;

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
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        for(int i = 0; i < arrayList.size() - 1; i++) {
            int value = Math.abs( arrayList.get(i) - arrayList.get(i + 1));
            if(this.result > value) {
                this.result = value;
            }
        }
        return this.result;
    }

    private void traversal(TreeNode node) {
        if(node == null) {
            return ;
        }
        traversal(node.left);
        this.arrayList.add(node.val);
        traversal(node.right);
    }

}
// @lc code=end
