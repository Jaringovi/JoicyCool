import java.util.Scanner;

public class Main {
    static int N, M;
    static final int maxN = 300004;
    static int[] arr = new int[maxN];
    static int l = 1;
    static int r;
  
    static boolean isPossible(int num) {
        int cnt = 1;
        int remainMoney = num;
        for (int i = 0; i < N; i++) {
            if (arr[i] > num) return false;
            if (remainMoney - arr[i] >= 0) {
                remainMoney -= arr[i];
            } else {
                remainMoney = num;
                remainMoney -= arr[i];
                cnt++;
                if (cnt > M) return false;
            }
        }
        return true;
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
      
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            r += arr[i];
        }
      
        int minResult = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            boolean check = isPossible(mid);
            if (check) {
                r = mid - 1;
                minResult = Math.min(minResult, mid);
            } else {
                l = mid + 1;
            }
        }
        System.out.println(minResult);
    }
}
