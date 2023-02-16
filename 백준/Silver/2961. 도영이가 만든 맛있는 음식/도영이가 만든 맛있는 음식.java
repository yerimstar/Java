import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr =  new int[n][2];
		visited = new boolean[n];
		for(int i = 0;i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());		
		}
		subSet(0);
		System.out.println(result);
	}

	private static void subSet(int cnt) {
		if(cnt == n) {
			int tmpResultS = 1;
			int tmpResultB = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					tmpResultS *= arr[i][0];
					tmpResultB += arr[i][1];
				}
			}
			if(tmpResultB > 0) // 공집합이 아니라면 계산 진행 
				result = Math.min(Math.abs(tmpResultB-tmpResultS), result);
			return;
		}
		// 선택 o
		visited[cnt] = true;
		subSet(cnt+1);
		// 선택 x
		visited[cnt] = false;
		subSet(cnt+1);
	}
	
}
