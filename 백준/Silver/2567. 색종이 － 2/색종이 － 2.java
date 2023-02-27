import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map; // 스카프의 영역을 표현한 배열
	static boolean[][] visited; // 방문처리 배열
	static int result; // 결과 출력을 위한 변수 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // 검은색 스카프의 개수 
		int maxX = 0, maxY = 0; // 검은색 스카프가 위치하는 최대 범위를 표현하기 위한 변수 선언
		map = new int[100][100]; // 스카프 배열 초기화 
		visited = new boolean[100][100]; // 방문처리 배열 초기화 
		StringTokenizer st = null;
		int checkX = 0, checkY = 0; // 스카프의 범위가 100을 초과활 경우 발생하는 문제를 차단하기 위해 선언한 변수
		for (int i = 0; i < num; i++) { // 스카프의 개수만큼 
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1; // (1,1) ~ (100,100) 배열을 표현하기 위해 
			int x = Integer.parseInt(st.nextToken())-1;
			maxX = Math.max(x, maxX); // 최댓값 갱신
			maxY = Math.max(y, maxY);
			checkX = x + 10 > 100 ? 100 - x : 10; // 범위 지정
			checkY = y + 10 > 100 ? 100 - y : 10;
			for (int j = 0; j < checkX; j++) { // 지정한 범위만큼 검은색 스카프 값을 표시한다. 
				for (int k = 0; k < checkY; k++) {
					map[x + j][y + k] = 1;
				}
			}
		}
		maxX = maxX+ 10 >= 100 ? 100 : maxX + 11; // 전체 범위를 탐색하는 것이 아니라 최대 범위이내의 값만 체크한다. 
		maxY = maxY+ 10 >= 100 ? 100 : maxY + 11;
		for(int i = 0; i < maxX; i++) {
			for(int j = 0; j < maxY; j++) {
				if(!visited[i][j] && map[i][j] == 1) { // 아직 방문하지 않았고 값이 1인 경우 ( 검은색 스카프 ) 둘레를 탐색하러 간다. 
					check(i,j); // 둘레 탐색 
					visited[i][j] = true; // 방문처리 
				}
			}
		}
		System.out.println(result); // 결과 출력 

	}

	private static void check(int x, int y) {
		// 검은색 스카프가 하얀색 스카프를 만나는 곳을 둘레라고 볼 수 있다. (경계부분)
		int[][] mv = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 4방 탐색 배열 선언
		int dx = 0; 
		int dy = 0;
		for(int i = 0; i < 4; i++) { // 4방향 탐색 
			dx = x + mv[i][0];
			dy = y + mv[i][1];
			if(dx < 0 || dx >= 100 || dy < 0 || dy >= 100) { // 흰색 스카프의 경계 부분을 만날 경우 검은색 스카프의 둘레라고 볼 수 있다. 
				result++; // 결과 값 1 증가 
				continue; // 경계이므로 하얀색 스카프인지 확인할 필요가 없음 
			}
			if(map[x+mv[i][0]][y+mv[i][1]] == 0) { // 4방향을 탐색할 때 하얀색 스카프를 만나면 둘레라고 본다.
				result++; // 결과 값 1 증가 
			}
		}
		
	}

}