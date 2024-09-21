// 메모리: 17712 KB, 시간: 168 ms

import java.util.Scanner;
public class Main {
    static int[][] taste = new int[2][10];
    static int N, answer = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            taste[0][i] = sc.nextInt();
            taste[1][i] = sc.nextInt();
        }
        dfs(0, 1, 0, false);
        System.out.println(answer);
        sc.close();
    }
    public static void dfs(int idx, int multi, int sum, boolean isUsing) {
        if (idx == N) {
            if (isUsing) {
                answer = Math.min(answer, Math.abs(multi - sum));
            }
            return;
        }
        dfs(idx + 1, multi, sum, isUsing);
        dfs(idx + 1, multi * taste[0][idx], sum + taste[1][idx], true);
    }
}
