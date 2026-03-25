import java.util.*;
public class Main{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Queue<Integer> a=new PriorityQueue<>();
		Queue<Integer> b=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++) a.add(sc.nextInt());
		for(int j=0;j<n;j++) b.add(sc.nextInt());
		int ans=0,mod=1000000007;
		for(int i=0;i<n;i++)
		{
			int z=a.poll();
			while(z!=0)
			{
				ans=((ans*2)+1)%mod;
				z--;
			}
			int o=b.poll();
			while(o!=0)
			{
				ans=(ans*2)%mod;
				o--;
			}
		}
		System.out.print(ans);
	}
}
