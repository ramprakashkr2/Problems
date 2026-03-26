// to get 1 element from each rown but cannot take the element from the below of already taken element
import java.util.*;
class Main{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[][]=new int[n+1][n];
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		int dp[][]=new int[n+1][n];
		int max[][]=new int[n+1][2];
		int maximum=0;
		for(int i=1;i<=n;i++)
		{
			int max1=0,max2=0;
			int pmax1=max[i-1][0],pmax2=max[i-1][1];
			for(int j=0;j<n;j++)
			{
				int above=dp[i-1][j];

				if(above==pmax1) dp[i][j]=arr[i][j]+pmax2;
				else dp[i][j]=arr[i][j]+pmax1;
					
				if(dp[i][j]>max1)
				{
					max2=max1;
					max1=dp[i][j];
				}
				else if(arr[i][j]>max2) max2=dp[i][j];
				
				if(i==n && dp[i][j]>maximum) maximum=dp[i][j];
			}
			max[i][0]=max1;
			max[i][1]=max2;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("maximumm : "+maximum);
	}
}
