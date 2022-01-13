class SnapshotArray {
  Map<Integer, Map<Integer, Integer>> map;
  int n;
  int currSnap;
  
  public SnapshotArray(int length) {
    map = new HashMap<>();
    n = length;
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(0, x -> new HashMap<>()).put(i, 0);
    }
    currSnap = 0;
  }
    
  public void set(int index, int val) {
    map.get(currSnap).put(index, val);        
  }
    
  public int snap() {
    currSnap++;
    map.put(currSnap, new HashMap<>());
    return currSnap - 1;
  }
    
  public int get(int index, int snap_id) {
    int curr = snap_id;
    while (!map.get(curr).containsKey(index)) {
      curr--;
    }
    return map.get(curr).get(index);
  }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */