import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        // 정렬
        Arrays.sort(arr);
        int low = 1; // 가질 수 있는 거리 최솟값
        int high = arr[n - 1] - arr[0] + 1; // 가질 수 있는 거리 최댓값
        int mid;
        while (low < high) { // upperbound 형식
            mid = (low + high) / 2;
            if (cntRouter(mid) < c) { // 아직 공유기 개수가 모자르면 -> 거리를 좁힌다.
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        sb.append(low-1); // upperBound는 초과하는 가장 초기값이므로 -1 해줘야 한다.
        System.out.println(sb.toString());
    }

    public static int cntRouter(int distance) {
        int cnt = 1; // 1번째 집 무조건 설치
        int lastRouter = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastRouter >= distance) {
                cnt++;
                lastRouter = arr[i];
            }
        }
        return cnt;
    }
}