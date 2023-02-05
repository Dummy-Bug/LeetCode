//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

// Position this line where user code will be pasted.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //            String line = br.readLine();
            //            String[] a2 = line.trim().split("\\s+");
            //            int n =Integer.parseInt(a2[0]);
            //            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.sumoflength(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    
    long sumoflength(long arr[], int n) 
    {
        long result = 0; 
        HashSet<Long>set = new HashSet<Long>();
        
        int i = 0; int j = 0;
        
        while (i<arr.length)
        {
            while( (j<arr.length)&&(!set.contains(arr[j]) ) )
            {
                set.add(arr[j]);
                j += 1;
            }
            result = result + ( (j-i)*(j-i+1) )/2;
            set.remove(arr[i]);
            i += 1;
            
        }
        return result;
    }
}
