import java.util.Scanner;

public class Main {

	static int N;
	static int [][]arr = new int[130][130];
	static int rnt[] = {0,0};

	static void solution(int y, int x, int len) {
		if(len == 0) return;
		int target = arr[y][x];

		for(int cy = y; cy<y+len; cy++) {
			for(int cx = x; cx<x+len; cx++) {
				if (target != arr[cy][cx]) {
					solution(y, x, len / 2);
					solution(y + len/2, x, len / 2);
					solution(y, x + len / 2, len / 2);
					solution(y + len / 2, x + len / 2, len / 2);
					return;
				}
			}
		}

		rnt[target]++;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		for(int y = 0; y<N;y++) {
			for(int x=  0; x< N;x++) {
				arr[y][x] = scanner.nextInt();
			}
		}

		solution(0, 0, N);
		System.out.println(rnt[0]);
		System.out.println(rnt[1]);

		scanner.close();
	}

}
