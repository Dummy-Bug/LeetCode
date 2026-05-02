class Solution {
    static Map<Integer, Integer> map = new TreeMap<>();                           
                  
    static {                                                                      
        int MAX_CUBE_ROOT = (int) Math.pow(1000000000, 1.0/3);
        for (int i = 1; i <= MAX_CUBE_ROOT; i++) {                                
            for (int j = i; j <= MAX_CUBE_ROOT; j++) {                            
                int x = i*i*i + j*j*j;
                map.put(x, map.getOrDefault(x, 0) + 1);                           
            }                                                                     
        }
    }    


    public List<Integer> findGoodIntegers(int n) {

        List<Integer> answers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {

            if (entry.getKey() > n) {
                break;
            }
            if (entry.getValue() >= 2) {
                answers.add(entry.getKey());
            }
        }

        return answers;

    }
}