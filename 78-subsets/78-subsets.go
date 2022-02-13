func subsets(nums []int) [][]int {
  result := make([][]int, 0)
  backtrack(nums, &result, make([]int, 0), 0)
  return result
}

func backtrack(nums []int, result *[][]int, curr []int, index int) {
  tmp := make([]int, len(curr))
  copy(tmp, curr)
  *result = append(*result, tmp)
  
  for i := index; i < len(nums); i++ {
    curr = append(curr, nums[i])
    backtrack(nums, result, curr, i + 1)
    curr = curr[: len(curr) - 1]
  }
 }