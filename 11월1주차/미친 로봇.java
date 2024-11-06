import java.util.Scanner;

public class Main {
    static int N;
    static final int maxN = 20;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static double[] probability = new double[4];
    static boolean[][] visited = new boolean[maxN * 2][maxN * 2];
    static double busyCnt = 0.0;

    public static void DFS(int y, int x, int cnt, double possible) {
        if (cnt == N) {
            busyCnt += possible;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (probability[k] == 0) continue;
            if (ny < 0 || nx < 0 || ny >= maxN * 2 || nx >= maxN * 2) continue;

            if (visited[ny][nx]) {
                continue;
            } else {
                visited[ny][nx] = true;
                DFS(ny, nx, cnt + 1, possible * probability[k]);
                visited[ny][nx] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();

        for (int i = 0; i < 4; i++) {
            probability[i] = scanner.nextDouble() / 100.0;
        }

        visited[maxN][maxN] = true;
        DFS(maxN, maxN, 0, 1.0);

        System.out.printf("%.10f%n", busyCnt); // 소수점 10자리까지 출력

        scanner.close();
    }
}
