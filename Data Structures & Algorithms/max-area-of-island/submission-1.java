class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, dfs(i,j,grid));
                }
            }
        }
        return result;
    }

    public static boolean isValid(int i, int j, int[][] grid){
        return i >=0 && j >=0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }

    public static int dfs(int i, int j, int[][] grid){
        
        if(!isValid(i, j, grid)){
            return 0;
        }

        grid[i][j] = 0;
        return 1+ dfs(i+1, j, grid) +
        dfs(i, j+1, grid) +
        dfs(i-1, j, grid) +
        dfs(i, j-1, grid);

    }
}
