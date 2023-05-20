from collections import defaultdict;

class Solution:
    
    def __init__(self):

        self.reverseGraph = defaultdict(list);

    def dfs_utility(self,graph,u):
        
        self.visited[u] = True;
        
        for padosi in graph[u]:
        
            if self.visited[padosi] == False:
                self.dfs_utility(graph,padosi);
        
        self.stack.append(u)
            
    def transpose(self,adj,V):
        
        for i in range(V):
            for j in adj[i]:
                self.reverseGraph[j].append(i) # reversing the edge.
                
    def kosaraju(self, V, adj):
        
        self.visited =  [False for i in range(V)]
        self.stack   =  [];
        
        for i in range(V):
            
            if self.visited[i] == False:
                self.dfs_utility(adj,i)
        
        self.transpose(adj,V);
        
        
        self.visited = [False for i in range(V)]
        result = 0
        
        while self.stack :
            
            u = self.stack.pop()
            
            if self.visited[u] == False:
                self.dfs_utility(self.reverseGraph,u) 
                # calling with Transposed reverseGraph
                
                result = result + 1
            
        return result
        

#{ 
 # Driver Code Starts
#Initial Template for Python 3

from collections import OrderedDict 
import sys 

sys.setrecursionlimit(10**6) 
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        V,E = list(map(int, input().strip().split()))
        adj = [[] for i in range(V)]
        for i in range(E):
            a,b = map(int,input().strip().split())
            adj[a].append(b)
        ob = Solution()
        
        print(ob.kosaraju(V, adj))
# } Driver Code Ends