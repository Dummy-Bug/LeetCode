class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for (int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        for (int i = 0; i < hand.length; i++){
            
            int freq = map.get(hand[i]);
            if ( freq != 0){
                map.put(hand[i] , freq - 1);
                
                int lastValue = hand[i] + groupSize - 1;
                for (int val = hand[i] + 1 ; val <= lastValue; val++){

                    int count = map.getOrDefault(val, 0);
                    if (count != 0){
                        map.put(val , count - 1);
                    }
                    else {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}