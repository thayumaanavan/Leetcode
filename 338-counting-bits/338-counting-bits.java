class Solution {
  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    
    for (int i = 0; i <= n; i++) {
      result[i] = countOnes(i);
    }
    
    return result;
  }
  
  private int countOnes(int num) {
    int ones = 0;
    
    while (num > 0) {
      ones += (num % 2 == 0) ? 0 : 1;
      num = num / 2;
    }
    
    return ones;
  }
}