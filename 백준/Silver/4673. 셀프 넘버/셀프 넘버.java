public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[10001];
        for(int i = 1; i <= 10000; i++){
            if(!visited[i]){
                sb.append(i).append("\n");
            }
            int check = i;
            int num = i;
            while(num > 0) {
                check += (num % 10);
                if(check > 10000)
                    break;

                num /= 10;
            }
            if(check <= 10000){
                visited[check] = true;
            }
        }
        System.out.println(sb);
    }
}