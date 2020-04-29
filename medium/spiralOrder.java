class Solution {
    public boolean[][] visited;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new LinkedList<Integer>();
        }

        int total = matrix.length * matrix[0].length;
        int curr = 0; 
        visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> list = new LinkedList<>();
        int i = 0, j = 0;
        
        while (curr < total) {
            while (isValidPosition(i, j, matrix)) {
                curr++;
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
            }
            j--;
            i++;
            
            while (isValidPosition(i, j, matrix)) {
                curr++;
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
            }
            i--;
            j--;

            while (isValidPosition(i, j, matrix)) {
                curr++;
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
            }
            j++;
            i--;
            
            while (isValidPosition(i, j, matrix)) {
                curr++;
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        
        return list;
    }
    
    public boolean isValidPosition(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length ||
            col >= grid[0].length || visited[row][col]) {
            return false;
        }
        return true;
    }
}
