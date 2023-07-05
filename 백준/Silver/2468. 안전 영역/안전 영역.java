import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] mx = {0,0,1,-1};
	static int[] my = {1,-1,0,0};
	static boolean[][] visited;
	static int[][] graph;
	static int[][] tmp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		int max_val = Integer.MIN_VALUE;
		int min_val = Integer.MAX_VALUE;
		for(int i = 0;i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				max_val = Math.max(max_val, graph[i][j]);
				min_val = Math.min(min_val, graph[i][j]);
			}
		}
		int cnt = 0;
		int result = 0;
		// 잠기지 않음
		if(min_val ==  max_val) {
			System.out.println(1);
			return;
		}
		// 최솟값 이상 ~ 최댓값 미만 -> 잠기는 케이스
		for(int d = min_val; d < max_val; d++) {
			// 잠기게 만들기
			tmp = new int[n][n];
			sink(d);
			// 방문처리 초기화 
			visited = new boolean[n][n];
			// 안전거리 개수 초기화
			cnt = 0;
			for(int i = 0;i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(tmp[i][j] == 0 || visited[i][j]) 
						continue;
					dfs(i,j);
					cnt++;
				}
			}
			result = Math.max(cnt, result);
		}
		System.out.println(result);
	}
	private static void dfs(int x, int y) {
		tmp[x][y] = 0;
		visited[x][y] = true;
		for(int i = 0;i < 4; i++) {
			int dx = x + mx[i];
			int dy = y + my[i];
			if(dx < 0 || dx >= n || dy < 0 || dy >= n)
				continue;
			if(visited[dx][dy] || tmp[dx][dy] == 0)
				continue;
			dfs(dx,dy);
		}
	}
	private static void sink(int d) {
		for(int i = 0;i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(graph[i][j] <= d) {
					tmp[i][j] = 0;
				}else {
					tmp[i][j] = graph[i][j];
				}
			}
		}
	}
}