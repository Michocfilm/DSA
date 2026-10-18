// package Lab06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import pack.*;

public class Lab06_680449 {
    static void demoQueueIterator() {
        MyQueueL_680449<String> queue = new MyQueueL_680449<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cantaloupe");
        System.out.print("standard for each: ");
        for (var item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("demo iterator");
        Iterator<String> iter = queue.iterator();
        char ch = 'n';
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.indexOf(ch) != -1) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
    static void demoShuntingAndRPN() { // compute InFix
        String inFix = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        String postFix = MyShunting_680449.infixToPostfix(inFix);
        System.out.println("postFix= " + postFix);
        double ans = MyRPN_680449.computeRPN(postFix);
        System.out.println(ans); 
    }
    static class MaxArea { 
        public int maxLandArea(int[][] grid) {
            int max = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        int area = bfs(grid, visited, r, c);
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }
        private int bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
            Queue<int[]> queue = new LinkedList<>();
            visited[startR][startC] = true;
            queue.offer(new int[]{startR, startC});
            int count = 0;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                count++;
                for (int[] d : directions) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];
                    if (isValid(grid, visited, nr, nc)) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            return count;
        }
        private boolean isValid(int[][] grid, boolean[][] visited, int r, int c) {
            return r >= 0 && r < grid.length &&
                c >= 0 && c < grid[0].length &&
                grid[r][c] == 1 && !visited[r][c];
        }   
    }
    static void demoLargestIsland() {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0}
        };
        MaxArea s = new MaxArea();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);        
    }
    public static void main(String[] args) {
        demoQueueIterator();
        demoShuntingAndRPN();
        demoLargestIsland();
    }
}