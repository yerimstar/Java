import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }
        quadTree(0,0,n);
        System.out.println(sb);
    }

    private static void quadTree(int x, int y, int size) {
        if(isPromising(x,y,size)){
            sb.append(map[x][y]);
        }else{
            int half = size/2;
            sb.append("(");
            quadTree(x,y,half);
            quadTree(x,y+half,half);
            quadTree(x+half,y,half);
            quadTree(x+half,y+half,half);
            sb.append(")");
        }
    }

    private static boolean isPromising(int x, int y,int size) {
        int tmp = map[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(tmp != map[i][j])
                    return false;
            }
        }
        return true;
    }
}