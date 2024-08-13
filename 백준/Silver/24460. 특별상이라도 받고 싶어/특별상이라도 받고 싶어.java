import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static final int maxSize = 1030;

	static int[][] arr = new int[maxSize][maxSize];
	static int N;
	static int dx[] = { 0, 1, 1, 0 };
	static int dy[] = { 0, 0, 1, 1 };

	static int solution(int y, int x, int len) {

		if (len == 1)
			return arr[y][x];

		ArrayList<Integer> vec = new ArrayList<>();

		for (int k = 0; k < 4; k++) {
			int cy = y + len * dy[k] / 2;
			int cx = x + len * dx[k] / 2;
			vec.add(solution(cy, cx, len / 2));
		}

		Collections.sort(vec);

		return vec.get(1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				arr[y][x] = scanner.nextInt();
			}
		}

		System.out.println(solution(0, 0, N));

		scanner.close();
	}
}
