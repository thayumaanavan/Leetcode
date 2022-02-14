/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
  if root == nil {
    return 0
  }
  
  q := []*TreeNode{}
  q = append(q, root)
  level := 0
  size := len(q)
  
  for size > 0 {
    level += 1
    for i := 0; i < size; i++ {
      node := q[i]
      
      if node.Left != nil {
        q = append(q, node.Left)
      }  
      if node.Right != nil {
        q = append(q, node.Right)
      }
    }
    q = q[size:]
    size = len(q)
  }
  
  return level
}