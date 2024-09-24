// 메모리: 27336 KB, 시간: 548 ms
import java.util.Scanner;

public class Main {
    static int[][] arr = new int[9][9];
    static boolean isValid(int y, int x, int val) {
        for (int i = 0; i < 9; i++) {
            if (arr[y][i] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (arr[i][x] == val) return false;
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (arr[i][j] == val) return false;
            }
        }
        return true;
    }
    static boolean solution() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (arr[y][x] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (isValid(y, x, val)) {
                            arr[y][x] = val;
                            if (solution()) {
                                return true;
                            }
                            arr[y][x] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                arr[y][x] = sc.nextInt();
            }
        }
        solution();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
