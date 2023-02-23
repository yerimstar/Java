import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int n;
	static ArrayList<Integer>[] lst;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		// 인접 리스트 생성
		lst = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			lst[i] = new ArrayList<Integer>();
		}
		
		int a,b;
		for(int i = 0;i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			lst[a].add(b);
			lst[b].add(a);
		}
	
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		bfs(v);
		System.out.println(sb);
	}


	private static void dfs(int v) {
		sb.append(v).append(" ");
		visited[v] = true;
		Collections.sort(lst[v]);
		for(Integer node : lst[v]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[n+1];
		
		q.offer(v);
		visited[v] = true;
		
		int cur = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			sb.append(cur).append(" ");
			Collections.sort(lst[cur]);
			for(Integer node : lst[cur]) {
				if(!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
	}
}