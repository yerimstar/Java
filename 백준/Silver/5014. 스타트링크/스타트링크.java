import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
F - 가장 높은 층
S - 현재 위치
G - 목적지
U - 위로 올라감
D - 아래로 내려감
1차원에 bfs 진행
- 시작 위치 -> 목적지
- for문 돌면서 위로 올라가거나 아래로 내려가면서 목적지로 이동
- 방문처리 배열은 int배열로 생성해서 최소 이동거리 갱신
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] visited = new int[f+1];
        Arrays.fill(visited,-1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            if(num == g){
                System.out.println(visited[num]);
                return;
            }
            int tmp1 = num + u;
            if(tmp1 <= f){
                if(visited[tmp1] == -1){
                    visited[tmp1] = visited[num] + 1;
                    q.offer(tmp1);
                }
            }

            int tmp2 = num - d;
            if(tmp2 > 0) {
                if(visited[tmp2] == -1){
                    visited[tmp2] = visited[num] + 1;
                    q.offer(tmp2);
                }
            }
        }
        System.out.println("use the stairs");
    }
}