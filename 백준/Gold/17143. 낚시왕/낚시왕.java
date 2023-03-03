import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 초기 세팅 - 상어 위치, 낚시꾼 위치 ( c초만큼 이동 ) 
 * 2. 사람 이동 -> 같은 열에 있는 가장 가까운 상어 잡음 ( 크기의 합 갱신 )
 * 3. 상어 이동 
 * 	- 경계 만날 경우, 방향 반대로 변경
 *  - 상어가 1칸에 2마리 이상 -> 크기 비교 ( 가장 큰 애만 살아남음 ) 
 * 4. 최종 합계 반환 
 */
public class Main {
	static class Shark{
		int x,y,s,d,z;

		public Shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
	
	static int R,C,M;
	static Shark[][] map;
	static int[][] mv = {{-1,0},{1,0},{0,1},{0,-1}}; // 상하우좌
	static Queue<Shark> eatQ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = new Shark(x-1, y-1, s, d, z);
		}
		int sum = 0;
		// 사람 이동 
		for(int i = 0; i < C; i++) {
			// 상어 잡아먹기
			for(int j = 0; j < R; j++) {
				if(map[j][i] != null) {
					sum += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			// 상어 이동
			moveShark();
		}
		System.out.println(sum);
	}
	private static void moveShark() {
		// 상어 넣기
		Queue<Shark> q = new ArrayDeque<>();
		eatQ = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != null) {
					q.offer(new Shark(i,j,map[i][j].s, map[i][j].d, map[i][j].z));
				}
			}
		}
		
		// 상어 이동
		Shark cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur.s == 0) {
				continue;
			}
			checkLocation(cur);
		}
		
		while(!eatQ.isEmpty()) {
			cur = eatQ.poll();
			int dx = cur.x;
			int dy = cur.y;
			// 이미 상어가 있는 경우 -> 크기 비교
			if(map[dx][dy] != null) {
				// 원래 있는 상어보다 크기가 더 큼 -> 잡아먹기
				if(map[dx][dy].z < cur.z) {
					map[dx][dy] = cur;
				}
			}else {
				map[dx][dy] = cur;
			}
		}
	}
	
	private static void checkLocation(Shark cur) {
		int mvX = mv[cur.d-1][0];
		int mvY = mv[cur.d-1][1];
		// 상하 
		if(cur.d == 1 || cur.d == 2	) {
			int cnt = 0,dx = cur.x, dy = cur.y;
			while(true) {
				dx += mvX;
				dy += mvY; 
				if(checkEdge(dx,dy)) {
					cnt++;
				}else { // 경계 만남 -> 방향 전환
					dx -= mvX;
					dy -= mvY;
					// 상 -> 하
					if(cur.d == 1) {
						mvX = mv[1][0];
						mvY = mv[1][1];
						cur.d = 2;
					}else if(cur.d == 2) { // 하 -> 상
						mvX = mv[0][0];
						mvY = mv[0][1];
						cur.d = 1;
					}
					continue;
				}
				
				// 상어 이동시킴 
				if(cnt == cur.s) {
					map[cur.x][cur.y] = null;
					eatQ.offer(new Shark(dx, dy, cur.s,cur.d,cur.z));
					return;
				}
			}
		}
		// 좌우
		else if(cur.d == 3 || cur.d == 4) {
			int cnt = 0,dx = cur.x, dy = cur.y;
			while(true) {
				dx += mvX;
				dy += mvY; 
				if(checkEdge(dx,dy)) {
					cnt++;
				}
				
				// 경계 만남 -> 방향 전환
				else {
					dx -= mvX;
					dy -= mvY;
					// 우 -> 좌 
					if(cur.d == 3) {
						mvX = mv[3][0];
						mvY = mv[3][1];
						cur.d = 4;
					}else if(cur.d == 4) { // 좌 -> 우
						mvX = mv[2][0];
						mvY = mv[2][1];
						cur.d = 3;
					}
					continue;
				}
				// 상어 이동시킴 
				if(cnt == cur.s) {
					map[cur.x][cur.y] = null;
					eatQ.offer(new Shark(dx, dy, cur.s,cur.d,cur.z));
					return;
				}
			}
		}
		
	}
	private static boolean checkEdge(int dx, int dy) {
		if(dx < 0 || dx >= R || dy < 0 || dy >= C)
			return false;
		return true;
	}

}