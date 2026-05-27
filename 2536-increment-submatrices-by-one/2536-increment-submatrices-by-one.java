class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int [][] matrix = new int[n][n];
        
        for (int[] query : queries){

            int topRow = query[0];
            int topCol = query[1];
            int bottomRow = query[2];
            int bottomCol = query[3];

            matrix[topRow][topCol] += 1;

            if (bottomCol + 1 != n){
                matrix[topRow][bottomCol + 1] -= 1;

            }
            if (bottomRow + 1 != n){
                matrix[bottomRow + 1][topCol] -= 1;
            }

            if (bottomRow + 1 != n && bottomCol + 1 != n){
                matrix[bottomRow + 1][bottomCol + 1] += 1;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                if (j == 0){
                    continue;
                }
                matrix[i][j] = matrix[i][j] + matrix[i][j-1] ;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                if (i == 0){
                    continue;
                }

                matrix[i][j] = matrix[i][j] + matrix[i-1][j];
            }
        }
        return matrix;
    }
}