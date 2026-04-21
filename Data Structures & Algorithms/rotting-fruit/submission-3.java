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

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] index = q.poll();
                if (isValid(index[0], index[1] + 1 , grid)){
                    fresh--;
                    grid[index[0]][index[1]+1] = 2;
                    q.offer(new int[]{index[0], index[1]+1});
                }
                if (isValid(index[0], index[1] - 1 , grid)){
                    fresh--;
                    grid[index[0]][index[1]-1] = 2;
                    q.offer(new int[]{index[0], index[1]-1});
                }
                if (isValid(index[0]+1, index[1] , grid)){
                    fresh--;
                    grid[index[0]+1][index[1]] = 2;
                    q.offer(new int[]{index[0]+1, index[1]});
                }
                if (isValid(index[0]-1, index[1] , grid)){
                    fresh--;
                    grid[index[0]-1][index[1]] = 2;
                    q.offer(new int[]{index[0]-1, index[1]});
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
