import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> dq = new ArrayDeque<>();
		int n = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		
		for(int i = 1; i <= n; i++)
			dq.offer(i);
		sb.append("<");
		while(!dq.isEmpty()) {
			if(dq.size() == 1) {
				sb.append(dq.poll()).append(">");
				break;
			}
			for(int i = 0; i < k-1; i++) {
				dq.offer(dq.poll());
			}
			sb.append(dq.poll()).append(",").append(" ");
		}
		System.out.println(sb);
		
	}
}
