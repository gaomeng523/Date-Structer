import java.util.*;

public class Solution16 {

    int[] dx = {0 , 0 , -1 ,1};
    int[] dy = {1 , -1 , 0 , 0};

    /**
     * 图像渲染 https://leetcode.cn/problems/flood-fill/
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length , n = image[0].length;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {sr , sc});
        int t = image[sr][sc];
        if(t == color) return image;
        while(!q.isEmpty()){
            int[] f = q.poll();
            int a = f[0] , b = f[1];
            image[a][b] = color;
            for(int i = 0 ; i < 4 ; i++){
                int x = a + dx[i] , y = b + dy[i];

                if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == t){
                    q.offer(new int[] {x , y});
                }
            }
        }
        return image;
    }

    int m;
    int n;
    boolean[][] pr = new boolean[301][301];

    /**
     * 岛屿数量 https://leetcode.cn/problems/number-of-islands/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == '1' && !pr[i][j]){
                    ret++;
                    bfs(grid ,i ,j);
                }
            }
        }
        return ret;
    }

    public void bfs(char[][] grid , int i ,int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i , j});
        pr[i][j] = true;
        while(!q.isEmpty()){
            int[] t = q.poll();
            int a = t[0] , b = t[1];
            for(int k = 0 ; k < 4 ;k++){
                int x = a + dx[k] , y = b + dy[k];
                if(x >= 0 && x < m && y >= 0 && y < n && !pr[x][y] && grid[x][y] == '1'){
                    q.offer(new int[]{x , y});
                    pr[x][y] = true;
                }
            }
        }
    }

    boolean[][] vis = new boolean[51][51];

    /**
     * 岛屿的最⼤⾯积 https://leetcode.cn/problems/max-area-of-island/
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int s = 0;
        for(int i = 0 ;i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    s = Math.max(s , bfs(grid , i , j));
                }
            }
        }
        return s;
    }
    public int bfs(int[][] grid , int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i ,j});
        vis[i][j] = true;
        int count = 1;
        while(!q.isEmpty()){
            int[] t = q.poll();
            int a = t[0] , b = t[1];
            vis[a][b] = true;
            for(int k = 0; k < 4 ;k++){
                int x = a + dx[k] , y = b + dy[k];

                if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1){
                    q.offer(new int[]{x , y});
                    vis[x][y] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 被围绕的区域 https://leetcode.cn/problems/surrounded-regions/
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0 ; i < m ;i++){
            if(board[i][0] == 'O') bfs1(board , i , 0);
            if(board[i][n - 1] == 'O') bfs1(board , i , n - 1);
        }

        for(int j = 0 ; j < n ;j++){
            if(board[0][j] == 'O') bfs1(board , 0 , j);
            if(board[m - 1][j] == 'O') bfs1(board , m - 1 , j);
        }

        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }
    public void bfs1(char[][] board , int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i , j});
        while(!q.isEmpty()){
            int[] t = q.poll();
            int a = t[0];
            int b = t[1];
            board[a][b] = '.';
            for(int k = 0 ;k < 4 ;k++){
                int x = a + dx[k] , y = b + dy[k];
                if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
                    q.offer(new int[]{x , y});
                    board[x][y] = '.';
                }
            }

        }
    }
}
