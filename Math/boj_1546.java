// 평균

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int score;
        int sum = 0;
        int maxScore = 0;
        int n = Integer.parseInt(bf.readLine());
        String[] line = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            score = Integer.parseInt(line[i]);
            sum += score;
            maxScore = Math.max(maxScore,score);
        }
        System.out.println((100.0*sum/maxScore)/n);

    }
}
