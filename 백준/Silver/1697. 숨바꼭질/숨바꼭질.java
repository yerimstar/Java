import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x, cnt;

	public Node(int x, int cnt) {
		super();
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int n, k;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if (n >= k) {
			System.out.println(n - k);
		} else {
			moveLocation(n);
		}
	}

	private static void moveLocation(int n) {
		Queue<Node> q = new ArrayDeque<>();
		visited = new boolean[100001];

		q.offer(new Node(n, 0));

		Node cur = null;
		while (!q.isEmpty()) {

			cur = q.poll();
			int x = cur.x;
			int cnt = cur.cnt;

			if (x == k) {
				System.out.println(cnt);
				return;
			}

			visited[x] = true;

			if (0 <= x - 1 && !visited[x - 1]) {
				q.offer(new Node(x - 1, cnt + 1));
			}
			if (x + 1 < 100001 && !visited[x + 1]) {
				q.offer(new Node(x + 1, cnt + 1));
			}
			if (2 * x < 100001 && !visited[2 * x]) {
				q.offer(new Node(2 * x, cnt + 1));
			}
		}

	}
}