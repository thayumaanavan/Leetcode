func combinationSum(candidates []int, target int) [][]int {
  var result [][]int
  backtrack(candidates, target, &result, []int{}, 0);
  return result
}

func backtrack(candidates []int, target int, result *[][]int, curr []int, index int) {
  if target < 0 {
    return
  }
  
  if target == 0 {
    tmp := make([]int, len(curr))
    _ = copy(tmp, curr)
    *result = append(*result, tmp)
    return
  }
  
  for i := index; i < len(candidates); i++ {
    if candidates[i] > target {
      continue
    }
    curr = append(curr, candidates[i])
    backtrack(candidates, target - candidates[i], result, curr, i)
    curr = curr[: len(curr) - 1]
  }
}