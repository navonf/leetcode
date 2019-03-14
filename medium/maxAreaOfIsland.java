class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int area = DFS(i, j, grid);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        
        return maxArea;
    }
    
    public int DFS(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        // mark visited.
        grid[i][j] = 0;
        
        return DFS(i+1, j, grid) + DFS(i-1, j, grid) + DFS(i, j+1, grid) + DFS(i, j-1, grid) + 1;
    }
}
