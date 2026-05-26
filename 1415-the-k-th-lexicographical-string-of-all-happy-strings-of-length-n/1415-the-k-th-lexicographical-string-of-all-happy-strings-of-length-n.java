class Solution {

    private void addToAns(StringBuilder sb, int targetSet) {
      char[] all = {'a', 'b', 'c'};
      int n = sb.length();

      if (n == 0) {
          sb.append(all[targetSet - 1]);
          return;
      }

      char prev = sb.charAt(n - 1);
      List<Character> available = new ArrayList<>();
      for (char c : all) {
          if (c != prev) available.add(c);
      }
      sb.append(available.get(targetSet - 1));
  }

    private void helper(StringBuilder sb , int n, int k){

        int totalStrings = (int)Math.pow(2,n);

        if (totalStrings == 1){
            return;
        }
        int setSize = totalStrings/2;
        int targetSet = (int)Math.ceil((double)k/setSize);
        addToAns(sb,targetSet);

        int startingRange = setSize*(targetSet - 1) + 1;
        int newK = k - startingRange + 1;
        helper(sb,n - 1,newK);
    }

    public String getHappyString(int n, int k) {
        
        int totalStrings = (int)Math.pow(2,n-1)*3;
        if (k > totalStrings){
            return "";
        }

        int setSize = totalStrings/3;
        int targetSet = (int)Math.ceil((double)k/setSize);

        StringBuilder sb = new StringBuilder();
        addToAns(sb,targetSet);

        int startingRange = setSize*(targetSet - 1) + 1;
        int newK = k - startingRange + 1;

        helper(sb,n-1,newK);
        return sb.toString();

    }
}