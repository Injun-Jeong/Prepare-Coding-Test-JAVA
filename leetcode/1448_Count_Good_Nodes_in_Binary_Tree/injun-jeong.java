package leetcode;

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

public class Q1448_Count_Good_Nodes_in_Binary_Tree {
    private int answer;

    public int goodNodes(TreeNode root) {
        answer = 0;
        chkNode(root, root.val);
        return 0;
    };

    private void chkNode(TreeNode node, int currMaxVal) {
        if (node.val >= currMaxVal) {
            answer++;
            currMaxVal = node.val;
        }

        if (node.left != null) {
            chkNode(node.left, currMaxVal);
        }
        if (node.right != null) {
            chkNode(node.left, currMaxVal);
        }
    }
}
