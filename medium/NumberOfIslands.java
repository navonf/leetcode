class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islandCount++;
                    dfs(i, j, grid);
                }
            }
        }
        return islandCount;
    }
    
    public void dfs(int i, int j, char[][] grid) {
        // remember to check grid[i][j] because we are using
        // the indicies to index into the array, if invalid,
        // it will lead to an index out of bound.
        if (i < 0 || j < 0 || i > grid.length-1 || 
            j > grid[0].length-1 || grid[i][j] == '0') {
            return;
        }
        // the spot is valid, put a 0 to mark as visited.
        grid[i][j] = '0';
        // go up
        dfs(i-1, j, grid);
        // go right
        dfs(i, j+1, grid);
        // go left
        dfs(i, j-1, grid);
        // go down
        dfs(i+1, j, grid);
    }
}
