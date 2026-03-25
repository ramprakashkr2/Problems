import java.util.*;
public class Main{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int index[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			index[i]=-1;
		}
		int q=sc.nextInt();
		int query[][]=new int[q][4];
		for(int i=0;i<q;i++)
		{
			for(int j=0;j<4;j++)
			{
				query[i][j]=sc.nextInt();
			}
		}
		List<Integer> l=new ArrayList<>();
		List<Integer> r=new ArrayList<>();
		for(int i=q-1;i>=0;i--)
		{
			int st=query[i][0],en=query[i][1];
			int x=query[i][2],y=query[i][3];
			int check=0;
			int tempst=st,tempen=en;
			int c=li.size();
			for(int j=st;j<=en;j++)
			{
				if(val[j]==-1)
				{
					arr[j]=x+(j-st)*y;
					val[j]=c;
				}
				else c=val[j];
			}
		}
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
		}
		System.out.print(sum);
	}
}
