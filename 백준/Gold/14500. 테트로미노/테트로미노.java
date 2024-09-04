import java.util.Scanner;

public class Main {
    static final int MAXN = 504;
    static int xLen, yLen;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[MAXN][MAXN];
    static int[][] arr = new int[MAXN][MAXN];
    static int maxRnt = 0;

    static void DFS(int sy, int sx, int cnt, int sum) {
        if (cnt == 4) {
            maxRnt = Math.max(maxRnt, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int ny = sy + dy[k];
            int nx = sx + dx[k];

            if (ny < 0 || nx < 0 || ny >= yLen || nx >= xLen || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            DFS(ny, nx, cnt + 1, sum + arr[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    static void checkShape(int y, int x) {
        int[][][] uShapes = {
            {{0, 1}, {0, -1}, {1, 0}},
            {{0, 1}, {0, -1}, {-1, 0}},
            {{1, 0}, {-1, 0}, {0, 1}},
            {{1, 0}, {-1, 0}, {0, -1}}
        };

        for (int i = 0; i < 4; i++) {
            int sum = arr[y][x];
            boolean valid = true;
            for (int j = 0; j < 3; j++) {
                int ny = y + uShapes[i][j][0];
                int nx = x + uShapes[i][j][1];
                if (ny < 0 || nx < 0 || ny >= yLen || nx >= xLen) {
                    valid = false;
                    break;
                }
                sum += arr[ny][nx];
            }
            if (valid) {
                maxRnt = Math.max(maxRnt, sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        yLen = sc.nextInt();
        xLen = sc.nextInt();
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = sc.nextInt();
            }
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                visited[y][x] = true;
                DFS(y, x, 1, arr[y][x]);
                visited[y][x] = false;
                checkShape(y, x);
            }
        }

        System.out.println(maxRnt);
        sc.close();
    }
}
