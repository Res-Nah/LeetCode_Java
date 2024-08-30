/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode cur = root;
//         while (cur != null || !stack.isEmpty()) {
//             if (cur != null) {
//                 stack.push(cur);
//                 cur = cur.left;
//             } else {
//                 cur = stack.pop();
//                 result.add(cur.val);
//                 cur = cur.right;
//             }
//         }
//         return result;
//     }
// }
// @lc code=end

