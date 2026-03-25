import java.util.*;
class Main{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		char s[]=sc.nextLine().toCharArray();
		int arr1[]=new int[26];
		int arr2[]=new int[26];
		int sum=0;
		arr1[(int)s[0]-97]++;
		for(int j=2;j<s.length;j++)
		{
			arr2[(int)s[j]-97]++;
		}
		for(int i=1;i<s.length-1;i++)
		{
			for(int j=0;j<26;j++)
			{
				int min=arr1[j]*arr2[j];
				sum+=min;
			}
			arr1[(int)s[i]-97]++;
			arr2[(int)s[i+1]-97]--;
		}
		System.out.print(sum);
	}
}
