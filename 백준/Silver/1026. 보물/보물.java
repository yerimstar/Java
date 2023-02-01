import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Integer[] A = new Integer[n];
		Integer[] B = new Integer[n];
		int result = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B,Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			result += A[i]*B[i];
		}
		System.out.println(result);
		
	}
}