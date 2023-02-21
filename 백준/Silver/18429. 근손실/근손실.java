import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,k, answer, weight;
	static int[] kit, result;
	static boolean[] checked;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		kit = new int[n];
		result = new int[n];
		checked = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			kit[i] = Integer.parseInt(st.nextToken())-k;
		}
		weight = 500;
		exercise(0);
		System.out.println(answer);
	}
	private static void exercise(int day) {
		if(day == n) {
			answer++;
			return;
		}
		for(int kitNo = 0; kitNo < n; kitNo++) {
			if(promising(kitNo) && !checked[kitNo]) {
				weight = weight + kit[kitNo];
				result[day] = kitNo;
				checked[kitNo] = true;
				exercise(day+1);
				weight = weight - kit[kitNo];
				checked[kitNo] = false;
			}
		}
	}
	private static boolean promising(int kitNo) {
		if(weight + kit[kitNo]< 500)
			return false;
		return true;
	}

}