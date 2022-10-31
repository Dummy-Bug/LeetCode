class Solution:
    def permuteUnique(self, A: List[int]) -> List[List[int]]:

        allPerms = []
        generatePerms(A, [], set(), allPerms)
        return allPerms

def generatePerms(arr,currentPerm,usedInds,allPerms):
    if len(currentPerm) == len(arr): 
        allPerms.append([num for num in currentPerm])
    usedVals = set()
    # try all possible elements for the current position
    for i in range(len(arr)):
        if not i in usedInds and not arr[i] in usedVals:  # second check to avoid duplicates
            usedVals.add(arr[i])
            usedInds.add(i)
            currentPerm.append(arr[i])
            generatePerms(arr, currentPerm, usedInds, allPerms)
            usedInds.remove(i)
            currentPerm.pop()