class Solution:
    def funcn(self, capacity, wt_array, val_array, n):
        """
        Helper function for computing the maximum value that can be achieved in the knapsack.

        Args:
            capacity (int): Remaining capacity of the knapsack.
            wt_array (List[int]): Array of item weights.
            val_array (List[int]): Array of item values.
            n (int): Size of the arrays.

        Returns:
            int: Maximum value achievable with the given capacity and items.

        """

        if n <= 0:
            return 0

        if self.dp[n][capacity] != -1:
            return self.dp[n][capacity]

        if wt_array[n - 1] <= capacity:
            value_considered = val_array[n - 1] + self.funcn(capacity - wt_array[n - 1], wt_array, val_array, n - 1)
            not_considered = 0 + self.funcn(capacity, wt_array, val_array, n - 1)
            self.dp[n][capacity] = max(value_considered, not_considered)
            return self.dp[n][capacity]

        else:
            return self.funcn(capacity, wt_array, val_array, n - 1)

    def knapSack(self, W, wt, val, n):
        """
        Calculates the maximum value that can be achieved in the knapsack.

        Args:
            W (int): Maximum capacity of the knapsack.
            wt (List[int]): Array of item weights.
            val (List[int]): Array of item values.
            n (int): Number of items.

        Returns:
            int: Maximum value achievable in the knapsack.

        """

        self.dp = [[-1 for i in range(0, W + 1)] for j in range(0, n + 1)]
        return self.funcn(W, wt, val, n)
 

#{ 
#  Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        n = int(input())
        W = int(input())
        val = list(map(int,input().strip().split()))
        wt = list(map(int,input().strip().split()))
        ob=Solution()
        print(ob.knapSack(W,wt,val,n))
# } Driver Code Ends