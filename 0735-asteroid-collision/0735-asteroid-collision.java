class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        List<Integer> remaining = new ArrayList<>();

        for (int asteroid : asteroids){

            if (remaining.size() == 0 || asteroid > 0){
                remaining.add(asteroid);
                continue;
            }
            while (remaining.size() != 0 && remaining.get(remaining.size() - 1) > 0 && Math.abs(asteroid) > remaining.get(remaining.size() - 1)){
                remaining.remove(remaining.size() - 1);
            }
            if (remaining.size() == 0 || remaining.get(remaining.size() - 1) < 0){
                remaining.add(asteroid);
            }
            else if (Math.abs(asteroid) == remaining.get(remaining.size() - 1)){
                remaining.remove(remaining.size() - 1);
            }
        }
        int n = remaining.size();
        int [] result = new int[n];
        
        for (int i = 0; i < n; i++){
            result[i] = remaining.get(i);
        }
        return result;
    }

}