// 메모리: 19696 KB, 시간: 228 ms

import java.util.*;
public class Main {
    static String[] wheel = new String[5];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            wheel[i] = sc.next();
        }
        int k = sc.nextInt();
        int[] rot = new int[5];
        for (int i = 0; i < k; i++) {
            Arrays.fill(rot, 0);
            int num = sc.nextInt();
            int dir = sc.nextInt();
            rot[num] = dir;
            int cur = num;
            int curDir = dir;
            for (int w = num - 1; w > 0; w--) {
                if (wheel[cur].charAt(6) != wheel[w].charAt(2)) {
                    rot[w] = -curDir;
                    curDir = -curDir;
                    cur--;
                } else {
                    break;
                }
            }
            cur = num;
            curDir = dir;
            for (int w = num + 1; w <= 4; w++) {
                if (wheel[cur].charAt(2) != wheel[w].charAt(6)) {
                    rot[w] = -curDir;
                    curDir = -curDir;
                    cur++;
                } else {
                    break;
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (rot[j] == 0) continue;
                if (rot[j] == 1) {
                    wheel[j] = wheel[j].charAt(7) + wheel[j].substring(0, 7);
                } else if (rot[j] == -1) {
                    wheel[j] = wheel[j].substring(1) + wheel[j].charAt(0);
                }
            }
        }
        int result = 0;
        if (wheel[1].charAt(0) == '1') result++;
        if (wheel[2].charAt(0) == '1') result += 2;
        if (wheel[3].charAt(0) == '1') result += 4;
        if (wheel[4].charAt(0) == '1') result += 8;
        System.out.println(result);
        sc.close();
    }
}
