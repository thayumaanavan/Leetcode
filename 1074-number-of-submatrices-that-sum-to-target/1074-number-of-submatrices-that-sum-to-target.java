class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int result = 0;
    
    for (int r1 = 0; r1 < m; r1++) {
      int[] columnSums = new int[n];
      for (int r2 = r1; r2 < m; r2++) {
        for (int c = 0; c < n; c++) {
          columnSums[c] += matrix[r2][c];
        }        
        result += subarraySum(columnSums, target);
      }
    }
    
    return result;
  }
  
  public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>(); //sum, no. of occurence
    map.put(0, 1);
    
    int sum = 0, count = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    
    return count;
  }
}