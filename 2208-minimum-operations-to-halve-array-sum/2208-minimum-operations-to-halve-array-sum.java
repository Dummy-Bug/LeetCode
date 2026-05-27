class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b,a));
        
        double sum = 0.0;

        for (int num : nums){
            pq.offer(num + 0.0);
            sum += num;
        }
        
        int count = 0;
        double currentSum = 0.0;

        while(currentSum < sum/2.0){

            double value = pq.poll();
            double halvedValue = value/2.0;
            currentSum += halvedValue;
            pq.offer(halvedValue);
            count++;
        }
        return count;
    }
}