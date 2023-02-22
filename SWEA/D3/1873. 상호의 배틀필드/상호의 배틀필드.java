import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[][] mv = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[] check = {'^','v','<','>'};
    public static void main(String[] args) throws IOException {
//        File file = new File("src/output.txt");
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int x = 0, y = 0, d = 0;
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            for(int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '^') {
                        x = i;
                        y = j;
                        break;
                    } else if (map[i][j] == 'v') {
                        x = i;
                        y = j;
                        d = 1;
                        break;
                    } else if (map[i][j] == '<') {
                        x = i;
                        y = j;
                        d = 2;
                        break;
                    } else if (map[i][j] == '>') {
                        x = i;
                        y = j;
                        d = 3;
                        break;
                    }
                }
            }
            int dx = x, dy = y;
            int n = Integer.parseInt(br.readLine());
            char[] input = br.readLine().toCharArray();
            for(char c: input){
                if(c == 'S'){
                    dx = x;
                    dy = y;
                    while(true){
                        dx += mv[d][0];
                        dy += mv[d][1];
                        if(0<= dx && dx < h && 0 <= dy && dy < w){
                            if(map[dx][dy] == '#'){
                                break;
                            }else if(map[dx][dy] == '*'){
                                map[dx][dy] = '.';
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }else{
                    if(c == 'U') {
                        d = 0;
                    } else if (c == 'D') {
                        d = 1;
                    } else if (c == 'L') {
                        d = 2;
                    } else if( c== 'R') {
                        d = 3;
                    }
                    dx = x + mv[d][0];
                    dy = y + mv[d][1];
                    map[x][y] = check[d];
                    if(0<= dx && dx < h && 0 <= dy && dy < w){
                        if(map[dx][dy] == '.'){
                            map[x][y] = '.';
                            x = dx;
                            y = dy;
                        }
                    }
                }
            }
            map[x][y] = check[d];
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(file));
//            writer.append(sb);
//        } finally {
//            if (writer != null) writer.close();
//        }
    }
}