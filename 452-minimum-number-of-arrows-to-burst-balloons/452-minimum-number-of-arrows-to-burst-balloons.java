class Solution {
  public int findMinArrowShots(int[][] points) {
    
    Arrays.sort(points, (p1, p2) -> {
      if (p1[1] == p2[1])
        return 0;
      if (p1[1] < p2[1])
        return -1;
      return 1;
    });
    
    int arrows = 1;
    int xStart, xEnd;
    int firstEnd = points[0][1];
    
    for (int[] point : points) {
      xStart = point[0];
      xEnd = point[1];
      if (firstEnd < xStart) {
        arrows++;
        firstEnd = xEnd;
      }
    }
    
    return arrows;
  }
}


/*


            
*/