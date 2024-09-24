// 메모리: 18188 KB, 시간: 192 ms
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    static final int maxW = 34;
    static final int maxT = 1004;
    static int T, W;
    static int[][][] dp = new int[maxT][2][maxW];  // DP 테이블
    static int[] arr = new int[maxT];  // 자두가 떨어지는 배열
    public static int solution(int t, int locate, int w) {
        if (t >= T) return 0;
        if (w < 0) return Integer.MIN_VALUE;
        if (dp[t][locate][w] != -1) return dp[t][locate][w];
        // 현재 위치가 0인 곳이라면
        if (locate == 0) {
            dp[t][0][w] = Math.max(solution(t + 1, 0, w), solution(t + 1, 1, w - 1));
        }
        // 현재 위치가 1인 곳이라면
        else {
            dp[t][1][w] = Math.max(solution(t + 1, 0, w - 1), solution(t + 1, 1, w));
        }
        dp[t][arr[t]][w]++;
        return dp[t][locate][w];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();
        for (int t = 0; t < T; t++) {
            arr[t] = sc.nextInt() - 1;
        }
        for (int[][] d : dp) {
            for (int[] row : d) {
                Arrays.fill(row, -1);
            }
        }
        System.out.println(Math.max(solution(0, 0, W), solution(0, 1, W - 1)));
    }
}
