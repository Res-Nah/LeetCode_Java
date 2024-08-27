/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start

import java.util.*;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if (node.left != null) {
//                 stack.push(node.left);
//             }
//             if (node.right != null) {
//                 stack.push(node.right);
//             }
//         }
//         Collections.reverse(result);
//         return result;
//     }
// }
// @lc code=end

