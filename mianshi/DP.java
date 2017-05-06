package mianshi;



public class DP {
	//最长公共子序列
	public static void publicLengthest(String str1,String str2){
		int m=str1.length();
		int n=str2.length();
		int arr[][]=new int[m+1][n+1];
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		for(int i=1;i<char1.length+1;i++){
			for(int j=1;j<char2.length+1;j++){
				if(char1[i-1]==char2[j-1]){
					arr[i][j]=arr[i-1][j-1]+1;
				}else{
					arr[i][j]=arr[i-1][j]>arr[i][j-1]?arr[i-1][j]:arr[i][j-1];
				}
			}
		}
		int i=m,j=n;
		while(i>0&&j>0){
				if(arr[i][j]!=arr[i-1][j]&&arr[i][j]!=arr[i][j-1]){
					System.out.println(arr[i][j]+" "+i+" "+j+" "+char1[i-1]);
					i--;j--;
				}else{
					if(arr[i][j]==arr[i-1][j]){
						i--;
					}else{
						j--;
					}
				}
		}
	}
	public static void main(String[] args) {
		DP.publicLengthest("11sd11sd11s1", "111sd1sd111sd111");
	}
}

