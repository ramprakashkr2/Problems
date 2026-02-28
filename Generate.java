import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l = s.length();
        for (int i=1;i<(1<<l);i++) 
        {
            int t=i;
            for(int j=0;j<l;j++)
            {
                if((t&1)==1)
                {
                    System.out.print(s.charAt(j));
                }
                t=t>>1;
            }
            System.out.println();
        }
    }
}
