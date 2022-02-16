/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
  if head == nil || head.Next == nil {
    return head
  }
  
  var prev *ListNode
  prev = new(ListNode)
  prev.Next = head
  newHead := head.Next
 
  for prev.Next != nil && prev.Next.Next != nil {
    node1 := prev.Next
    node2 := node1.Next
    next := node2.Next
    
    prev.Next = node2
    node2.Next = node1
    node1.Next = next
    
    prev = node1
  }
  
  
  return newHead
}