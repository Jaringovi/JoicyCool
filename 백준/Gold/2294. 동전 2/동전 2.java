//메모리: 17808 KB, 시간: 184 ms
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt(); 
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0; 
        
        // 아이디어: 코인 이전에꺼에서 코인 하나만큼 더한거랑 비교
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
       if(dp[k] <= k){
            System.out.println(dp[k]);    
        }
        else{
            System.out.println(-1);
        }
    }
}
