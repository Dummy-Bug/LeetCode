class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int sum = 0;
        int count = 0;
        int n = people.length;
        Arrays.sort(people);

        int i = 0;
        int j = n - 1;

        while( i <= j){
            if (people[i] + people[j] <= limit){
                i++;
            }
            count++;
            j--;
        }
        return count;
    }
}