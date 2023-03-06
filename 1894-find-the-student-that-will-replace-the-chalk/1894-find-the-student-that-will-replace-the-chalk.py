class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        
        summ = sum(chalk);
        k = k%summ

        for i in range(len(chalk)):
            k = k - chalk[i]
            if k < 0:
                return i