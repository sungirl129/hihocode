import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1014 {
    private static class Trie {
        //        char ch;
        int count;
        Map<Character, Trie> next = new HashMap<>();
        public Trie(int count) {
//            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Trie root = new Trie(0);
        for(int i = 0; i < n; i++) {
            String line = scanner.next();
            Trie node = root;
            for(char c:line.toCharArray()) {
                if(node.next.containsKey(c)) {
                    Trie t = node.next.get(c);
                    t.count++;
                    node = t;
                } else {
                    Trie nt = new Trie(1);
                    node.next.put(c, nt);
                    node = nt;
                }
            }
        }
        int m = scanner.nextInt();
        for(int i = 0; i < m; i++) {
            String s = scanner.next();
            Trie r = root;
            boolean flag = true;
            for(char c:s.toCharArray()) {
                if(r.next.containsKey(c)) {
                    r = r.next.get(c);
                } else {
                    flag = false;
                    System.out.println(0);
                    break;
                }
            }
            if(flag) {
                System.out.println(r.count);
            }
        }
    }

}
