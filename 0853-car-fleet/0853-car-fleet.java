class Solution {

    private float getArrivalTime(int position , int target , Map<Integer,Integer> map){

        float speed = map.get(position);

        return ((float)target - position) / speed;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int n = position.length;

        for (int i = 0 ; i <  n ; i++){
            map.put(position[i],speed[i]);
        }
        Arrays.sort(position);

        int fleets = 0;
        float fleetTime = 0f;

        for (int i = n - 1; i >= 0; i--){
            
            int pos = position[i];

            float arrivalTime = getArrivalTime(pos , target , map);
            if (arrivalTime > fleetTime){
                fleets++;
                fleetTime = arrivalTime;
            }
        }
        return fleets;
    }
}