import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int yLen = 3, xLen = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int time = 0;
        while (arr[r][c] != k && time <= 100) {
            if (yLen >= xLen) { 
                for (int i = 1; i <= yLen; i++) {
                    Map<Integer, Integer> countMap = new HashMap<>();
                    List<int[]> countList = new ArrayList<>();
                    for (int j = 1; j <= xLen; j++) {
                        if (arr[i][j] != 0) {
                            countMap.put(arr[i][j], countMap.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }
                    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                        countList.add(new int[]{entry.getValue(), entry.getKey()});
                    }
                    countList.sort((a, b) -> {
                        if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                        return Integer.compare(a[0], b[0]);
                    });
                    int idx = 1;
                    for (int[] p : countList) {
                        if (idx > 100) break;
                        arr[i][idx++] = p[1];
                        arr[i][idx++] = p[0];
                    }
                    while (idx <= 100) {
                        arr[i][idx++] = 0;
                    }
                    xLen = Math.max(xLen, countList.size() * 2);
                }
            } else { 
                for (int j = 1; j <= xLen; j++) {
                    Map<Integer, Integer> countMap = new HashMap<>();
                    List<int[]> countList = new ArrayList<>();
                    for (int i = 1; i <= yLen; i++) {
                        if (arr[i][j] != 0) {
                            countMap.put(arr[i][j], countMap.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }
                    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                        countList.add(new int[]{entry.getValue(), entry.getKey()});
                    }
                    countList.sort((a, b) -> {
                        if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                        return Integer.compare(a[0], b[0]);
                    });
                    int idx = 1;
                    for (int[] p : countList) {
                        if (idx > 100) break;
                        arr[idx++][j] = p[1];
                        arr[idx++][j] = p[0];
                    }
                    while (idx <= 100) {
                        arr[idx++][j] = 0;
                    }
                    yLen = Math.max(yLen, countList.size() * 2);
                }
            }
            time++;
        }
        System.out.println(time > 100 ? -1 : time);
    }
}
