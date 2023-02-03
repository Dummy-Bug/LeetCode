//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Compute 
{

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {

        Deque<Integer> dq = new ArrayDeque<>();
        long result []    = new long [N-K+1];
        int i = 0; int j  = 0;
        
        while (j<A.length)
        {
            if ( j-i+1 < K )
            {
                if (A[j] < 0 )
                {
                    dq.add(j);
                }
                j += 1;
            }
            else
            {
                if ( A[j] < 0 )
                {
                    dq.add(j);
                }
                if (dq.size()==0)
                {
                    result[i] = 0;
                }    
                else
                {
                    result[i] = A[dq.peek()];
                }
                
                if (!dq.isEmpty() && i == dq.peek())
                    {
                        dq.remove();
                    }
                i += 1;
                j += 1;
            }
        }
        return result;
    }
}