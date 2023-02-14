import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, val;

    Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++)
                graph[i][j] = c[j] - 48;
        }
        bfs(n, m, 0, 0);
        System.out.println(graph[n - 1][m - 1]);
    }

    public static void bfs(int n, int m, int sx, int sy) {
        int dx, dy;
        int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true; // 시작 지점 방문처리
        q.offer(new Node(sx, sy, graph[sx][sy])); // 시작 값 큐에 삽입
        while (!q.isEmpty()) { // 큐가 비어있지 않으면
            Node cur = q.poll(); // pop해서 4방탐색
            for (int i = 0; i < 4; i++) {
                dx = cur.x + mv[i][0];
                dy = cur.y + mv[i][1];
                if (0 <= dx && dx < n && 0 <= dy && dy < m) { // 그래프 범위 내에 있는지 확인
                    if (!visited[dx][dy] && graph[dx][dy] == 1) { // 아직 방문하지 않았고 값이 1인 곳 탐색
                        visited[dx][dy] = true; // 방문처리
                        graph[dx][dy] += cur.val; // 이동 거리 누적
                        q.offer(new Node(dx, dy, graph[dx][dy])); // 큐 삽입
                    }
                }
            }
        }
    }
}