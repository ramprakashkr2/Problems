/*
You need to build a road in a rugged terrain. You know the sea level of each segment of the rugged terrain, i.e. the i-th segment is Li meters from sea level.
You needs to transform the terrain into a strictly downward sloping terrain for the road, i.e, for each i-th segment where 2 <= i <= N, resultant Li - 1 > Li In order to do so, you employ a powerful digging team to help you dig and reduce the sea level of the segments. On day D, the team can reduce the sea level for each segments that you scheduled that day by 2D-1 meters each.
You are allowed to assign the team to dig on multiple segments and/or dig on the same segments for multiple days.
Your task is to find the minimum number of days needed to transform the terrain as per your requirements.
Parameters:
N :: INTEGER
The first line contains an integer, N, denoting the number of elements in L.
N:: 1 -> 10^5
L :: INTEGER ARRAY
Each line i of the N subsequent lines (where 0 < i <= N ) contains an integer describing Li, the sea level of the i-th segment.
L[i] ::-10^9-> 10^9
Case#: 1
Input:
2 3 3
Output: 1
We can dig on the 2nd segment, reducing it from 3-meter sea level to 2. Resulting in {3, 2} which is strictly decreasing.
Case#: 2
Input: 2
5
-3
Output: 0
*/

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
