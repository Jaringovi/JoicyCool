// 메모리: 116364 KB, 시간: 1216 ms

import java.util.*;
public class Main {
    static long N, M, num;
    static List<Long> v = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        M = sc.nextLong();
        
        for (int i = 0; i < N; i++) {
            num = sc.nextLong();
            v.add(num);
        }
        
        Collections.sort(v);
        
        long left = 1, right = v.get(v.size() - 1) * M;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < v.size(); i++) {
                cnt += mid / v.get(i);
                if (cnt > M) break;
            }
            if (cnt >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(left);
        sc.close();
    }
}
