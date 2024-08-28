// 실행시간:172 메모리: 17724
import java.util.Scanner;

public class Main {
    static final int maxN = 24;
    static int[] arr = new int[maxN];
    static int N, S, cnt = 0;

     static void go(int n, int sum) {
        if (n >= N) {
            if (sum == S) cnt++;
            return;
        }
        
        go(n + 1, sum);
        go(n + 1, sum + arr[n]);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        go(0, 0);
        
        if (S == 0) cnt--;
        System.out.println(cnt);
        
        sc.close();
    }
}
