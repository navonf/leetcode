class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) 
            return new LinkedList<Integer>();
        
        if(matrix.length == 1 && matrix[0].length == 1) {
            List<Integer> spiral = new LinkedList<>();
            spiral.add(matrix[0][0]);
            return spiral;
        }
        
        int i = 0;
        int j = -1;
        int moves = 0;
        int moveX = matrix[0].length - 1;
        int moveY = matrix.length - 1;

        int totalMoves = (matrix.length * matrix[0].length);
        
        List<Integer> spiral = new LinkedList<>();
        
        // this conditional breaks when we have no more moves left.
        while(true) {
            for(int x = 0; x < moveX+1; x++) {
                j++;
                spiral.add(matrix[i][j]);
                moves++;
                // System.out.println("i: " + i + ", j: "+j+ ", matrix[i][j]:" + matrix[i][j]);
            }
            
            if(hasMovesLeft(moves, totalMoves)) break;

            for(int y = 0; y < moveY; y++) {
                i++;
                spiral.add(matrix[i][j]);
                moves++;
                // System.out.println("i: " + i + ", j: "+j+ ", matrix[i][j]:" + matrix[i][j]);
            }
            
            if(hasMovesLeft(moves, totalMoves)) break;
            
            for(int x = 0; x < moveX; x++) {
                j--;
                spiral.add(matrix[i][j]);
                moves++;
                // System.out.println("i: " + i + ", j: "+j+ ", matrix[i][j]:" + matrix[i][j]);
            }
            
            if(hasMovesLeft(moves, totalMoves)) break;
            
            // this last one we go up one less time 
            // because we already did the top row.
            for(int x = 0; x < moveY-1; x++) {
                i--;
                spiral.add(matrix[i][j]);
                moves++;
                // System.out.println("i: " + i + ", j: "+j+ ", matrix[i][j]:" + matrix[i][j]);
            }
            
            if(hasMovesLeft(moves, totalMoves)) break;
            
            moveX -= 2;
            moveY -= 2;
        }
        
        return spiral;
    }
    
    public boolean hasMovesLeft(int moves, int total) {
        return moves >= total;
    }
}
