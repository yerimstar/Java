import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int cnt = 0;

		cnt = Math.min(n, m) / 2;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] res = new int[n][m];
		for (int i = 1; i <= cnt; i++) {
			int checkNum = 0;
			int nums = 2 * (m + n - 4 * i + 2);
			int[] lst = new int[nums];
			for (int j = i - 1; j < m - i; j++) {
				lst[checkNum++] = arr[i - 1][j];
			}
			for (int j = i - 1; j < n - i; j++) {
				lst[checkNum++] = arr[j][m - i];
			}
			for (int j = m - i; j > i - 1; j--) {
				lst[checkNum++] = arr[n - i][j];
			}
			for (int j = n - i; j > i - 1; j--) {
				lst[checkNum++] = arr[j][i - 1];
			}

			int check = nums < r ? r % nums : r;
			checkNum = check;

			for (int j = i - 1; j < m - i; j++) {
				if (checkNum > nums - 1)
					checkNum = 0;
				res[i - 1][j] = lst[checkNum++];
			}
			for (int j = i - 1; j < n - i; j++) {
				if (checkNum > nums - 1)
					checkNum = 0;
				res[j][m - i] = lst[checkNum++];
			}
			for (int j = m - i; j > i - 1; j--) {
				if (checkNum > nums - 1)
					checkNum = 0;
				res[n - i][j] = lst[checkNum++];
			}
			for (int j = n - i; j > i - 1; j--) {
				if (checkNum > nums - 1)
					checkNum = 0;
				res[j][i - 1] = lst[checkNum++];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}
}