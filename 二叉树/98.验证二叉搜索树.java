/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start

import java.util.ArrayList;


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
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        traversal(root);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) >= arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        this.arrayList.add(node.val);
        traversal(node.right);
    }
}
// @lc code=end

