class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    bfs(i,j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    public static void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

        while(!q.isEmpty()){
            int[] n = q.poll();
            grid[n[0]][n[1]] = '0';
            for(int x=0;x<dirs.length;x++){
                int nx = dirs[x][0] + n[0];
                int ny = dirs[x][1] + n[1];
                if(isValid(nx, ny, grid)){
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isValid(int i, int j, char[][] grid){
        return i >= 0 && j >=0 && i < grid.length && j < grid[0].length && grid[i][j] == '1';
    }
}
