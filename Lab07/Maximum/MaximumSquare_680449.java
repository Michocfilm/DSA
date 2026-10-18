package Lab07.pack;

public class MaximumSquare_680449 {
    public int maximalSquare_Recurse(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                maxSide = Math.max(maxSide, helper_Recurse(grid, r, c));
            }
        }
        return maxSide * maxSide;
    }

    private int helper_Recurse(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        int left = helper_Recurse(grid, r, c - 1);
        int up = helper_Recurse(grid, r - 1, c);
        int diag = helper_Recurse(grid, r - 1, c - 1);

        return 1 + Math.min(left, Math.min(up, diag));
    }

    public int maximalSquare_Memoiz(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Integer[][] memo = new Integer[rows][cols];
        int maxSide = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxSide = Math.max(maxSide, helper_Memoiz(grid, r, c, memo));
            }
        }
        return maxSide * maxSide;
    }

    private int helper_Memoiz(int[][] grid, int r, int c, Integer[][] memo) {
        if (r < 0 || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        if (memo[r][c] != null) {
            return memo[r][c];
        }
        int left = helper_Memoiz(grid, r, c - 1, memo);
        int up = helper_Memoiz(grid, r - 1, c, memo);
        int diag = helper_Memoiz(grid, r - 1, c - 1, memo);
        memo[r][c] = 1 + Math.min(left, Math.min(up, diag));
        return memo[r][c];
    }

    public int maximalSquare_DP(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 1 + Math.min(dp[r][c - 1],
                                     Math.min(dp[r - 1][c], dp[r - 1][c - 1]));
                    }
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        return maxSide * maxSide;
    }
    void toString_backdoor() {
    }
}