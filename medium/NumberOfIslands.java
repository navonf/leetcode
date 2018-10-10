class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // This grid has 1's or 0's, nothings else.
        // Null grid will have no islands.
        if(grid == null) return 0;

        int islandCount = 0;

        // Iterate over the grid.
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    // increase island count.
                    islandCount++;
                    // change any connecting 1's to a 0.
                    changeLandToWaterDFS(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void changeLandToWaterDFS(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length ||
           j < 0 || j >= grid[0].length ||
          grid[i][j] == '0') return;

        grid[i][j] = '0';

        changeLandToWaterDFS(grid, i + 1, j); // up
        changeLandToWaterDFS(grid, i - 1, j); // down
        changeLandToWaterDFS(grid, i, j + 1); // right
        changeLandToWaterDFS(grid, i, j - 1); // left
    }
}
