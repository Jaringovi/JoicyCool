import java.util.*;

public class Main {
    static final int maxV = 32010;
    static int V, E, A, B;

    static int[] inDegree = new int[maxV];
    static List<List<Integer>> graph = new ArrayList<>(maxV);

    public static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (inDegree[i] == 0) que.add(i);
        }

        for (int rep = 0; rep < V; rep++) {
            if (que.isEmpty()) break; // 큐가 비었으면 중단
            int from = que.poll();
            System.out.print(from + " ");
            for (int to : graph.get(from)) {
                inDegree[to]--;
                if (inDegree[to] == 0) que.add(to);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            graph.get(A).add(B);
            inDegree[B]++;
        }

        topologySort();
    }
}
