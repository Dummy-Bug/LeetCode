class Solution {
    public int maxBalancedShipments(int[] weight) {

        int maxSoFar = 0;
        int balancedShipments = 0;
        int i = 0;

        while(i < weight.length){

            if (weight[i] < maxSoFar){
                balancedShipments += 1;
                maxSoFar = 0;
            }
            else{
                maxSoFar = weight[i];
            }
            i++;
        }
        return balancedShipments;
    }
}