import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정
public class boj_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start, end;
        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        int endTmp = 0;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, ((o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        }));

        for (int[] meeting : meetings) {
            if (meeting[0] >= endTmp) {
                cnt++;
                endTmp = meeting[1];
            }
        }
        System.out.println(cnt);

    }
}
