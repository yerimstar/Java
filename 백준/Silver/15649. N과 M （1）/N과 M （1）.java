import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] isSelected = new boolean[n];
		int[] output = new int[m];
		permutation(n,m,0,isSelected,output);
	}
	public static void permutation(int n, int m, int depth, boolean[] isSelected, int[] output) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}	
		for(int i = 0; i< n; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				output[depth] = i+1;
				permutation(n, m, depth+1, isSelected, output);
				isSelected[i] = false;
			}
		}
	}
}
