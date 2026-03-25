import java.util.*;
class Main{
	public static int max=1;
	public static void dfs(int parent[],int color[],Set<Integer> set,int root,int n)
	{
		if(set.size()>max) max=set.size();
		for(int j=1;j<=n;j++)
		{
			if(j!=root && parent[j]==root)
			{
				set.add(color[j]);
				dfs(parent,color,set,j,n);
				if(color[j]!=color[root]) set.remove(color[j]);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int parent[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			parent[i]=sc.nextInt();
		}
		int color[]=new int[n+1];
		for(int j=1;j<=n;j++)
		{
			color[j]=sc.nextInt();
		}
		int q=sc.nextInt();
		int arr[]=new int[n+1];
		Arrays.fill(arr,-1);
		int sum=0;
		for(int i=0;i<q;i++)
		{
			int root=sc.nextInt();
			if(arr[root]!=-1) sum=sum+arr[root];
			else
			{
				max=1;
				Set<Integer> set=new HashSet<>();
				set.add(color[root]);
				for(int j=1;j<=n;j++)
				{
					if(j!=root && parent[j]==root)
					{
						set.add(color[j]);
						dfs(parent,color,set,j,n);
						if(color[j]!=color[root]) set.remove(color[j]);
					}
				}
				arr[root]=max;
				sum=(sum+arr[root]);
			}
			System.out.print(sum+" ");
		}
	}
}
