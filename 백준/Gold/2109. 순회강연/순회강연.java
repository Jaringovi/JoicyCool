// 메모리: 38984 KB, 시간: 492 ms

import java.util.*;
public class Main {
     // first: 마감일, second: 비용
    static List<Pair> vec = new ArrayList<>(); 
    // 사용 가능한 강의들이 들어가는 큐
    static PriorityQueue<Integer> que = new PriorityQueue<>();  
    static int n, p, d;
    static class Pair implements Comparable<Pair> {
        int deadline;
        int price;
        public Pair(int deadline, int price) {
            this.deadline = deadline;
            this.price = price;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            p = sc.nextInt();  
            d = sc.nextInt();  
            vec.add(new Pair(d, p));
        }
        Collections.sort(vec);
        // 가능한 강의들을 우선순위 큐에 넣기
        for (int i = 0; i < n; i++) {
            que.add(vec.get(i).price);
            // 마감일을 초과한 경우, 최소 비용 제거
            if (que.size() > vec.get(i).deadline) que.poll();  
        }
        // 비용 계산
        int rnt = 0;
        while (!que.isEmpty()) {
            rnt += que.poll();
        }
        System.out.println(rnt);
    }
}
