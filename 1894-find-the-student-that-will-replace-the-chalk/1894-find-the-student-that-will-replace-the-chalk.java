class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        long sum = 0;
        for(int i=0;i<chalk.length;i++){
            sum += (long)chalk[i];
        }
        k = (int)( (long)k%sum );
//         temporarily making k as long evaluating the exprn then making it back int
        
        for(int i = 0;i<chalk.length;i++){
            k=k-chalk[i];
            if (k<0)return i;
        }
        return -1;
    }
}