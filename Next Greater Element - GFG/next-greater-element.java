//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] result = new long[n];
        Arrays.fill(result, -1l); // Initialize all elements in result array to -1
        Stack<Integer> monoStack = new Stack<>(); // Store indices of elements in the monoStack
        
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than elements at indices stored in the monoStack
            while (!monoStack.isEmpty() && arr[i] > arr[monoStack.peek()]) {
                int index = monoStack.pop();
                result[index] = arr[i];
            }
            monoStack.push(i); // Push the current element index to the monoStack
        }
        
        return result;

    } 
}