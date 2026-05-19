class Solution {
    public int minGenerations(int[][] points, int[] target) {

        List<int[]> al = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int[] point : points) {
            if (point[0] == target[0] && point[1] == target[1] && point[2] == target[2]) {
                return 0;
            }
            al.add(point);
            set.add(point[0] + "," + point[1] + "," + point[2]);
        }

        boolean flag = true;
        int start = 0;
        int k = 0;

        while (flag) {
            flag = false;
            int n = al.size();
            int i;
            for (i = 0; i < n; i++) {
                for (int j = start; j < n; j++) {
                    if (j <= i) {
                        continue;
                    }
                    int px = (al.get(i)[0] + al.get(j)[0]) / 2;
                    int py = (al.get(i)[1] + al.get(j)[1]) / 2;
                    int pz = (al.get(i)[2] + al.get(j)[2]) / 2;

                    if (px == target[0] && py == target[1] && pz == target[2]) {
                        return k + 1;
                    }
                    if (set.add(px + "," + py + "," + pz)) {
                        flag = true;
                        al.add(new int[] { px, py, pz });
                    }
                }
            }
            start = i;
            k++;
        }
        return -1;
    }
}