class Solution {
  String word1;
  String word2;
  int n1;
  int n2;
  int[][] memo;
  
  public int minDistance(String word1, String word2) {
    this.word1 = word1;
    this.word2 = word2;
    n1 = word1.length();
    n2 = word2.length();
    
    if (n1 == 0) {
      return n2;
    }
    
    if (n2 == 0) {
      return n1;
    }
    
    memo = new int[n1][n2];
    
    return dp(0, 0);
  }
  
  private int dp(int i, int j) {
    if (i == n1)
      return n2 - j;
    if (j == n2)
      return n1 - i;
    
    if (memo[i][j] > 0) {
      return memo[i][j];
    }
    int res;
    if (word1.charAt(i) == word2.charAt(j)) {
      res = dp(i + 1, j + 1);
    } else {
      res = Math.min(dp(i, j + 1), //insert
            Math.min(dp(i + 1, j), //remove
                     dp(i + 1, j + 1) //replace
                    )) + 1;
    }
    
    memo[i][j] = res;
    
    return res;
  }
}

