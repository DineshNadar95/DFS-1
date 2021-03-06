// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int[] dir:dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r < m && r >= 0 && c < n && c >= 0 && matrix[r][c] == -1){
                            matrix[r][c] = dist;
                            q.add(new int[]{r,c});
                    }
                }
            }dist++;
        }
        return matrix;
        
    }
}