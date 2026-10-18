package Lab07;
import Lab07.pack.*;

public class Lab07_680449 {
    static void task_01() {
        System.out.println("task_01");
        int[][] a = { {1,0,1,0,0},
                      {1,0,1,1,1},
                      {1,1,1,1,1},
                      {1,0,0,0,0} };

        int[][] b = { {0,1},
                      {1,0} };

        int[][] c = { {1,1,1},
                      {1,1,1},
                      {1,1,1} };

        MaximumSquare_680449 sol = new MaximumSquare_680449();
        System.out.println(sol.maximalSquare_Recurse(a));
        System.out.println(sol.maximalSquare_Memoiz(a));
        System.out.println(sol.maximalSquare_DP(a));
        System.out.println(sol.maximalSquare_Recurse(b));
        System.out.println(sol.maximalSquare_Memoiz(b));
        System.out.println(sol.maximalSquare_DP(b));
        System.out.println(sol.maximalSquare_Recurse(c));
        System.out.println(sol.maximalSquare_Memoiz(c));
        System.out.println(sol.maximalSquare_DP(c));
    }

    static void task_02() {
        System.out.println("task_02");
        int[][] grid = { {0,0,0,0},
                          {0,1,0,0},
                          {0,0,0,1},
                          {1,0,0,0} };
        GridPaths_680449 sol = new GridPaths_680449();
        System.out.println("number of paths: " + sol.numberOfPaths(grid));
    }
    public static void main(String[] args) {
        task_01();
        task_02();
    }
}