class FirstUnique {
  Set<Integer> queue = new LinkedHashSet<>();
  Map<Integer, Boolean> isUnique = new HashMap<>();
  
  public FirstUnique(int[] nums) {
    for (int num : nums) {
      this.add(num);
    }      
  }
    
  public int showFirstUnique() {
    if (!queue.isEmpty()) {
      return queue.iterator().next();
    }      
    
    return -1;
  }
    
  public void add(int value) {
    if (!isUnique.containsKey(value)) {
      isUnique.put(value, true);
      queue.add(value);
    } else if (isUnique.get(value)) {
      isUnique.put(value, false);
      queue.remove(value);
    }
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */