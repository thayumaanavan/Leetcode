class Solution {
  public String rearrangeString(String s, int k) {
    int n = s.length();
    int[] freq = new int[26];
    
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      freq[ch - 'a']++;
    }
    
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0)
        pq.offer(new int[] {i, freq[i]});
    }
    
    Queue<int[]> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();    
      sb.append((char)(curr[0] + 'a'));
      curr[1]--;
      queue.offer(curr);
      
      if (queue.size() >= k) {
        int[] front = queue.poll();
        if (front[1] > 0) {
          pq.offer(front);
        }
      }      
    }
    
    return sb.length() == n ? sb.toString() : "";
  }
}