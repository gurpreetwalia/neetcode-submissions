class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(int i, int j, char[][]grid){
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int z=0;z<4;z++){
            int nx = i + dirs[z][0];
            int ny = j + dirs[z][1];

            if(isValid(nx, ny, grid)){
                grid[nx][ny] = '0';
                dfs(nx, ny, grid);
            }
        }
    }

    public static boolean isValid(int i, int j, char[][]grid){
        return i >=0 && j>=0 && i< grid.length && j< grid[0].length && grid[i][j] == '1';
    }
}
