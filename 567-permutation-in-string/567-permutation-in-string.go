func checkInclusion(s1 string, s2 string) bool {
  len1 := len(s1)
  len2 := len(s2)
  if len1 > len2 {
    return false
  }
  
  counter := make([]int, 26)
  
  for i := range s1 {
    counter[s1[i] - 'a']++
    counter[s2[i] - 'a']--
  }
  
  if allZeroes(counter) {
    return true
  }
  
  for i := len1; i < len2; i++ {
    counter[s2[i] - 'a']--
    counter[s2[i - len1] - 'a']++
    if allZeroes(counter) {
      return true
    }
  }
  
  return false
}

func allZeroes(counter []int) bool {
  for _, v := range counter {
    if v != 0 {
      return false
    }
  }
  return true
}