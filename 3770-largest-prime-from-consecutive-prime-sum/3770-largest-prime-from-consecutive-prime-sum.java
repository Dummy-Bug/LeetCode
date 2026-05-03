class Solution {
    static int max = 500001;
    static boolean [] sieve = new boolean [max];
    static TreeSet<Integer> set = new TreeSet<>();

    static {
        Arrays.fill(sieve,true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < max; i++){
            if (sieve[i]){
                for (long j =  (long)i*i ; j < max; j += i){
                    sieve[(int)j] = false;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < max; i++){
            
            boolean prime = sieve[i];
            if (prime){
                sum += i;
                if (sum > max) break;
                else if(sieve[(int)sum]){
                    set.add((int)sum);
                }
            }
        }

    }



    public int largestPrime(int n) {
        Integer largestPrime = set.floor(n);
        return largestPrime == null ? 0 : largestPrime;
    }
}