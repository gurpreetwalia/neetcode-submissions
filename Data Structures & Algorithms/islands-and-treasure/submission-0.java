class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.size() == 0) return;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] node = q.poll();

            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newCol >= 0 
                && newRow < grid.length && newCol < grid[0].length 
                && grid[newRow][newCol] == INF){
                    q.offer(new int[] {newRow, newCol});
                    grid[newRow][newCol] = grid[row][col] + 1;
                } 
                
            }
        }
    }
}
