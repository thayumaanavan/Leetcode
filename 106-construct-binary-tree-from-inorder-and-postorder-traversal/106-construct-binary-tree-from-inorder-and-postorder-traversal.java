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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    int n = inorder.length;
    return build(inorder, 0, n - 1, postorder, 0, n - 1);          
  }
  
  private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    
    TreeNode root = new TreeNode(postorder[postEnd]);
    int rootIndex = search(inorder, root.val);
   
    root.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - inStart - 1);
    root.right = build(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);
    
    return root;
  }
  
  public int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1;
  }
}