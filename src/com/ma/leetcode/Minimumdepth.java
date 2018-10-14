package com.ma.leetcode;


/**
 * 题目：
 * 给定二叉树，找到它的最小深度。
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 最小深度是沿从根节点到最近的叶节点的最短路径上的节点数。
 * Note: A leaf is a node with no children.
 * 注意：叶子是没有子节点的节点。
 * Example:
 * 二叉树： [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its minimum depth = 2.
 */

public class Minimumdepth {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public void TreeNode(int val){
            this.val = val;
        }
    }
    public class Solution {
        public int run(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left = run(root.left);
            int right = run(root.right);
            return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
        }
    }
    public static void main(String[] args) {

    }
}
