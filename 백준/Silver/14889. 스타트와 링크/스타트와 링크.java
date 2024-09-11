import java.util.*;

public class Main {

    static final int maxN = 24;
    static int[] visited = new int[maxN];
    static int[][] arr = new int[maxN][maxN];
    static int N;
    static int rnt = 98765421;

    public static void go(int i, int sum1, int sum2, List<Integer> vec1, List<Integer> vec2) {
        if (i == N) {
            rnt = Math.min(rnt, Math.abs(sum1 - sum2));
            return;
        }

        if (vec1.size() < N / 2) {
            int plusValue = 0;
            for (int a : vec1) {
                plusValue += arr[i][a];
                plusValue += arr[a][i];
            }

            vec1.add(i);
            go(i + 1, sum1 + plusValue, sum2, vec1, vec2);
            vec1.remove(vec1.size() - 1);
        }

        if (vec2.size() < N / 2) {
            int plusValue = 0;
            for (int a : vec2) {
                plusValue += arr[i][a];
                plusValue += arr[a][i];
            }

            vec2.add(i);
            go(i + 1, sum1, sum2 + plusValue, vec1, vec2);
            vec2.remove(vec2.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                arr[y][x] = sc.nextInt();
            }
        }

        List<Integer> vec1 = new ArrayList<>();
        List<Integer> vec2 = new ArrayList<>();
        go(0, 0, 0, vec1, vec2);

        System.out.println(rnt);
    }
}
