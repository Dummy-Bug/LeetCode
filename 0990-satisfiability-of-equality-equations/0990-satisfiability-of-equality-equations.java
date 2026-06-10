class Solution {

    class DSU{
        int parent[];
        int size[];

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            buildParent(n);
        }

        private void buildParent(int n){
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getParent(int node){

            if (parent[node] == node){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }

        public int getSize(int node){
            return size[node];
        }

        public void addToGraph(int x, int y){

            int px = getParent(x);
            int py = getParent(y);

            if (px == py){
                return;
            }
            int sx = getSize(px);
            int sy = getSize(py);

            System.out.println(x+" "+y+" "+px+" "+py);
            if (sx >= sy){
                size[px] = sx + sy;
                parent[py] = px;
            }
            else {
                size[py] = sy + sx;
                parent[px] = py;
            }
        }

    }
    public boolean equationsPossible(String[] equations) {

        DSU dsu = new DSU(26);
        
        for (String equation : equations){


            int var1 = equation.charAt(0);
            int var2 = equation.charAt(3);

            if (equation.charAt(1) == '!'){
                if (var1 == var2)return false;
            }
            else {
                dsu.addToGraph(var1 - 'a' , var2 - 'a');
            }
            
        }

        for (String equation : equations){


            int var1 = equation.charAt(0);
            int var2 = equation.charAt(3);

            if (equation.charAt(1) == '!'){
                System.out.println(dsu.getParent(var1 - 'a'));
                System.out.println(dsu.getParent(var2 - 'a'));
                if (dsu.getParent(var1 - 'a') == dsu.getParent(var2 - 'a')){
                    return false;
                }
            }
            
        } 
        return true;
    }
}