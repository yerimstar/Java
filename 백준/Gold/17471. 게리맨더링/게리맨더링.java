import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] bit, people;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        bit = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int to = Integer.parseInt(st.nextToken());
                bit[i] |= (1 << (to - 1));
            }
        }

        int minNum = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n) - 1; i++) {
            int check1 = 0;
            int check2 = 0;
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    check1 |= (1 << j);
                } else {
                    check2 |= (1 << j);
                }
            }
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (!visited[j] && ((check1 & (1 << j)) != 0)) {
                    sum1 += bfs(j, check1);
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!visited[j] && ((check2 & (1 << j)) != 0)) {
                    sum2 += bfs(j, check2);
                    break;
                }
            }

            if ((sum1 != -1) && (sum2 != -1)) {
                minNum = Math.min(minNum, Math.abs(sum1 - sum2));
            }
        }

        if (minNum == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minNum);
        }

    }

    private static int bfs(int start, int checkNum) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int checkCnt = Integer.bitCount(checkNum);
        int cnt = 1;
        int sum = people[start];
        if (cnt == checkCnt) {
            return sum;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && ((bit[cur] & (1 << i)) != 0) && ((checkNum & (1 << i)) != 0)) {
                    q.offer(i);
                    visited[i] = true;
                    sum += people[i];
                    cnt += 1;
                }
                if (cnt == checkCnt) {
                    return sum;
                }
            }
        }
        return -1;
    }
}