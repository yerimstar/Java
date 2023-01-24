import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n-1; i++){
            for(int j = n-i-1; j > 0; j--)
                System.out.print(" ");
            System.out.print("*");
            if(i > 0) {
                for (int j = 0; j < 2 * i - 1; j++)
                    System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < 2*n-1; i++)
            System.out.print("*");
    }
}
