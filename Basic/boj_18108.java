import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_18108 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(bf.readLine());
        System.out.print(y-543);
    }

}
