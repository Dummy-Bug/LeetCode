class Solution {
    public List<Integer> grayCode(int n) {

        if (n == 0) {
            List<Integer> base = new ArrayList<>();
            base.add(0);
            return base;
        }

        List<Integer> prev = grayCode(n - 1);
        List<Integer> curr = new ArrayList<>(prev); 

        int placeValue = 1 << (n - 1);

        for (int i = prev.size() - 1; i >= 0; i--) {
            curr.add(placeValue + prev.get(i));
        }

        return curr;
    }
}