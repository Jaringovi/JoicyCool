// 메모리: 18176 KB, 시간: 684 ms
import java.util.Scanner;
public class Main {
    static final int MAX_N = 26;
    static int[][] graph = new int[MAX_N][MAX_N];
    static int n, m;
    static int answer = 0;
    public static void dfs(int cnt) {
        if (cnt == n * m) {
            answer++;
            return;
        }
        int x = cnt / m + 1;
        int y = cnt % m + 1;
        dfs(cnt + 1);
        if (graph[x - 1][y] == 0 || graph[x][y - 1] == 0 || graph[x - 1][y - 1] == 0) {
            graph[x][y] = 1;
            dfs(cnt + 1);
            graph[x][y] = 0;  
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        dfs(0);
        System.out.println(answer);
    }
}
