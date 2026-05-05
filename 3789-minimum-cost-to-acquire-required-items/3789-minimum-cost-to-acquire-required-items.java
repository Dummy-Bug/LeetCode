class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        if (cost1 + cost2 < costBoth) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        } else if (cost1 >= costBoth) {
            long cost = (long) costBoth * need1;
            if (need2 > need1) {
                cost += Math.min((long) costBoth, (long) cost2) * ((long) need2 - need1);
            }
            return cost;
        } else if (cost2 >= costBoth) {
            long cost = (long) costBoth * need2;
            if (need1 > need2) {
                cost += Math.min((long) costBoth, (long) cost1) * ((long) need1 - need2);
            }
            return cost;
        } else {
            if (need1 <= need2) {
                long cost = (long) costBoth * need1;
                cost += (long) cost2 * (need2 - need1);
                return cost;
            } else {
                long cost = (long) costBoth * need2;
                cost += (long) cost1 * (need1 - need2);
                return cost;
            }
        }
    }
}