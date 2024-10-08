// 메모리: 22108 KB, 시간: 232 ms
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static final int INF = 987654321;
    static int N;
    static final int maxN = 1004;
    static int[][] arr = new int[maxN][3];
    static int[][] dp = new int[maxN][3];

    public static int solution(int idx, int choice) {
        if (dp[idx][choice] != INF) {
            return dp[idx][choice];
        }
        if (idx == 0) {
            return arr[idx][choice];
        }
        for (int i = 0; i < 3; i++) {
            if (i == choice) continue;
            dp[idx][choice] = Math.min(dp[idx][choice], solution(idx - 1, i));
        }
        dp[idx][choice] += arr[idx][choice];
        return dp[idx][choice];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                arr[i][k] = sc.nextInt();
            }
        }

        for (int i = 0; i < maxN; i++) {
            Arrays.fill(dp[i], INF);
        }

        int result = Math.min(Math.min(solution(N - 1, 0), solution(N - 1, 1)), solution(N - 1, 2));
        System.out.println(result);
        
        sc.close();
    }
}
