import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c, cnt;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		check(0, 0, (int)Math.pow(2, n));
		System.out.println(cnt);
	}

	public static void check(int x, int y, int size) {
		if(x == r && y == c) {
			flag = true;
			return;
		}
		if(!flag) {
			if(x <= r && y <= c && r < x + size && c < y + size) {
				int half = size / 2;
				check(x, y, half);
				check(x, y + half, half);
				check(x + half, y, half);
				check(x + half, y + half, half);
			}
			else{
				cnt += size*size;
			}
		}
		
	}
}