class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int n = nums.length;

        int [] even = new int[n];
        int [] odd = new int[n];

        for (int i = 0; i < n; i++){
            odd[i] = nums[i];
            even[i] = nums[i];
        }

        int ans1 = 0;

        for (int i = 1; i < n; i += 2){
            
            if (even[i - 1] <= even[i]){
                int d = even[i] - even[i - 1] + 1;
                ans1 += d;
                even[i] = even[i] - d;
                
            }
            if (i != n - 1 && even[i + 1] <= even[i]){
                int d = even[i] - even[i + 1] + 1;
                ans1 += d;
                even[i] = even[i] - d;
            }
        }

        int ans2 = 0;

        for (int i = 0; i < n; i+=2){
            
            if (i != 0 && odd[i - 1] <= odd[i]){
                int d = odd[i] - odd[i - 1] + 1;
                ans2 += d;
                odd[i] = odd[i] - d;
            }
            if (i != n- 1 && odd[i + 1] <= odd[i]){
                int d = odd[i] - odd[i + 1] + 1;
                ans2 += d;
                odd[i] = odd[i] - d;
            }
        }
        return Math.min(ans1 , ans2);
    }
    
}