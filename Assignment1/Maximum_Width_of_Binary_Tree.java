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
    class Pair {
        TreeNode n;
        int hd;

        Pair(TreeNode n, int hd) {
            this.hd = hd;
            this.n = n;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()) {
            Pair start = q.peek();
            int s = q.size();
            Pair end = null;
            for(int i = 0; i < s; i++) {
                end = q.poll();
                if(end.n.left != null) {
                    q.add(new Pair(end.n.left, 2 * end.hd + 1));
                }
                if(end.n.right != null) {
                    q.add(new Pair(end.n.right, 2 * end.hd + 2));
                }
            }
            ans = Math.max(ans, end.hd - start.hd + 1);

        }
        return ans;
    }
}
