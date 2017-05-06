package mianshi;

import org.junit.Test;

public class PaiXu {
	
	//冒泡排序 平均O(n^2) 最好O(n) 最差O(n^2)
	static int count2=1;
	public void maopao(){
		int[] arr={12,11,56,84,1,5,6,8,4,16};
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]>arr[j]){
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			for(int a=0;a<arr.length;a++){
				System.out.println(arr[a]+" ");
			}
		    }
	
	//快速排序 平均O(nlogn) 最好O(nlogn) 最坏O(n^2)  
	public static void kuaisu(int [] arr,int start1,int end1){
		int s=start1;
		int e=end1;
		int v=arr[start1];
		while(s<e){
			while(s<e&&v<arr[e]){
				e--;
			}
			if(s<e){
				int temp=arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
			s++;
			}
			while(s<e&&v>arr[s]){
				s++;
			}
			if(s<e){
				int temp=arr[e];
			arr[e]=arr[s];
			arr[s]=temp;
			e--;
			}
		}
		/*System.out.print("第"+count2+"趟排序的结果为:");
		count2++;
		for(int a:arr)
		System.out.print(a+" ");
		System.out.println();*/
		if(s>start1){
			kuaisu(arr, start1, s-1);
		}
		if(e<end1){
			kuaisu(arr, e+1, end1);
		}
	}
	//选择排序(直接选择排序) 最好 O(n^2) 最坏 O(n^2) 平均 O(n^2)
	public static void xuanze(int[] arr){
		int v=0;
		int temp=0;
		int j=0;
		while(j<arr.length-1){
		for(int i=j+1;i<arr.length;i++){
			if(arr[v]>arr[i]){
				v=i;
			}
		}
		temp=arr[v];
		arr[v]=arr[j];
		arr[j]=temp;
		v=++j;
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
		}
	//选择排序(堆排序) 最好O(nlogn) 最坏O(nlogn) 平均O(nlogn)
	public static void dui(int []arr){
		int max=arr.length;
		for(int i=0;i<max-1;i++){
			//从最后一个节点的父节点开始
			for(int j=(max-i)/2-1;j>=0;j--){
				//记录父亲节点
				int k=j;
				//判断是否存在子节点
				while(2*k+1<=max-i-1){
					int big=2*k+1;
					if(2*k+2<=max-i-1){
						//判断子节点那个大
						if(arr[big]<arr[2*k+2])
							big++;
					}
					//比较父节点与最大子节点
					if(arr[k]<arr[big]){
						int temp=arr[k];
						arr[k]=arr[big];
						arr[big]=temp;
						k=big;
					}else{//如果子节点满足最大堆，则跳出此次循环
						break;
					}
				}
			}
			//第一次找出最大值，与最后一个值交换，然后i++，排除最大的那个值，剩下的数组在进行比较
			int temp1=arr[0];
			arr[0]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp1;
		}
	/*	for (int i : arr) {
			System.out.print(i+" ");
		}*/
	}
	//直接插入排序 最好O(n) 最坏O(n^2) 平均O(n^2)
	public static void charu(int arr[]){
		for(int i=1;i<arr.length;i++){//默认外层循环标识并决定待比较的数值。内层循环为待比较数值确定其最终位置
			int temp=arr[i];
			for(int j=i-1;j>=0;j--){
				if(arr[j]>temp){
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
		/*for (int i : arr) {
			System.out.print(i+" ");
		}*/
	}
	//希尔排序 平均O(n^1.3) 最坏O(n^2) 最好O(n)
	public static void shell(int arr[]){
		int len=arr.length;
		for(int l=len/2;l>0;l/=2){
			for(int i=l;i<len;i+=l){
				int temp=arr[i];
				for(int j=i-l;j>=0;j-=l){
					if(temp<arr[j]){
						arr[j+l]=arr[j];
						arr[j]=temp;
					}
				}
			}
		}
		/*for (int i : arr) {
			System.out.print(i+" ");
		}*/
	}
	public static void main(String[] args) {
		int[] arr={5,8,49,1,9,78,441,65,84,12,123,3,33};
		//PaiXu.kuaisu(arr, 0, 12);
//		int arr[]=new int[100000];//={5,8,49,1,9,78,441,65,84,12,123,3};
//		//PaiXu.xuanze(arr1);
//		//PaiXu.dui(arr1);
//		for(int i=0;i<100000;i++){
//			arr[i]=(int) (Math.random()*100000);
//		}
		long time = System.currentTimeMillis();
		//PaiXu.dui(arr);70秒
		PaiXu.shell(arr);//17秒
		PaiXu.fs(arr, 9);
		//PaiXu.kuaisu(arr, 0, 99999);//0.07秒百万级需要0.3到0.4秒左右
		//PaiXu.mergeSort(arr,0,999999);//0.07秒左右百万级需要0.5到0.6秒左右
		System.out.println(System.currentTimeMillis()-time);
//		for (int i : arr) {
//			System.out.print(i+" ");
//		}
	}
	
	 //归并排序 最好O(nlogn) 最坏O(nlogn) 平均O(nlogn)
	public static void mergeSort(int arr[],int left,int right){
			int mid=(left+right)/2;
			if(left<right){
				//对左边归并
				mergeSort(arr, left, mid);
				//对右边归并
				mergeSort(arr, mid+1, right);
				//合并归并
				merge(arr, left, mid, right);
			}
		}
	public static void merge(int arr[],int left,int mid,int right){
		//建立一个数组大小为right-left+1的临时数组
		int temp[]=new int[right-left+1];
		int l=left;
		int r=mid+1;
		int k=0;
		while(l<=mid&&r<=right){
			if(arr[l]<arr[r]){
				temp[k]=arr[l];
				l++;
			}else{
				temp[k]=arr[r];
				r++;
			}
			k++;
		}
		for(;l<=mid;l++){
			temp[k]=arr[l];
			k++;
		}
		for(;r<=right;r++){
			temp[k]=arr[r];
			k++;
		}
		//把新数组覆盖
		for(int k1=0;k1<temp.length;k1++){
			arr[k1+left]=temp[k1];
		}
	}
	//二分查找
	public static void binarySearch(int[] arr,int keyWord){
		int h=0;
		int l=arr.length-1;
		int mid=0;
		while(h<l){
			mid=(h+l)/2;
			if(arr[mid]>keyWord){
				l=mid-1;
			}else if(
				arr[mid]<keyWord
				){
				h=mid+1;
			}else{
				System.out.println(arr[mid]);
				break;
			}
		}
		System.out.println("没有找到");
	}
	//斐波那契查找(优化二分查找)
	public static void fs(int arr[],int keyWord){
		int h=0,l=arr.length,mid=0;
		while(h<l){
			mid=h+PaiXu.f(l-h);
			if(arr[mid]<keyWord){
				h=mid+1;
			}else if(arr[mid]>keyWord){
				l=mid-1;
			}else{
				System.out.println(arr[mid]);
			}
		}
	}
	//得到斐波那契数
	public static int f(int n){
		int f0=1,f1=1,result=0;
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}else{
			while(result<n){
				result=f0+f1;
				f0=f1;
				f1=result;
			}
			return result-f0;
		}
	}
}
