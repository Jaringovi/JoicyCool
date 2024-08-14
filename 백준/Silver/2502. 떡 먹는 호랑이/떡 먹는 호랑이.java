import java.util.Scanner;

public class Main {

	static String arr[] = new String[40];
	static String a = "a",b = "b";
	static int firstCount, secondCount;

	static String solution(int n) {
		if(arr[n]!=null) {
			return arr[n];
		}
		if(n==2) {
			return b;
		}
		else if(n==1) {
			return a;
		}
		arr[n] = solution(n - 1) + solution(n - 2);
		return arr[n];
	}



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int D = scanner.nextInt();
		int K = scanner.nextInt();

		String result = solution(D);

		//ax + by = K
		for(int i = 0; i<result.length();i++) {
			if(result.charAt(i) == 'a') {
				firstCount++;
			}
			else secondCount++;
		}

		for(int x = 1; x<=Integer.MAX_VALUE;x++) {
			int remindValue = K - x * firstCount;
			if(remindValue % secondCount == 0) {
				int y = remindValue / secondCount;
				System.out.println(x);
				System.out.println(y);
				scanner.close();
				return;
			}
		}
	}

}
