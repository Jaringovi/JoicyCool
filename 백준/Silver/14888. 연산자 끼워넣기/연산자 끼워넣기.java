// 메모리: 19892 KB, 시간: 228 ms
import java.util.*;

public class Main {
    static long N;
    static long[] numArr = new long[20];
    static long num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextLong();
        }

        List<Character> signVec = new ArrayList<>();
        num = sc.nextLong();
        for (int i = 0; i < num; i++) {
            signVec.add('+');
        }
        num = sc.nextLong();
        for (int i = 0; i < num; i++) {
            signVec.add('-');
        }
        num = sc.nextLong();
        for (int i = 0; i < num; i++) {
            signVec.add('*');
        }
        num = sc.nextLong();
        for (int i = 0; i < num; i++) {
            signVec.add('/');
        }

        Collections.sort(signVec);

        long maxRnt = Long.MIN_VALUE;
        long minRnt = Long.MAX_VALUE;

        do {
            long rnt = numArr[0];

            for (int i = 0; i < N - 1; i++) {
                char sign = signVec.get(i);
                if (sign == '+') {
                    rnt += numArr[i + 1];
                } else if (sign == '-') {
                    rnt -= numArr[i + 1];
                } else if (sign == '*') {
                    rnt *= numArr[i + 1];
                } else if (sign == '/') {
                    rnt /= numArr[i + 1];
                }
            }

            maxRnt = Math.max(maxRnt, rnt);
            minRnt = Math.min(minRnt, rnt);

        } while (nextPermutation(signVec));

        System.out.println(maxRnt);
        System.out.println(minRnt);
    }

    public static boolean nextPermutation(List<Character> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i).compareTo(list.get(i + 1)) >= 0) {
            i--;
        }
        if (i < 0) {
            return false;
        }

        int j = list.size() - 1;
        while (list.get(i).compareTo(list.get(j)) >= 0) {
            j--;
        }

        Collections.swap(list, i, j);

        Collections.reverse(list.subList(i + 1, list.size()));

        return true;
    }
}
