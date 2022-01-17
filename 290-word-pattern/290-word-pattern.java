class Solution {
  public boolean wordPattern(String pattern, String s) {    
    int n = pattern.length();
    String[] words = s.split(" ");
    
    if (words.length != n) {
      return false;
    }
    
    Map map = new HashMap<>();
    for (Integer i = 0; i < n; i++) {
      if (map.put(words[i], i) != map.put(pattern.charAt(i), i)) {
        return false;
      }
    }
    
    return true;
  }
}

