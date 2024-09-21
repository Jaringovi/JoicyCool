// 메모리: 17624 KB, 시간: 164 ms

import java.util.*;
public class Main {
    static long rnt;
    static List<Character> vec = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') vec.add(c);
        }
        String[] nVec = s.split("[+-]");
        boolean flag = true;
        rnt = Long.parseLong(nVec[0]);
        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i) == '-') flag = false;
            if (flag) rnt += Long.parseLong(nVec[i + 1]);
            else rnt -= Long.parseLong(nVec[i + 1]);
        }
        
        System.out.println(rnt);
        sc.close();
    }
}
