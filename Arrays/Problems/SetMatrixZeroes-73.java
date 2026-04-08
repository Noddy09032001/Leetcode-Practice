public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        /*int rows = matrix.length; // the rows
        int columns = matrix[0].length; // the columns

        List<int[]> zeros = new ArrayList<>(); // storing the coordinates of the ones which have value as 0

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0)
                    zeros.add(new int[] { i, j }); // adding the coordinates in the list
            }
        }

        // setting the rows and columns to be zero for all the coordinates
        for (int[] x : zeros) {
            int r1 = x[0];
            int c1 = x[1];

            // set row to 0
            for (int j = 0; j < columns; j++) {
                matrix[r1][j] = 0;
            }

            // set column to 0
            for (int i = 0; i < rows; i++) {
                matrix[i][c1] = 0;
            }
        }*/

        // better solution

        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        boolean[] rows = new boolean[m]; // which rows should be 0
        boolean[] cols = new boolean[n]; // which columns should be 0

        // mark rows and cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // apply changes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}