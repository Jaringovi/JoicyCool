// 808ms
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<String> vec = new ArrayList<>();
        String s;

        for (int i = 0; i < N; i++) {
            s = sc.next();
            vec.add(s);
        }

        int K = sc.nextInt();

        for (int i = 0; i < vec.size(); i++) {
            int zeroCnt = 0;
            for (int sLen = 0; sLen < vec.get(i).length(); sLen++) {
                if (vec.get(i).charAt(sLen) == '0') zeroCnt++;
            }
            if (zeroCnt <= K && (K - zeroCnt) % 2 == 0) {
                map.put(vec.get(i), map.getOrDefault(vec.get(i), 0) + 1);
            }
        }

        int rnt = 0;
        for (Map.Entry<String, Integer> iter : map.entrySet()) {
            rnt = Math.max(rnt, iter.getValue());
        }

        System.out.println(rnt);

        sc.close();
    }
}
