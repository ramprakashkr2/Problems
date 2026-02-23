import java.util.*;
class Main{
    public static int max=0;
    public static void dfs(int hash[][],int count,int c)
    {
        if(count>max) max=count;
        for(int i=0;i<26;i++)
        {
            if(hash[c][i]!=0)
            {
                hash[c][i]--;
                dfs(hash,count+1,i);
                hash[c][i]++;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s[]=new String[n];
        int hash[][]=new int[26][26];
        
        for(int i=0;i<26;i++) Arrays.fill(hash[i],0);
        
        for(int i=0;i<n;i++)
        {
            s[i]=sc.nextLine();
            char f=s[i].charAt(0);
            int l=s[i].charAt(s[i].length()-1);
            hash[(int)f-97][(int)l-97]++;
        }
        
        char ch=sc.next().charAt(0);
        
        dfs(hash,0,(int)ch-97);
        
        System.out.print(max);
    }
    
}
