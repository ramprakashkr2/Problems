import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int[] color;
    static int[] answer;

    static Map<Integer, Integer> dfs(int node) {
        Map<Integer, Integer> curr = new HashMap<>();

        // add own color
        curr.put(color[node], 1);

        for (int child : tree[node]) {
            Map<Integer, Integer> childMap = dfs(child);

            // small to large merging
            if (childMap.size() > curr.size()) {
                Map<Integer, Integer> temp = curr;
                curr = childMap;
                childMap = temp;
            }

            // merge child into curr
            for (int c : childMap.keySet()) {
                curr.put(c, curr.getOrDefault(c, 0) + childMap.get(c));
            }
        }

        answer[node] = curr.size(); // distinct colors
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        // parent array input
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = sc.nextInt();
        }

        // build tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // colors
        color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = sc.nextInt();
        }

        answer = new int[n];

        dfs(0); // assuming root = 0

        // output all answers
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
