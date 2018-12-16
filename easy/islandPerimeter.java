class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    // if we've gotten here. we're at a valid position with a 1.
                    if(i+1 > grid.length-1 || grid[i+1][j] == 0) {
                        perimeter++;
                    }

                    if(i-1 < 0 || grid[i-1][j] == 0) {
                        perimeter++;
                    }

                    if(j-1 < 0 || grid[i][j-1] == 0) {
                        perimeter++;
                    }t

                    if(j+1 > grid[0].length-1 || grid[i][j+1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        
        return perimeter;
    }

}
