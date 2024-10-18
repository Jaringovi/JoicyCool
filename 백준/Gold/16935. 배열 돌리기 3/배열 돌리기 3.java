//메모리: 37440 KB, 시간: 808 ms
import java.util.Scanner;

public class Main {

    static final int maxN = 104;
    static int[][] arr = new int[maxN][maxN];
    static int[][] copyArr = new int[maxN][maxN];

    static int yLen, xLen, K, kind;

    public static void copyArrFun() {
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                copyArr[y][x] = arr[y][x];
            }
        }
    }

    public static void printArr() {
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }
    }

    // 1번 연산
    public static void reverseHeight() {
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = copyArr[yLen - 1 - y][x];
            }
        }
    }

    // 2번 연산
    public static void reverseWidth() {
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = copyArr[y][xLen - 1 - x];
            }
        }
    }

    // 3번 연산
    public static void rotateRight() {
        int num = yLen;
        yLen = xLen;
        xLen = num;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = copyArr[xLen - x - 1][y];
            }
        }
    }

    // 4번 연산
    public static void rotateLeft() {
        int num = yLen;
        yLen = xLen;
        xLen = num;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = copyArr[x][yLen - y - 1];
            }
        }
    }

    // 5번 연산
    public static void divRotateRight() {
        // 4 => 1
        for (int y = 0; y < yLen / 2; y++) {
            for (int x = 0; x < xLen / 2; x++) {
                arr[y][x] = copyArr[y + yLen / 2][x];
            }
        }
        // 1 => 2
        for (int y = 0; y < yLen / 2; y++) {
            for (int x = xLen / 2; x < xLen; x++) {
                arr[y][x] = copyArr[y][x - xLen / 2];
            }
        }
        // 2 => 3
        for (int y = yLen / 2; y < yLen; y++) {
            for (int x = xLen / 2; x < xLen; x++) {
                arr[y][x] = copyArr[y - yLen / 2][x];
            }
        }
        // 3 => 4
        for (int y = yLen / 2; y < yLen; y++) {
            for (int x = 0; x < xLen / 2; x++) {
                arr[y][x] = copyArr[y][x + xLen / 2];
            }
        }
    }

    // 6번 연산
    public static void divRotateLeft() {
        // 1 => 4
        for (int y = 0; y < yLen / 2; y++) {
            for (int x = 0; x < xLen / 2; x++) {
                arr[y + yLen / 2][x] = copyArr[y][x];
            }
        }
        // 4 => 3
        for (int y = yLen / 2; y < yLen; y++) {
            for (int x = 0; x < xLen / 2; x++) {
                arr[y][x + xLen / 2] = copyArr[y][x];
            }
        }
        // 3 => 2
        for (int y = yLen / 2; y < yLen; y++) {
            for (int x = xLen / 2; x < xLen; x++) {
                arr[y - yLen / 2][x] = copyArr[y][x];
            }
        }
        // 2 => 1
        for (int y = 0; y < yLen / 2; y++) {
            for (int x = xLen / 2; x < xLen; x++) {
                arr[y][x - xLen / 2] = copyArr[y][x];
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        yLen = sc.nextInt();
        xLen = sc.nextInt();
        K = sc.nextInt();

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                arr[y][x] = sc.nextInt();
            }
        }

        while (K-- > 0) {

            kind = sc.nextInt();
            copyArrFun();

            if (kind == 1) {
                reverseHeight();
            } else if (kind == 2) {
                reverseWidth();
            } else if (kind == 3) {
                rotateRight();
            } else if (kind == 4) {
                rotateLeft();
            } else if (kind == 5) {
                divRotateRight();
            } else if (kind == 6) {
                divRotateLeft();
            }
        }

        printArr();
        sc.close();
    }
}
