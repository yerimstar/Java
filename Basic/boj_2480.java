import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A == B) {
            System.out.print(B == C ? 10000 + A * 1000 : 1000 + A * 100);
        } else if (B == C || A == C) {
            System.out.print(1000 + C * 100);
        } else{
            System.out.print(Math.max(Math.max(A,B),C)*100);
        }
    }

}
