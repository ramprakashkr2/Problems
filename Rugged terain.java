import java.util.*;

public class Main {

    static boolean canMake(long[] L, long D) {
        long maxReduce = D * D;
        long prev = Long.MAX_VALUE;

        for (int i = 0; i < L.length; i++) {
            long curr = Math.min(L[i], prev - 1);
            long needed = L[i] - curr;

            if (needed > maxReduce) return false;

            prev = curr;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] L = new long[n];

        for (int i = 0; i < n; i++) {
            L[i] = sc.nextLong();
        }

        long low = 0, high = 100000, ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canMake(L, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
