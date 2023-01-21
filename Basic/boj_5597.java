import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[28];
        int[] result = new int[2];
        int cnt = 0;

        for (int i = 0; i < 28; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(nums);
        for (int i = 1; i < 31; i++) {
//            System.out.println(Arrays.binarySearch(nums, i));
            if (Arrays.binarySearch(nums, i) < 0) {
                result[cnt++] = i;
            }
        }
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
