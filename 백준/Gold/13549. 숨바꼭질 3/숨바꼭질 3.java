import java.util.*;

public class Main {
    static final int MAXN = 100004;
    static boolean[] visited = new boolean[MAXN + 1];
    static int[] dx = { -1, 1 };
    static Queue<Integer> que = new LinkedList<>();
    static int N, K, rnt = 0;

    static void putNum(int num) {
        for (int i = num; i <= MAXN; i *= 2) {
            if (visited[i]) return;
            que.add(i);
            visited[i] = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        putNum(N); 
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int num = que.poll();
                if (num == K) {
                    System.out.println(rnt);
                    return;
                }

                for (int k = 0; k < 2; k++) {
                    int next = num + dx[k];
                    if (next < 0 || next > MAXN || visited[next]) continue;
                    putNum(next);
                }
            }
            rnt++;
        }

        scanner.close();
    }
}
