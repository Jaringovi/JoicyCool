// 메모리: 23624 KB, 시간: 308 ms

import java.util.Scanner;
public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] clouds;
    
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        clouds = new boolean[n][n];
        clouds[n - 1][0] = true; clouds[n - 1][1] = true;
        clouds[n - 2][0] = true; clouds[n - 2][1] = true;
        for (int i = 0; i < m; i++) {
            int d = sc.nextInt() - 1;
            int s = sc.nextInt();
            moveClouds(d, s);
            rain();
            waterCopyBug();
            createClouds();
        }
        System.out.println(totalWater());
    }
    static void moveClouds(int d, int s) {
        boolean[][] newClouds = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (clouds[i][j]) {
                    int nx = (i + dx[d] * s % n + n) % n;
                    int ny = (j + dy[d] * s % n + n) % n;
                    newClouds[nx][ny] = true;
                }
            }
        }
        clouds = newClouds;
    }
    static void rain() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (clouds[i][j]) {
                    grid[i][j]++;
                }
            }
        }
    }
    static void waterCopyBug() {
        int[] diagX = {-1, -1, 1, 1};
        int[] diagY = {-1, 1, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (clouds[i][j]) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + diagX[d];
                        int ny = j + diagY[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                            count++;
                        }
                    }
                    grid[i][j] += count;
                }
            }
        }
    }
    static void createClouds() {
        boolean[][] newClouds = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!clouds[i][j] && grid[i][j] >= 2) {
                    newClouds[i][j] = true;
                    grid[i][j] -= 2;
                }
            }
        }
        clouds = newClouds;
    }
    static int totalWater() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
}
