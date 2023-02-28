import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static Edge[] edgeLst;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		edgeLst = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeLst[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edgeLst);

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		int cnt = 0;
		int minWeight = 0;
		for (Edge edge : edgeLst) {
			if(union(edge.from, edge.to)) {
				cnt++;
				minWeight += edge.weight;
			}
			if(cnt == V) {
				break;
			}
		}
		System.out.println(minWeight);

	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b)
			return false;
		parents[a] = b;
		return true;
	}

	private static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

}