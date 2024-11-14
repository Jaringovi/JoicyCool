import java.util.*;
import java.io.*;

public class Main {
    static final long INF = 987654321;
    static long N, K, M, num, a, b, c;
    static String s;
    static ArrayList<Long> vec = new ArrayList<>();

    static class P {
        int x, y, z;
        P(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int xLen, yLen, zLen;
    static Queue<P> que = new LinkedList<>();
    static boolean[][][] visited = new boolean[104][104][104];
    static int[][][] arr = new int[104][104][104];

    static boolean check() {
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                for (int z = 0; z < zLen; z++) {
                    if (arr[i][j][z] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static long BFS() {
        long rnt = 0;
        while (!que.isEmpty()) {
            if (check()) {
                return rnt;
            }
            int queSize = que.size();
            rnt++;
            for (int i = 0; i < queSize; i++) {
                int y = que.peek().y;
                int x = que.peek().x;
                int z = que.peek().z;
                que.poll();
                for (int k = 0; k < 6; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    int nz = z + dz[k];

                    if (ny < 0 || nx < 0 || ny >= yLen || nx >= xLen || nz < 0 || nz >= zLen || visited[ny][nx][nz] || arr[ny][nx][nz] != 0) continue;

                    visited[ny][nx][nz] = true;
                    arr[ny][nx][nz] = 1;
                    que.add(new P(nx, ny, nz));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        xLen = Integer.parseInt(st.nextToken());
        yLen = Integer.parseInt(st.nextToken());
        zLen = Integer.parseInt(st.nextToken());

        for (int h = 0; h < zLen; h++) {
            for (int i = 0; i < yLen; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < xLen; j++) {
                    arr[i][j][h] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][h] == 1) {
                        que.add(new P(j, i, h));
                        visited[i][j][h] = true;
                    }
                }
            }
        }
        
        System.out.println(BFS());
    }
}
