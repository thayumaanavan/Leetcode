class Solution {
  public int[] anagramMappings(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums1.length;
    
    for (int i = 0; i < n; i++) {
      map.put(nums2[i], i);
    }
    
    for (int i = 0; i < n; i++) {
      nums1[i] = map.get(nums1[i]);
    }
    
    return nums1;
  }
}