// 메모리: 110436 KB, 시간: 752 ms
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr = new int[300004];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        int l = 1, r = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            r += arr[i];
        }

        int minResult = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                minResult = Math.min(minResult, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(minResult);

        scanner.close();
    }

    static boolean check(int mid) {
        int num = 0;
        int count = 1;

        for (int i = 0; i < N; i++) {
            if (mid >= num + arr[i]) {
                num += arr[i];
            } else {
                if (arr[i] > mid) {
                    return false;
                }
                num = arr[i];
                count++;
            }
        }

        return M >= count;
    }
}
