import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato{
		int x,y,day;

		public Tomato(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
	static Queue<Tomato> q;
	static int[][] map;
	static int m,n,cnt,ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		q = new ArrayDeque<>();
			
		for(int i = 0;i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 0) {
					cnt++;
				}else if(num == 1) {
					q.offer(new Tomato(i, j, 1));
				}
			}
		}
		if(cnt == 0) {
			System.out.println(0);
			return;
		}
		bfs();
		if(ans == 0) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	private static void bfs() {
		int[][] mv = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[n][m];
		Tomato cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int dx = cur.x + mv[i][0];
				int dy = cur.y + mv[i][1];
				if(dx < 0 || dx >= n || dy < 0 || dy >= m)
					continue;
				if(!visited[dx][dy] && map[dx][dy] == 0) {
					visited[dx][dy] = true;
					map[dx][dy] = 1;
					cnt--;
					if(cnt == 0) {
						ans = cur.day;
						return;
					}
					q.offer(new Tomato(dx, dy, cur.day+1));
				}
			}
		}
		
	}

}