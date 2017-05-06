package mianshi;

public class Sortpractice {
	//时间复杂度 最好O(n) 平均O(n^2) 最差O(n^2)
	public static void bubbleSort(int []arr){
		int len =arr.length;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	//时间复杂度 最好O(nlogn) 平均O(nlogn) 最差O(n^2)
	public static void quicklySort(int arr[],int start,int end){
		int s=start,e=end,temp=arr[start];
		while(s<e){
			while(s<e&&temp<=arr[e]){
				e--;
			}
			if(s<e){
				int t=arr[s];
				arr[s]=arr[e];
				arr[e]=t;
				
				s++;
			}
			while(s<e&&temp>=arr[s]){
				s++;
			}
			if(s<e){
				int t=arr[e];
				arr[e]=arr[s];
				arr[s]=t;
				e--;
			}
		}
		if(s>start){
			quicklySort(arr, start, s);
		}
		if(e<end){
			quicklySort(arr, e+1, end);
		}
		
			for (int i : arr) {
				System.out.print(i+" ");
			}
		System.out.println();
	}
	//直接选择排序 最好O(n^2) 最差O(n^2) 平均O(n^2)
	public static void selectSort(int arr[]){
		int t=0,temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[t]>arr[j]){
					t=j;
				}
			}
			if(t!=i){
				temp=arr[i];
				arr[i]=arr[t];
				arr[t]=temp;
				}
			t=i+1;
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	//堆排序 最好O(nlogn) 最差O(nlogn)平均O(nlogn)
	public static void heapSort(int arr[]){
		int len=arr.length;
		for(int i=0;i<len;i++){
			for(int j=(len-i)/2-1;j>=0;j--){
				int k=j;
				while(2*k+1<=len-i-1){
					int big=2*k+1;
					if(2*k+2<=len-i-1){
						if(arr[2*k+2]>arr[big]){
							big++;
						}
					}
					if(arr[big]>arr[k]){
						int temp=arr[k];
						arr[k]=arr[big];
						arr[big]=temp;
						k=big;
					}else{
						break;
					}
				}
			}
			int temp=arr[0];
			arr[0]=arr[len-i-1];
			arr[len-i-1]=temp;
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	//插入排序 最好O(n) 最坏O(n^2) 平均O(n^2)
	public static void insertSort(int arr[]){
		int len=arr.length;
		for(int i=1;i<len;i++){
			int temp=arr[i];
			for(int j=i-1;j>=0;j--){
				if(temp<arr[j]){
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	//希尔排序 最好O(n) 平均O(n^1.3) 最差O(n^2)
	public static void shellSort(int[] arr){
		int len=arr.length;
		for(int l=len/2;l>0;l/=2){
			for(int i=l;i<len;i+=l){
				int temp=arr[i];
				for(int j=i-l;j>=0;j-=l){
					if(arr[j]>temp){
						arr[j+l]=arr[j];
						arr[j]=temp;
					}
				}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	//归并排序 最好O(nlogn) 最差O(nlogn) 平均O(nlogn)
	public static void mergeSort(int arr[],int start,int end){
		int mid=(start+end)/2;
		if(start<end){
			//对左边归并
			mergeSort(arr, start, mid);
			//对右边归并
			mergeSort(arr, mid+1, end);
			//归并排序
			merge(arr,start,mid,end);
			if(start==0&&end==arr.length-1){
				for (int i : arr) {
					System.out.print(i+" ");
				}
			}
		}
	}
	private static void merge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int temp[]=new int[end-start+1];
		int s=start,e=mid+1,k=0;
		while(s<=mid&&e<=end){
			if(arr[s]<arr[e]){
				temp[k++]=arr[s++];
			}else{
				temp[k++]=arr[e++];
			}
		}
		for(;s<=mid;s++){
			temp[k++]=arr[s];
		}
		for(;e<=end;e++){
			temp[k++]=arr[e];
		}
		for(k=0;k<temp.length;k++){
			arr[start+k]=temp[k];
		}
	}
	public static void main(String[] args) {
		int[] arr={4,9,2,1,6,5,8,7,0};
		//冒泡排序
		//Sortpractice.bubbleSort(arr);
		//快速排序
		 //Sortpractice.quicklySort(arr, 0, 9);
		//选择排序
		//Sortpractice.selectSort(arr);
		//堆排序
		//Sortpractice.heapSort(arr);
		//插入排序
		//Sortpractice.insertSort(arr);
		//希尔排序
		//Sortpractice.shellSort(arr);
		//归并排序
		//Sortpractice.mergeSort(arr, 0, 8);
		findKByArray(arr, 1, 0, 8);
	}
	//数组第K大的数
	public static void findKByArray(int arr[],int k,int start,int end){
		int s=start,e=end;
		int temp=arr[start];
		while(s<e){
			while(s<e&&temp>arr[e]){
				e--;
			}
			if(s<e){
				int t=arr[s];
				arr[s]=arr[e];
				arr[e]=t;
				s++;
			}
			while(s<e&&temp<arr[s]){
				s++;
			}
			if(s<e){
				int t=arr[s];
				arr[s]=arr[e];
				arr[e]=t;
				e--;
			}
		}
		if(k<s){
			findKByArray(arr, k, start, s);
		}else if(k>s){
			findKByArray(arr, k, s+1, end);
		}else{
			for(int i=0;i<=k;i++){
				System.out.print(arr[i]+" ");
			}
		}
	} 
}
