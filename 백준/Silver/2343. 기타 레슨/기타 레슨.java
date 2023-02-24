import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] lecture;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		lecture = new int[n];
		st = new StringTokenizer(br.readLine());
		long s = 0;
		long e = 0;
		for(int i = 0; i < n; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			s = Math.max(s, lecture[i]);
			e += lecture[i];
		}
		
		while(s < e) {
			long mid = (s+e)/2;
			if(checkCnt(mid) > m) {
				s = mid + 1;
			}else {
				e = mid;
			}
		}
		System.out.println(s);
	}

	private static int checkCnt(long mid) {
		int cnt = 1;
		int tmp = 0;
		for(int i = 0;i < n;i++	) {
			tmp += lecture[i];
			if(tmp > mid) {
				cnt += 1;
				tmp = lecture[i];
			}
		}
		return cnt;
	}

}