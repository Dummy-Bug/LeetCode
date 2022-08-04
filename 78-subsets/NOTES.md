Check First Comment of https://leetcode.com/problems/subsets/discuss/362545/Python3-Backtracking Solution.
​
​
* You can only append list of list to the List that contains list of list.
​
* In python, list is passed by object reference by default. here you want to always create a new copy of subset and work on that. So list(subset) is used for that
​
In BFS method first we add all the nodes present at level L and then we keep on increasing the level to level = len(nums);
​
```
class Solution:
### BFS ###
def subsets(self, nums: List[int]) -> List[List[int]]:
output = []
for level in range(0,len(nums)+1): # we also want Null set so starting from Zero
self.backtrack(nums,0,level,[],output)
return output
def backtrack(self,nums,first_index,level,subset,result):
if len(subset) == level:
print(result)
result.append(list(subset))
return
for i in range(first_index,len(nums)):
subset.append(nums[i])
self.backtrack(nums,i+1,level,subset,result)
subset.pop() # now again the subset's size is reduced.
```