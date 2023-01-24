import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++)
                System.out.print(' ');
            for(int k =0; k < 2*n-(2*i+1); k++)
                System.out.print('*');
            System.out.println();
        }

    }
}
