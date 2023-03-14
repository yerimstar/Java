import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int strLen, patternLen,ans;
	static int[] p;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();
		strLen = str.length();
		patternLen = pattern.length();
		kmp(str, pattern);
		System.out.println(ans);
		System.out.println(sb);
	}
	private static int[] makePattern(String pattern) {
		p = new int[patternLen];
		int idx = 0;
		for(int i = 1; i < patternLen; i++) {
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = p[idx-1];
			}
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				p[i] = idx;
			}
		}
		return p;
	}
	private static int kmp(String str, String pattern) {
		ans = 0;
		makePattern(pattern);
		int idx = 0;
		for(int i = 0; i < strLen; i++) {
			while(idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
				idx = p[idx-1];
			}
			if(str.charAt(i) == pattern.charAt(idx)) {
				if(idx == patternLen-1) {
					ans++;
					sb.append(i-idx+1).append(" ");
					idx = p[idx];
				}else {
					idx += 1;
				}
			}
		}
		return ans;
	}
}