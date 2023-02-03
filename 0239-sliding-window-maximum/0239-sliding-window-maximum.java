class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int result [] = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedBlockingDeque<Integer>();;
        
        int i = 0; int j = 0;
        
        while (j<nums.length)
        {
            if (j-i+1<k)
            {
                while ( (dq.size() != 0) && (nums[dq.getLast()] <= nums[j]) )
                {
                    dq.removeLast();
                }
                dq.add(j);
                j += 1;
            }
            else
            {
                while ( (dq.size() != 0) && (nums[dq.getLast()] <= nums[j]) )
                {
                    dq.removeLast();
                }
                dq.add(j);
                result[i] = nums[dq.getFirst()];
                if ( ( dq.size() != 0 )&& i == dq.getFirst()) 
                {
                    dq.removeFirst();
                }
                i += 1; j += 1;
            }
        }
    return result;
    }
}