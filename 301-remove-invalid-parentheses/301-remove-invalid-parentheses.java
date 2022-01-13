class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    int n = s.length();
    
    Queue<String> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    
    q.offer(s);
    visited.add(s);
    boolean found = false;
    
    while (!q.isEmpty()) {
      String curr = q.poll();
      
      if (validString(curr)) {
        result.add(curr);
        found = true;
      }
      
      if (found) {
        continue;
      }
      
      for (int i = 0; i < curr.length(); i++) {
        char ch = curr.charAt(i);
        if (ch != '(' && ch != ')') {
          continue;
        }
        String newStr = curr.substring(0, i) + curr.substring(i + 1);    
        if (!visited.contains(newStr)) {
          q.offer(newStr);
          visited.add(newStr);
        }
      }
    }
    
    return result;
  }
  
  private boolean validString(String s) {
    int n = s.length();
    Deque<Character> stack = new ArrayDeque<>();
    
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        continue;
      }
      if (ch == '(') {
        stack.push(')');
      } else if (ch == ')') {
        if (stack.isEmpty())
          return false;
        stack.pop();
      }
    }
    
    return stack.isEmpty();
  }
}