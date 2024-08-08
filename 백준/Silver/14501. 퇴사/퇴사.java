import java.util.Scanner;

public class Main {	
	static int maxSize = 20004;
	static int[][] arr = new int[maxSize][2];
	static int[] dp = new int[maxSize];
	static int N, T, P, maxValue;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		for(int i = 0; i<N;i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}


		for(int i = 0; i<=N;i++) {
			dp[i] = Math.max(maxValue, dp[i]);

			T = arr[i][0]; P = arr[i][1];
			dp[i+T] = Math.max(dp[i+T], dp[i] + P);

			maxValue = Math.max(maxValue, dp[i]);
		}

		System.out.println(maxValue);
		scanner.close();	
	}
}
