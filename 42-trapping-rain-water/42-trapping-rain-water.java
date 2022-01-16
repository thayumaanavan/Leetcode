class Solution {
  public int trap(int[] height) {
    int trap = 0;
    int left = 0, right = height.length - 1;
    int waterlevel = 0, lowergrounds = 0;
    
    while (left < right) {
      lowergrounds = height[left] < height[right] ? height[left++] : height[right--];
      waterlevel = Math.max(waterlevel, lowergrounds);
      trap += waterlevel - lowergrounds;
    }
    
    return trap;
  }
}