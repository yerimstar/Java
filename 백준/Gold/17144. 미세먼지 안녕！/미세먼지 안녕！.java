import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Dust{
		int x,y,val;

		public Dust(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Dust [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
		
	}
	static Queue<Dust> q;
	static Queue<Dust> tmp;
	static int r,c,t;
	static int[][] map;
	static int[][] air;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int airCheck = 0;
		map = new int[r][c];
		air = new int[2][2];
		q = new ArrayDeque<>();
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(val == -1) {
					air[airCheck][0] = i;
					air[airCheck][1] = j;
					airCheck++;
				}else if(val > 0) {
					q.offer(new Dust(i, j, val));
				}
			}
		}
		// t초동안 일어나는 일 
		for(int i = 0; i < t; i++) {
			bfs();
			move();
			for(int j =0; j < r; j++) {
				for(int k = 0; k < c; k++) {
					q.offer(new Dust(j,k,map[j][k]));
				}
			}
		}
		
		
		int sum = 0;
		for(int i = 0;i < r; i++) {
			for(int j = 0;j < c; j++) {
				if(map[i][j] > 0)
					sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void bfs() {
		int[][] mv = {{0,1},{0,-1},{1,0},{-1,0}};
	    tmp = new ArrayDeque<>();
		Dust cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				int dx = cur.x + mv[i][0];
				int dy = cur.y + mv[i][1];
				
				if(dx < 0 || dx >= r || dy < 0 || dy >= c) 
					continue;
				if(map[dx][dy] != -1) {
					cnt++;
					tmp.offer(new Dust(dx,dy, cur.val/5));
				}
			}
			tmp.offer(new Dust(cur.x,cur.y, -(cur.val/5)*cnt));
		}
		while(!tmp.isEmpty()) {
			cur = tmp.poll();	
			map[cur.x][cur.y] += cur.val; 
		}
	}
	private static void move() {
		// 반시계방향
		// 좌
		for(int i = air[0][0]-2; i >= 0; i--) {
			map[i+1][0] = map[i][0];
		}
		// 상
		for(int i = 1; i < c; i++) {
			map[0][i-1] = map[0][i];
		}
		// 우
		for(int i = 1; i <= air[0][0]; i++) {
			map[i-1][c-1] = map[i][c-1];
		}
		// 하
		for(int i = c-1; i > 1; i--) {
			map[air[0][0]][i] = map[air[0][0]][i-1];
		}
		// 공기청정기
		map[air[0][0]][1] = 0;
		
		// 시계방향
		// 좌
		for(int i = air[1][0]+2; i < r; i++) {
			map[i-1][0] = map[i][0]; 
		}
		// 하
		for(int i = 1; i < c; i++) {
			map[r-1][i-1] = map[r-1][i];
		}
		// 우
		for(int i = r-2; i >= air[1][0]; i--) {
			map[i+1][c-1] = map[i][c-1];
		}
		// 상
		for(int i = c-2; i > 0; i--) {
			map[air[1][0]][i+1] = map[air[1][0]][i];
		}
		map[air[1][0]][1] = 0;
	}
}