class Solution {
    public void setZeroes(int[][] matrix) {
        // check for the first row will need to be zeroed.
        boolean firstRowZero = false;
        for(int col = 0; col < matrix[0].length; col++) {
            if(matrix[0][col] == 0)
                firstRowZero = true;
        }
        
        // mark columns for later.
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    // make first row 0.
                    matrix[0][col] = 0;
                }
            }
        }
        
        // zero out any rows now.
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    // zero out the row.
                    for(int j = 0; j < matrix[0].length; j++) {
                        matrix[row][j] = 0;
                    }
                }
            }
        }
        
        // zero out the columns.
        for(int j = 0; j < matrix[0].length; j++) {
            // zero out that column.
            if(matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // zero out the rest of the first row iff needed.
        if(firstRowZero) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
