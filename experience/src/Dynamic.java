public class Dynamic {
    /**
     * 第 N 个泰波那契数  https://leetcode.cn/problems/n-th-tribonacci-number/
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int a = 0 , b = 1 , c = 1;

        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int d = 0;
        for(int i = 3 ; i <= n ; i++){
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    /**
     * 三步问题（easy）https://leetcode.cn/problems/three-steps-problem-lcci/
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        int mod = (int)1e9 + 7;
        if(n == 1 || n == 2) return n;
        int a = 1 , b = 1 , c = 2;
        int ret =0;
        for(int i = 3 ; i <= n; i++){
            ret = (( a + b ) % mod+ c) % mod;

            a = b;
            b = c;
            c = ret;
        }
        return ret;
    }

    /**
     * 使⽤最⼩花费爬楼梯 https://leetcode.cn/problems/min-cost-climbing-stairs/
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2 ; i <= n ; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1] , dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 方法一 : 空间复杂度较大
     * https://leetcode.cn/problems/decode-ways/description/  解码⽅法
     * @param ss
     * @return
     */
    public int numDecodings(String ss) {
        char[] s = ss.toCharArray();

        int n = s.length;
        int[] dp = new int[n];
        //初始化第一个数
        if(s[0] != '0') dp[0] = 1;
        if(n == 1) return dp[0];
        //初始化第二个数
        if(s[1] != '0' && s[0] != '0') dp[1] += 1;
        int t = s[1] - '0' + (s[0] - '0') * 10;
        if(t >= 10 && t <= 26) dp[1] += 1;

        for(int i = 2 ; i < n ;i++){
            if(s[i] != '0') dp[i] += dp[i - 1];
            int t2 = (s[i- 1] - '0') * 10 + s[i] - '0';
            if(t2 >= 10 && t2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 解法二 : 优化了空间
     * @param ss
     * @return
     */
    public int numDecodings1(String ss) {
        char[] s = ss.toCharArray();

        int n = s.length;
        int[] dp = new int[n + 1];

        if(s[0] != '0') dp[1] += 1;

        dp[0] = 1;

        for(int i = 2 ; i <= n ;i++){
            if(s[i - 1] != '0') dp[i] += dp[i - 1];
            int t2 = s[i - 1] - '0' + (s[i - 2] - '0') * 10;
            if(t2 >= 10 && t2 <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 不同路径 https://leetcode.cn/problems/unique-paths/
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][1] = 1;
        for(int i = 1 ; i <= m ; i++)
            for(int j = 1 ; j <= n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m][n];
    }

    /**
     * 不同路径II  https://leetcode.cn/problems/unique-paths-ii/
     * @param ob
     * @return
     */
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length , n = ob[0].length;
        int[][] dp = new int[m + 1][n + 1];

        dp[0][1] = 1;
        for(int i = 1 ; i <= m ; i++)
            for(int j = 1 ; j <= n ; j++){
                if(ob[i - 1][j - 1] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m][n];
    }

    /**
     * 礼物的最⼤价值 https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
     * @param frame
     * @return
     */
    public int jewelleryValue(int[][] frame) {
        int m = frame.length; int n = frame[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1 ;i <= m ;i++)
            for(int j = 1; j <= n ;j++)
                dp[i][j] = Math.max(dp[i-1][j] + frame[i - 1][j - 1] ,dp[i][j - 1] + frame[i - 1][j - 1]);

        return dp[m][n];
    }

    /**
     * 下降路径最⼩和  https://leetcode.cn/problems/minimum-falling-path-sum/
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 2];
        for(int i = 1; i <= n; i++) dp[i][0] = dp[i][n + 1] = Integer.MAX_VALUE;
        for(int i = 1 ;i <= m ;i++)
            for(int j = 1; j <= n ; j++)
                dp[i][j] = Math.min(dp[i - 1][j + 1],Math.min(dp[i - 1][j - 1] , dp[i - 1][j])) + matrix[i - 1][j - 1];

        int ret = Integer.MAX_VALUE;
        for(int j = 0 ;j <= n ;j++)
            ret = Math.min(ret , dp[m][j]);

        return ret;
    }

    /**
     * 最⼩路径和  https://leetcode.cn/problems/minimum-path-sum/
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0 ;i <= m ;i++) dp[i][0] = Integer.MAX_VALUE;
        for(int j = 0 ; j <= n ; j++) dp[0][j] = Integer.MAX_VALUE;
        dp[0][1] = 0;
        for(int i = 1 ; i <= m ;i++)
            for(int j = 1 ;j <= n ;j++)
                dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - 1]) + grid[i - 1][j - 1];

        return dp[m][n];
    }

    /**
     * 地下城游戏  https://leetcode.cn/problems/dungeon-game/
     * @param d
     * @return
     */
    public int calculateMinimumHP(int[][] d) {
        int m = d.length, n = d[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int j = 0; j <= n; j++) dp[m][j] = Integer.MAX_VALUE;
        for(int i = 0; i <= m; i++) dp[i][n] = Integer.MAX_VALUE;
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for(int i = m - 1; i >= 0; i--)
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - d[i][j];
                dp[i][j] = Math.max(dp[i][j], 1);
            }
        return dp[0][0];
    }
}
