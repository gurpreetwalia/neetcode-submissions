class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, bfs(i,j,grid));
                }
            }
        }
        return result;
    }

    public static boolean isValid(int i, int j, int[][] grid){
        return i >=0 && j >=0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }

    public static int bfs(int i, int j, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j] = 0;

        int size = 0;
        while(!q.isEmpty()){
            int[] n = q.poll();
            int newX = n[0];
            int newY = n[1];
            size++;

            if(isValid(newX+1, newY, grid)){
                grid[newX+1][newY] = 0;
                q.offer(new int[]{newX+1, newY});
            }

            if(isValid(newX-1, newY, grid)){
                grid[newX-1][newY] = 0;
                q.offer(new int[]{newX-1, newY});
            }

            if(isValid(newX, newY+1, grid)){
                grid[newX][newY+1] = 0;
                q.offer(new int[]{newX, newY+1});
            }

            if(isValid(newX, newY-1, grid)){
                grid[newX][newY-1] = 0;
                q.offer(new int[]{newX, newY-1});
            }
        }
        return size;
    }
}
