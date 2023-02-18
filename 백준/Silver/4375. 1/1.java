import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null) {
            BigInteger n = BigInteger.valueOf(Integer.parseInt(input));
            BigInteger num = BigInteger.ONE;
            while (true) {
                if (num.remainder(n).equals(BigInteger.ZERO)) {
                    sb.append(num.toString().length()).append("\n");
                    break;
                }
                num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }
        }
        System.out.println(sb);
    }
}