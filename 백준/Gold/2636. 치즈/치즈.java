import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] cheese;
    static boolean[][] visited;
    static boolean[][] outsideAir;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Air {
        private int x;
        private int y;

        public Air(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int result = 0;
        while (true) {
            visited = new boolean[n][m];
            outsideAir = new boolean[n][m];
            //  바깥 공기 찾기
            checkAir(0, 0);
            int cntCheese = meltingCheese();
            if (cntCheese == 0) {
                System.out.println(time);
                System.out.println(result);
                break;
            }
            time++;
            result = cntCheese;
        }
    }

    private static void checkAir(int x, int y) {
        Queue<Air> q = new ArrayDeque<>();
        q.offer(new Air(x, y));
        visited[x][y] = true;
        outsideAir[x][y] = true;
        while (!q.isEmpty()) {
            Air cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }
                if (!visited[mx][my] && cheese[mx][my] == 0) {
                    visited[mx][my] = true;
                    q.offer(new Air(mx, my));
                    outsideAir[mx][my] = true;
                }
            }
        }
    }

    private static int meltingCheese() {
        int cntCheese = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 치즈라면
                if (cheese[i][j] == 1) {
                    // 4방탐색 - 바깥공기가 있는지 체크
                    for (int k = 0; k < 4; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];
                        if (mx < 0 || mx >= n || my < 0 || my >= m) {
                            continue;
                        }
                        // 바깥공기 접촉
                        if (outsideAir[mx][my]) {
                            cheese[i][j] = 0;
                            cntCheese++;
                            break;
                        }
                    }
                }

            }
        }
        return cntCheese;
    }
}