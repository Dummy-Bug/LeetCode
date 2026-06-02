class Solution {

    private boolean compare(String[] s1 , String [] s2, int i , int j){
        
        int m = s1.length;
        int n = s2.length;
        // System.out.println("i" + (m-i) + " j" + (n-j));
        if ((m-i) != (n-j)){
            return false;
        }


        while( i < m && j < n){

            String w1 = s1[i];
            String w2 = s2[j];

            System.out.println(w1 + " " + w2);
            if (!w1.equals(w2)){
                return false;
            }
            i++;
            j++;
        }

        return true;

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        int l1 = sentence1.length();
        int l2 = sentence2.length();

        String [] s1;
        String [] s2;

        if (l1 < l2){
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        }else {
            s1 = sentence2.split(" ");
            s2 = sentence1.split(" ");
        }

        Map<String,Deque<Integer>> map = new HashMap<>();
        int n = s2.length;

        for (int i = 0; i < n; i++){
            
            String word = s2[i];
            Deque<Integer> q = map.getOrDefault(word, new ArrayDeque<Integer>());
            q.offer(i);
            map.put(word,q);

        }
        System.out.print(map.toString());
        int m = s1.length;

        for (int i = 0; i < m; i++){

            String word = s1[i];
            Deque<Integer> q = map.getOrDefault(word, new ArrayDeque<Integer>());
            if (q.isEmpty()){
                System.out.println("falsy");
                return false;
            }

            int index = q.peek();
            if (index == i){
                int size = q.size();

                while(size != 0){
                    size--;
                    int id = q.poll();

                    if (compare(s1, s2,i,index)){
                        return true;
                    }
                    q.offer(id);
                }
                // System.out.println("\n Before " + q.toString());
                q.poll();
                // System.out.println("After " + q.toString());
                map.put(word,q);
                System.out.println("Map " + map.toString());
            
            }
            else {
                int size = q.size();
                // System.out.println("\n Before " + q.toString());
                while (size != 0){
                    size--;

                    int id = q.poll();
                    if (compare(s1, s2,i,id)){
                        return true;
                    }

                }
                // System.out.println("After " + q.toString());
                return false;
            }
        }
        return true;
    }
}