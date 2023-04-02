import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean endCheck;
    private static boolean aBoolean;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i = 0; i < 9; i++){
            String line = br.readLine();
            for(int j = 0; j < 9; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }
        sudoku(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void sudoku(int number){
        if(number == 81){
            endCheck = true;
            return;
        }

        int x = number/9; // 행
        int y = number % 9; // 열
        if(map[x][y] == 0){
            for (int i = 1; i <= 9; i++) {
                if (ischecked(x, y, i)) {
                    map[x][y] = i;
                    sudoku(number+1);
                    if(endCheck){return;}
                    map[x][y] = 0;
                }
            }
        }else{
            sudoku(number + 1);
        }

    }
    private static boolean ischecked(int x, int y, int num){
        // 행, 열 비교
        for(int i = 0; i < 9; i++){
            if(map[x][i] == num || map[i][y] == num){
                return false;
            }
        }
        // 3x3 비교
        int sx = x / 3 * 3;
        int sy = y / 3*3;
        for(int i = sx;i < sx+3; i++){
            for(int j = sy; j < sy+3; j++){
                if(map[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}