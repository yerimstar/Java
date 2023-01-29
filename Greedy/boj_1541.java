import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] expressions = bf.readLine().split("-");
        int result = 0;

        for (int i = 0; i < expressions.length; i++) {
            String[] expression = expressions[i].split("\\+");
            int tmpNum = 0;
            for (String num : expression)
                tmpNum += Integer.parseInt(num);

            if (i == 0)
                result += tmpNum;
            else
                result -= tmpNum;
        }
        System.out.println(result);

    }
}

