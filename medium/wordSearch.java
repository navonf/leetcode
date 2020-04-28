class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || col < 0 || row >= board.length || 
            col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[row][col];
        
        // mark visited
        board[row][col] = '#';
        
        // try all different directions
        boolean result = 
            dfs(board, row + 1, col, word, index + 1) ||
            dfs(board, row - 1, col, word, index + 1) ||
            dfs(board, row, col + 1, word, index + 1) ||
            dfs(board, row, col - 1, word, index + 1);
        
        // reset position we visited
        board[row][col] = temp;
            
        return result;
    }
}
