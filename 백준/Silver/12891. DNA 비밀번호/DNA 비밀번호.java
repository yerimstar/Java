import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Character, Integer> check = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String s = br.readLine();

		char[] dna = new char[n];
		int[] lst = new int[4];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			dna[i] = s.charAt(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}

		check.put('A', 0);
		check.put('C', 0);
		check.put('G', 0);
		check.put('T', 0);

		for (int i = 0; i < p; i++) {
			check.put(dna[i], check.get(dna[i]) + 1);
		}
		if (lst[0] <= check.get('A') && lst[1] <= check.get('C') && lst[2] <= check.get('G')
				&& lst[3] <= check.get('T'))
			cnt++;

		for (int i = 0; i < n - p; i++) {
			char cStart = dna[i];
			char cEnd = dna[i + p];
			check.put(cStart, check.get(cStart) - 1);
			check.put(cEnd, check.get(cEnd) + 1);
			if (lst[0] <= check.get('A') && lst[1] <= check.get('C') && lst[2] <= check.get('G')
					&& lst[3] <= check.get('T'))
				cnt++;
		}
		System.out.println(cnt);
	}
}