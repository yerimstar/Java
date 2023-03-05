import java.util.*;

class Solution {
    static class Node{
        int x,y,val;

        public Node(int x, int y,int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static boolean[][] visited;
    public static int solution(int[][] maps) {
        int answer = 0;
        bfs(maps,0,0);
        if(!visited[maps.length-1][maps[0].length-1]){
            return -1;
        }
        return maps[maps.length-1][maps[0].length-1];
    }
    private static void bfs(int[][] maps,int x, int y){
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        int[][] mv = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,1));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if(!visited[dx][dy] && maps[dx][dy] == 1){
                    visited[dx][dy] = true;
                    maps[dx][dy] = cur.val + 1;
                    q.offer(new Node(dx,dy,cur.val+1));
                }
            }
        }
    }
}