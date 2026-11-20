class Solution {

    private long getEnergyBooster(PriorityQueue<int[]> maxPq ,Set<Integer> marked){

        while(!maxPq.isEmpty()){

            int [] entry = maxPq.poll();
            marked.add(entry[1]);

            return (long)entry[0];
        }
        return -1l;
    }

    public long maximumPoints(int[] enemyEnergies, int initialEnergy) {
        
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = enemyEnergies.length;
        long currentEnergy = (long)initialEnergy;

        for(int i = 0; i < n; i++){
            
            int [] entry = new int[]{enemyEnergies[i] , i};
            
            minPq.offer(entry);
            maxPq.offer(entry);
        }

        long points = 0l;
        Set<Integer> marked = new HashSet<>();

        while(!minPq.isEmpty()){
                
            int [] entry = minPq.peek();
            
            if (marked.contains(entry[1])) minPq.poll();

            else if (entry[0] > currentEnergy){
                
                if (points == 0) return 0;
                long boost = getEnergyBooster(maxPq , marked);
                
                if ( boost == -1) return points;

                currentEnergy += boost;
            }
            else {
                long factor = currentEnergy / entry[0];
                currentEnergy = currentEnergy % entry[0];
                points += factor;
            }
        }
        return points;
    }
}