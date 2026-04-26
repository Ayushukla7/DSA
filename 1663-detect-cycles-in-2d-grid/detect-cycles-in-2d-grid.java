class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j]) {
                    if(dfs(grid, vis, i, j, -1, -1))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] vis,
                        int x, int y, int px, int py) {
        
        vis[x][y] = true;
        
        for(int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            
            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                continue;
            
            if(grid[nx][ny] != grid[x][y])
                continue;
            
            if(nx == px && ny == py)
                continue;
            
            if(vis[nx][ny])
                return true;
            
            if(dfs(grid, vis, nx, ny, x, y))
                return true;
        }
        
        return false;
    }
}