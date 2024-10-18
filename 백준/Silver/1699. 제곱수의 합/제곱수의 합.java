// 메모리: 18460 KB, 시간: 224 ms
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 100004;
        int[] dp = new int[maxN];
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int divNum = 1; divNum * divNum <= i; divNum++) {
                dp[i] = Math.min(dp[i], dp[i - divNum * divNum] + 1);
            }
        }
        System.out.println(dp[n]);
        scanner.close();
    }
}
