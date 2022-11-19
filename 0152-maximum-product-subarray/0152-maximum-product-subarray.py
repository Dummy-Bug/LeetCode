class Solution:
    # @param A : tuple of integers
    # @return an integer
    def maxProduct(self, A):
        n = len(A)
        # store the result that is the max we have found so far
        result = A[0]
        # Max/Min stores the max/min product of
        # subarray that ends with the current number A[i]
        Max = result
        Min = result
        for i in range(1, n):
            # multiplied by a negative makes big number smaller, small number bigger
            # so we redefine the extremums by swapping them
            if A[i] < 0:
                Max, Min = Min, Max

            # max/min product for the current number is either the current number itself
            # or the max/min by the previous number times the current one
            Max = max(A[i], Max * A[i])
            Min = min(A[i], Min * A[i])

            # the newly computed max value is a candidate for our global result
            result = max(result, Max)
        return result;

