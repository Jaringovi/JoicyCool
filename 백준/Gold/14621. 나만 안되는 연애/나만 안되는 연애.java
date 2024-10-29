import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static char[] universityType;
    static class Edge {
        int u, v, distance;
        Edge(int u, int v, int distance) {
            this.u = u;
            this.v = v;
            this.distance = distance;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); 
        universityType = new char[n + 1]; 
        for (int i = 1; i <= n; i++) {
            universityType[i] = scanner.next().charAt(0);
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int d = scanner.nextInt();
            if (universityType[u] != universityType[v]) { 
                edges.add(new Edge(u, v, d));
            }
        }
        System.out.println(kruskal());
    }
    static int kruskal() {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        edges.sort(Comparator.comparingInt(e -> e.distance)); 
        int totalDistance = 0, edgeCount = 0;
        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                totalDistance += edge.distance;
                edgeCount++;
                if (edgeCount == n - 1) return totalDistance; 
            }
        }
        return -1; 
    }
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}
