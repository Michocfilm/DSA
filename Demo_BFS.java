import java.util.ArrauDeque;

public class Demo_BFS{
    static class Solution{
        int maxlandArea(int[][] grid){

            return 0;
        }
        int bfs(int r,int c,int[][] grid, boolean[][] visited){
            int size=0;
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            ArrayDeque<int []> queue = new ArrayDeque<>();
            queue.addLast(new int[] {r,c});
            visited[r][c] = true;

            while(!queue.isEmpty()){
                int[] cur =queue.removeFirst();
                for(int i= 0;i < dirs.length; ++i){
                    int next_r =cur[0] + dirs[i][0];
                    int next_c =cur[1] + dirs[i][1];
                    if(isValid(next_r, next_c,visited)){
                        queue.addLast(new int[] {next_r,next_c});
                        visited[next_r][next_c] = true;
                    }
                }
            }
            return 0;
        }
    }
}