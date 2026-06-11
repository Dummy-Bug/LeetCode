class Solution {
    public int punishmentNumber(int n) {
        

        int count = 0;
        for (int i = n ; i >= 1; i--){
            int num = i * i;
            if (canPartition(0,Integer.toString(num),i)){
                count += i * i;
            }
        }
        return count;
    }

    private boolean canPartition(int index , String s , int sum){

        int n = s.length();

        if (index >= n){
            return sum == 0;
        }

        for (int i = index ; i < n; i++){
            
            int num = Integer.parseInt(s.substring(index, i + 1));
            
            if (sum - num >= 0){
                if (canPartition(i + 1,s,sum - num)) return true;
            }
            else break;
        }
        return false;
    }
}