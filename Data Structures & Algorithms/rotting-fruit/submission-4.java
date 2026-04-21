class Solution {

    public static boolean isValid(int i, int j, int[][] grid){
        int x = grid.length;
        int y = grid[0].length;
        return i >=0 && j >=0 && i < x && j < y && grid[i][j] == 1;
    }
    public int orangesRotting(int[][] grid) {
        int result = 0;
        int x = grid.length;
        int y = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] index = q.poll();

                for (int j=0;j<dirs.length;j++){
                    int  nx = dirs[j][0] + index[0];
                    int ny = dirs[j][1] + index[1];
                    if(isValid(nx, ny, grid)){
                        fresh--;
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            result++;
        }
        if (fresh == 0 && result > 0){
            result = result -1;
        }else if (fresh ==0){
            result = 0;
        }else{
            result = -1;
        }
        
        return result;
    }
}
