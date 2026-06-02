class Solution {
      
      List<Integer> primes = new ArrayList<>();

      private void populatePrimes(){
          
          boolean[] prime = new boolean[100002];
          Arrays.fill(prime, true);
          prime[0] = prime[1] = false;

          for (int i = 2; i < 100001; i++){

              if (prime[i]){
                  
                  primes.add(i);
                  
                  for (long m = (long) i * i; m < 100002; m += i) {
                    prime[(int) m] = false;
                  }
              }
          }
      }

      public int numTriplets(int[] nums1, int[] nums2){
          populatePrimes();
          return helper(nums1, nums2) + helper(nums2, nums1);
      }

      private int helper(int[] nums1, int[] nums2){
          Map<Integer,Integer> freq = new HashMap<>();
          for (int x : nums2){
              freq.put(x, freq.getOrDefault(x, 0) + 1);
          }
          long count = 0;
          for (int num : nums1){
              count += countPairs(num, freq);
          }
          return (int) count;
      }

      private long countPairs(int num, Map<Integer,Integer> freq){

          long S = (long) num * num;

          Map<Integer,Integer> f = new HashMap<>();
          int x = num;
          for (int p : primes){
              if ((long) p * p > x) break;
              while (x % p == 0){
                  f.put(p, f.getOrDefault(p, 0) + 1);
                  x /= p;
              }
          }
          if (x > 1){
              f.put(x, f.getOrDefault(x, 0) + 1);
          }

          // double exponents → enumerate all divisors of S
          List<Long> divisors = new ArrayList<>();
          divisors.add(1L);
          for (Map.Entry<Integer,Integer> e : f.entrySet()){
              int p = e.getKey();
              int exp = e.getValue() * 2;
              int sz = divisors.size();
              long pw = 1;
              for (int t = 1; t <= exp; t++){
                  pw *= p;
                  for (int k = 0; k < sz; k++){
                      divisors.add(divisors.get(k) * pw);
                  }
              }
          }

          // pair each divisor d with S/d, count
          long count = 0;
          for (long d : divisors){
              long other = S / d;
              if (d > other) continue;
              if (other > 100000) continue;
              int fd = freq.getOrDefault((int) d, 0);
              if (d == other){
                  count += (long) fd * (fd - 1) / 2;
              } else {
                  count += (long) fd * freq.getOrDefault((int) other, 0);
              }
          }
          return count;
      }
  }