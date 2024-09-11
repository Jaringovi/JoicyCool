import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int num, st, router, start, end, mid, ans = 0;
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            pos.add(num);
        }

        Collections.sort(pos);
        start = 1;
        end = pos.get(n - 1) - pos.get(0);

        while (start <= end) {
            router = 1;
            mid = (start + end) / 2;
            st = pos.get(0);

            for (int i = 1; i < n; i++) {
                if (pos.get(i) - st >= mid) {
                    router++;
                    st = pos.get(i);
                }
            }

            if (router >= c) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
