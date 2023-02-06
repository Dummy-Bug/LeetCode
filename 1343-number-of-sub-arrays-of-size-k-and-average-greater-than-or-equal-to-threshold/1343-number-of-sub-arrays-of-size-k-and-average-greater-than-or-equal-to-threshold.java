class Solution 
{
    public int numOfSubarrays(int[] arr, int k, int threshold) 
    {
        long curr_sum    = 0;
        int i = 0; int j = 0;
        int result = 0;
        
        while (j<arr.length)
        {
            curr_sum += arr[j];
            if ( (j-i+1)<k )
            {
                j += 1; continue;
            }
            if (curr_sum/k >= threshold)
            {
                result += 1;
            }
            curr_sum -= arr[i];
            i += 1;j += 1;
        }
        
        return result;
    }
}