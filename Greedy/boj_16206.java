import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> cake1 = new ArrayList<>(); // 10으로 나누어떨어짐
        List<Integer> cake2 = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        int tmpCnt;
        int cakeCnt = 0;

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < 10)
                continue;
            else if (tmp == 10) {
                cakeCnt += 1;
                continue;
            }
            if (tmp % 10 == 0)
                cake1.add(tmp);
            else
                cake2.add(tmp);
        }
        Collections.sort(cake1);
        Collections.sort(cake2);

        for (int cakeLen : cake1) {

            tmpCnt = cakeLen / 10;
            if (tmpCnt - 1 <= m) {
                cakeCnt += tmpCnt;
                m -= tmpCnt - 1;
            } else {
                cakeCnt += m;
                m = 0;
            }
        }
        for (int cakeLen : cake2) {
            tmpCnt = cakeLen / 10;
            if (tmpCnt <= m) {
                cakeCnt += tmpCnt;
                m -= tmpCnt;
            } else {
                cakeCnt += m;
                m = 0;
            }
        }
        System.out.println(cakeCnt);

    }
}
