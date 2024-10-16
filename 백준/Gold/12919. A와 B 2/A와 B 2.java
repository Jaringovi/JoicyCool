import java.util.Scanner;
public class Main {
    static boolean solution(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        
        if (t.charAt(t.length() - 1) == 'A') {
            if (solution(s, t.substring(0, t.length() - 1))) {
                return true;
            }
        }
        
        if (t.charAt(0) == 'B') {
            String reversed = new StringBuilder(t.substring(1)).reverse().toString();
            if (solution(s, reversed)) {
                return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solution(s, t) ? 1 : 0);
    }
}
