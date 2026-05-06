class Solution {                                                              
      public int maximumSum(int[] nums) {
                                                                                
          HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();           
                                                                                
          for (int i = 0; i < nums.length; i++) {                               
              int mod = nums[i] % 3;                        
              ArrayList<Integer> list = map.getOrDefault(mod, new
  ArrayList<>());                                                               
              list.add(nums[i]);
              map.put(mod, list);                                               
          }                                                 

          for (ArrayList<Integer> list : map.values()) {                        
              list.sort(Collections.reverseOrder());
              while (list.size() > 3) list.remove(list.size() - 1);             
          }                                                 

          int max1 = 0, max2 = 0, max3 = 0, maxSum = 0;                         
   
          for (int i = 0; i < 3; i++) {                                         
              ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<>());
                                                                                
              if (list.size() == 3) {
                  int sum = list.get(0) + list.get(1) + list.get(2);            
                  maxSum = Math.max(maxSum, sum);           
              }                                                                 
   
              if (!list.isEmpty()) {                                            
                  if (i == 0) max1 = list.get(0);           
                  if (i == 1) max2 = list.get(0);
                  if (i == 2) max3 = list.get(0);                               
              }
          }                                                                     
                                                            
          if (max1 != 0 && max2 != 0 && max3 != 0) {                            
              return Math.max(maxSum, max1 + max2 + max3);
          }                                                                     
          return maxSum;                                    
      }
  }