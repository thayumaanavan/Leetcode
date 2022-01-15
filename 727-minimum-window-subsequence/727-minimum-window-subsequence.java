class Solution {
  public String minWindow(String s1, String s2) {
    int n1 = s1.length(), n2 = s2.length();
    int minLen = Integer.MAX_VALUE;
    int startIndex = -1;
    
    for (int i = 0; i < n1; i++) {
      if (s1.charAt(i) == s2.charAt(n2 - 1)) {
        int k = i, j = n2 - 1;
        while(k >= 0) {
          if (s1.charAt(k) == s2.charAt(j)) j--;
          if (j == -1) break;
          k--;
        }
        
        int currLen = i - k + 1;
        if (j == -1 && currLen < minLen) {
          minLen = currLen;
          startIndex = k;
        }
      }
    }
    
    return startIndex == -1 ? "" : s1.substring(startIndex, startIndex + minLen);
  }
}