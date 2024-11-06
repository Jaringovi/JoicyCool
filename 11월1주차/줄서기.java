import java.util.*;
class Human implements Comparable<Human> {
    String alpha;
    int num;
    
    Human(String alpha, int num) {
        this.alpha = alpha;
        this.num = num;
    }
    @Override
    public int compareTo(Human other) {
        if (this.alpha.equals(other.alpha)) {
            return Integer.compare(this.num, other.num);
        }
        return this.alpha.compareTo(other.alpha);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human other = (Human) obj;
        return this.alpha.equals(other.alpha) && this.num == other.num;
    }
    @Override
    public int hashCode() {
        return Objects.hash(alpha, num);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
      
        List<Human> lineList = new ArrayList<>();
        List<Human> lineSortList = new ArrayList<>();
        Stack<Human> waitStk = new Stack<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                String s = scanner.next();
                String alpha = s.substring(0, 1);
                int num = Integer.parseInt(s.substring(2));
                Human human = new Human(alpha, num);
                lineList.add(human);
                lineSortList.add(human);
            }
        }
      
        Collections.sort(lineSortList);
      
        int curIdx = 0;
        for (int i = 0; i < N * 5; i++) {
            if (lineSortList.get(curIdx).equals(lineList.get(i))) {
                curIdx++;
            } else if (!waitStk.isEmpty() && waitStk.peek().equals(lineSortList.get(curIdx))) {
                curIdx++;
                waitStk.pop();
                i--;
            } else {
                waitStk.push(lineList.get(i));
            }
        }
      
        boolean flag = true;
        while (!waitStk.isEmpty()) {
            if (waitStk.peek().equals(lineSortList.get(curIdx))) {
                curIdx++;
                waitStk.pop();
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "GOOD" : "BAD");
    }
}
