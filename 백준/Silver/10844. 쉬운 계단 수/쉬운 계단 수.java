// 메모리: 17740 KB, 시간: 172 ms
import java.util.Scanner;

public class Main {

    static final int maxN = 100;
    static final int maxIdx = 9;
    static final int mod = (int) 1e9;
    static int N;

    // first: stage 단계, second: 위치
    static int[][] dp = new int[maxN][maxIdx + 1];
    static int[] dI = { -1, 1 };

    public static int solution(int stage, int idx) {
        if (stage < 0) return 0;
        if (dp[stage][idx] != 0) return dp[stage][idx];

        for (int k = 0; k < 2; k++) {
            int nextIdx = idx + dI[k];
            if (nextIdx < 0 || nextIdx > maxIdx) continue;
            dp[stage][idx] = (dp[stage][idx] + solution(stage - 1, nextIdx)) % mod;
        }
        return dp[stage][idx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= maxIdx; i++) {
            dp[0][i] = 1;
        }

        N = sc.nextInt();
        N--;

        int result = 0;
        for (int i = 0; i <= maxIdx; i++) {
            result = (result + solution(N, i)) % mod; 
        }

        System.out.println(result);
        sc.close();
    }
}
