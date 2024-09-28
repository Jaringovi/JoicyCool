//메모리: 302908 KB, 시간: 712 ms
import java.util.*;

public class Main {

    static final int maxK = 26;
    static int rnt, N, M;
    static String s;
    static boolean[] useAlphabet = new boolean[maxK];
    static List<String> vec = new ArrayList<>();

    public static void solution(int idx, int cnt) {

        // 다 셋을때
        if (cnt <= 0) {
            int possibleCnt = 0;
            for (String s : vec) {
                boolean flag = true;
                for (char c : s.toCharArray()) {
                    int cIdx = c - 'a';
                    if (!useAlphabet[cIdx]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) possibleCnt++;
            }

            rnt = Math.max(rnt, possibleCnt);
            return;
        }
        // cnt를 다 쓰지 못하고 넘어갈 경우 제외
        if (idx >= maxK) return;

        // 이미 있는것들이라면 다음 꺼로 넘어감
        if (useAlphabet[idx]) {
            solution(idx + 1, cnt);
            return;
        }
        solution(idx + 1, cnt);
        useAlphabet[idx] = true;
        solution(idx + 1, cnt - 1);
        useAlphabet[idx] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            s = sc.next();
            vec.add(s);
        }

        if (M < 5) {
            System.out.println(0);
            return;
        }

        List<Character> basicCharVec = Arrays.asList('a', 't', 'n', 'c', 'i');
        for (char c : basicCharVec) {
            int cIdx = c - 'a';
            useAlphabet[cIdx] = true;
        }

        solution(0, M - 5);
        System.out.println(rnt);
    }
}
