import java.util.Scanner;

public class Main {

	static StringBuilder result = new StringBuilder();

	public static void solution(int cnt, int s, int mid, int e) {
		if (cnt == 1) {
			result.append(s).append(" ").append(e).append("\n");
			return;
		}

		solution(cnt - 1, s, e, mid);
		result.append(s).append(" ").append(e).append("\n");
		solution(cnt - 1, mid, s, e);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		result.append((int)Math.pow(2, N) - 1).append('\n');
		solution(N, 1, 2, 3);
		System.out.println(result.toString());
		scanner.close();
	}
}
