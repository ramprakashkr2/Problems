import java.util.*;
class Main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=0;y<t;y++)
        {
            int n=sc.nextInt();
            int d=sc.nextInt();
            int egg[]=new int[n];
            int use[]=new int[n];
            for(int i=0;i<n;i++) egg[i]=sc.nextInt();
            for(int i=0;i<n;i++) use[i]=sc.nextInt();
            int k=0,day=0;
            for(int i=0;i<n;i++)
            {
                int val=use[i];
                while(val!=0)
                {
                    val--;
                    egg[k]--;
                    if(egg[k]==0) k++;
                }
                day++;
                if(day-k>d) k++;
            }
            int sum=0;
            for(int i=k;i<n;i++)
            {
                sum+=egg[i];
            }
            System.out.println(sum);
        }
    }
}
