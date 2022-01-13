class Solution {
  public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2))
      return true;
    
    Map<Character, Character> conversionMap = new HashMap<>();
    Set<Character> uniqueCharInStr2 = new HashSet<>();
    
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (!conversionMap.containsKey(c1)) {
        conversionMap.put(c1, c2);
        uniqueCharInStr2.add(c2);
      } else if (conversionMap.get(c1) != c2) {
        return false;
      }
    }
    
    return uniqueCharInStr2.size() < 26;
  }
}