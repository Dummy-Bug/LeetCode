//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static int findParent(int vertex,int [] parentArr){
        if (parentArr[vertex] != vertex){
            parentArr[vertex] = findParent(parentArr[vertex],parentArr);
        }
        return parentArr[vertex];
    }
    
    public static void findUnion(int parentX, int parentY,int []rank,int [] parent){
        
        if (rank[parentX]<rank[parentY]){
            parent[parentX] = parentY;
        }
        else if(rank[parentX]>rank[parentY]){
            parent[parentY] = parentX;
        }
        else{
            parent[parentX] = parentY;
            rank[parentY]  += 1;
        }
        
    }
	static int spanningTree(int V, int E, int edges[][]){
	    
	    int [] parentArr = new int[V];
	    int [] rank      = new int[V];
	    
	    for(int i = 0; i< parentArr.length;i++){
	        parentArr[i] = i;
	        rank[i] = 1;
	    }
	    
	    Arrays.sort(edges,new Comparator<int[]>(){
	        public int compare(int [] a, int [] b){
	            return a[2]-b[2];
	        }
	    });
	    int currSum   = 0; int currIndex = 0;
	    int currEdges = 0;
	    
	    while (currEdges < V-1){
	        
	        int x = edges[currIndex][0];
	        int y = edges[currIndex][1];
	        
	        int parentX = findParent(x,parentArr);
	        int parentY = findParent(y,parentArr);
	        
	        if (parentX != parentY){
	            currEdges += 1;
	            currSum += edges[currIndex][2];
	            findUnion(parentX,parentY,rank,parentArr);
	        }
	        currIndex += 1;
	    }
	    return currSum;
	}
	
}