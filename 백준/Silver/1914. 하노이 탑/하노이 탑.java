import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static BigInteger cnt = new BigInteger("1");

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            cnt = cnt.multiply(new BigInteger("2"));
        cnt = cnt.subtract(new BigInteger("1"));
        System.out.println(cnt);
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.println(sb.toString());
        }
    }

    public static void hanoi(int node, int s, int m, int e) {
        if (node == 1) {
            sb.append(s + " " + e + "\n");
            return;
        }
        hanoi(node - 1, s, e, m);
        sb.append(s + " " + e + "\n");
        hanoi(node - 1, m, s, e);
    }
}