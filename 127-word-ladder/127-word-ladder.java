class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    wordSet.remove(beginWord);
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int level = 1;
    
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String word = q.poll();
        if (word.equals(endWord)) {
          return level;
        }
        
        for (String nei : neighbor(word, wordSet)) {
          q.offer(nei);
        }
      }
      level++;
    }
    
    return 0;  
  }
  
  private List<String> neighbor(String word, Set<String> wordSet) {
    List<String> res = new ArrayList<>();
    char[] curr = word.toCharArray();
    for (int i = 0; i < word.length(); i++) {
      char temp = curr[i];
      for (char ch = 'a'; ch <= 'z'; ch++) {
        curr[i] = ch;
        String nei = new String(curr);
        if (wordSet.remove(nei)) {
          res.add(nei);
        }        
      }
      curr[i] = temp;
    }
    
    return res;
  }
}