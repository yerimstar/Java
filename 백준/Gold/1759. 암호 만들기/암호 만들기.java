import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		char[] ch = new char[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ch);
		String s = "";
		for(int i = 0; i < (1<<c); i++) {
			s = "";
			if(Integer.bitCount(i) == l) {
				int vowelCnt = 0;
				int cnt = 0;
				for(int j = 0; j < c; j++) {
					if((i & (1 << j)) > 0) {
						if(ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u') {
							vowelCnt+=1 ;
						}else {
							cnt+= 1;
						}
						s += ch[j];
	
					}
				}
				if(vowelCnt >= 1 && cnt >= 2) {
					pq.offer(s);
				}
			}
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}

}