import java.util.*;
class Main{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int arr[][]=new int[a][b];
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1;i<b;i++) arr[0][i]+=arr[0][i-1];
		for(int i=1;i<a;i++) arr[i][0]+=arr[i-1][0];
		
		for(int i=1;i<a;i++)
		{
			for(int j=1;j<b;j++)
			{
				arr[i][j]=arr[i][j]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
			}
		}
		
		System.out.print(arr[a-1][b-1]);
	}
}
