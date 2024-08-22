// 메모리: 30864 KB, 시간: 416 ms
import java.util.*;

public class Main {
    static final int maxSize = 104;
    static int[][] arr = new int[maxSize][maxSize];
    static int[][] visited = new int[maxSize][maxSize];
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxH = 0;
        int rnt = 0;

        N = sc.nextInt();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                arr[y][x] = sc.nextInt();
                maxH = Math.max(maxH, arr[y][x]);
            }
        }

        for (int height = 0; height <= maxH; height++) {
            for (int[] row : visited) {
                Arrays.fill(row, 0);
            }

            int cnt = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (arr[y][x] > height && visited[y][x] == 0) {
                        cnt++;
                        visited[y][x] = 1;
                        DFS(y, x, height);
                    }
                }
            }
            rnt = Math.max(rnt, cnt);
        }

        System.out.println(rnt);
    }

    static void DFS(int y, int x, int height) {
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] == 1) continue;
            if (arr[ny][nx] <= height) continue;
            visited[ny][nx] = 1;
            DFS(ny, nx, height);
        }
    }
}
