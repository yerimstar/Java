import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if(Math.abs(i1) == Math.abs(i2)) {
					if(i1 > i2)
						return 1;
				}
				return Math.abs(i1) > Math.abs(i2) ? 1 : -1;
			}
			
		});
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine()); 
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}else{
					sb.append(pq.poll()).append("\n");
				}
			}else {	
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
}