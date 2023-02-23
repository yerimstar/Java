import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		if (n >= k) {
			System.out.println(n - k);
		} else {
			moveLocation(n);
		}
	}

	private static void moveLocation(int n) {
		Queue<Integer> q = new ArrayDeque<>();
	
		q.offer(n);
		visited[n] = 0;
		
		int x = 0;
		while (!q.isEmpty()) {
			x = q.poll();

			if (x == k) {
				System.out.println(visited[x]);
				return;
			}
			
			if (0 <= x - 1 && visited[x - 1] == 0) {
				q.offer(x-1);
				visited[x-1] = visited[x] + 1;
			}
			if (x + 1 < 100001 &&  visited[x + 1] == 0) {
				q.offer(x+1);
				visited[x+1] = visited[x] + 1;
			}
			if (2 * x < 100001 && visited[2 * x] == 0) {
				q.offer(2*x);
				visited[2*x] = visited[x] + 1;
			}
		}

	}
}