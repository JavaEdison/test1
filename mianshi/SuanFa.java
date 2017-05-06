package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class SuanFa {
	public static int fibonacci(int key){
		int f0=1,f1=1,temp=0;
		if(key==1&&key==2){
			return f0;
		}else{
			for(int i=3;i<=key;i++){
				 temp=f1;
				 f1=f0+f1;
				 f0=temp;
			}
			return f1;
		}
	}
	public static void main(String[] args) {
		//System.out.println(SuanFa.fibonacci(7));
		TreeNode root=new TreeNode(5);
		TreeNode l1=new TreeNode(1);
		TreeNode l=new TreeNode(0);
		TreeNode ll=new TreeNode(-1);
		TreeNode l2=new TreeNode(2);
		TreeNode l3=new TreeNode(3);
		TreeNode l4=new TreeNode(4);
		TreeNode r1=new TreeNode(6);
		TreeNode r2=new TreeNode(7);
		TreeNode r3=new TreeNode(8);
		TreeNode r4=new TreeNode(9);
		root.left=l3;
		root.right=r1;
		l3.left=l1;
		l3.right=l4;
		l1.right=l2;
		l1.left=ll;
		ll.left=l;
		r1.right=r3;
		r3.left=r2;
		r3.right=r4;
		SuanFa suanFa = new SuanFa();
		//suanFa.FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, new int[1], new int[1]);
		//suanFa.FindContinuousSequence(15);
		suanFa.LeftRotateString("I AM A STUDENT.", 3);
		suanFa.ReverseSentence("I am a student.");
		//suanFa.GetNumberOfK(new int[]{3}, 3);
		//System.out.println(suanFa.TreeDepth(root));
		//System.out.println(suanFa.IsBalanced_Solution(root));
		//suanFa.FindPath(root, 22);
		//suanFa.Convert(root);
		//suanFa.Permutation("abcdef");
		suanFa.isContinuous(new int[]{0,0,0,0,5});
		//System.out.println(suanFa.MoreThanHalfNum_Solution(new int[]{1,3,4,5,2,2,2,2,2}));
		//ArrayList<Integer> arrays = suanFa.GetLeastNumbers_Solution(new int[]{1,3,4,5,2,2,2,2,2}, 5);
//		for (Integer integer : arrays) {
//			System.out.println(integer);
//		}
		//System.out.println(suanFa.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
	//System.out.println(suanFa.NumberOf1Between1AndN_Solution(13));
		//suanFa.PrintMinNumber(new int[]{3,32,321,5,82,1});
		//System.out.println(suanFa.Sum_Solution(1000000));
	}//{4,4,6,6,6,5}
	//扑克牌顺子 
	public boolean isContinuous(int [] numbers) {
		if(numbers.length!=5)return false;
		int len=numbers.length;
		heapSort(numbers, len);
		if(numbers[0]<0||numbers[0]>13||numbers[4]>13)return false;
		int num0=0;
		int result=1;
		int temp=0;
		for(int i=0;i<len-1;i++){
			if(numbers[i]==0){
				num0++;
			}else{
				if(temp==0){
					temp=numbers[i];
				}
				if(numbers[i+1]-temp==1){
					result++;
					temp=numbers[i+1];
				}else{
					if(num0>0){
						num0--;
						result++;
						temp++;
						i--;
					}else{
						break;
					}
				}
			}
		}
		if(num0==4||result==5)return true;else return false;	
	}
	//练习排序(堆排序)
	public void heapSort(int arr[],int len){
		for(int i=0;i<len;i++){
			for(int j=(len-i)>>1-1;j>=0;j--){
				int k=j;
				while(2*k+1<len-i){
					int big=2*k+1;
					if(2*k+2<len-i){
						if(arr[2*k+2]>arr[big]){
							big++;
						}
					}
					if(arr[big]>arr[k]){
						int temp=arr[big];
						arr[big]=arr[k];
						arr[k]=temp;
						k=big;
					}else{
						break;
					}
				}
			}
			int te=arr[0];
			arr[0]=arr[len-i-1];
			arr[len-i-1]=te;
		}
	}
	//翻转单词顺序
	public String ReverseSentence(String str) {
        if(str==null)return str;
        char[] c=str.toCharArray();
        int start=0;
        for(int i=0;i<c.length;i++){
        	if(c[i]==' '){
        		rotateString(c, start, i-1);
        		start=i+1;
        	}else if(i==c.length-1){
        		rotateString(c, start, i);
        	}
        }
        rotateString(c, 0, c.length-1);
        return c.toString();
    }
	//左旋转字符串 
	public String LeftRotateString(String str,int n) {
        if(str==null||str.length()<=n||n==0)return str;
        char[] arr = str.toCharArray();
        rotateString(arr, 0, n-1);
        rotateString(arr, n, arr.length-1);
        rotateString(arr, 0, arr.length-1);
        str=arr.toString();
        return str;
    }
	public void rotateString(char[] arr,int s,int e){
		//int e=e1;
		if(s!=e){
			int t=((e-s)/2+s);
		for(int i=s;i<=t;i++,e--){
			char temp=arr[i];
			arr[i]=arr[e];
			arr[e]=temp;
		}
		}
	}
	
	//和为S的两个数字
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>();
		if(array.length<2)return list;
		int start=0,end=array.length-1,min=Integer.MAX_VALUE;
		int temp=0;
		while(start<end){
			temp=array[start]+array[end];
			if(temp<sum){
				start++;
			}else if(temp>sum){
				end--;
			}else{
					if(min>array[start]*array[end]){
						min=array[start]*array[end];
						list.add(0, array[start]);
						list.add(1, array[end]);
					}
				start++;
				end--;
			}
		}
		return list;
    }
	
	//和为S的连续正数序列
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if(sum<3)return arrayList;   
		int len=(sum+1)>>1;
		int s=1,e=2;
		int su=s+e;
		while(s<e&&e<=len){
			if(su<sum){
				su+=(++e);
			}else if(su>sum){
				su-=s;
				s++;
			}else{
				ArrayList<Integer> arr=new ArrayList<>();
				for(int i=s;i<=e;i++){
					arr.add(i);
				}
				arrayList.add(arr);
				su+=(++e);
				su-=s;
				s++;
			}
		}
		return arrayList;
    }
	
	//数组中只出现一次的数字 
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	     if(array.length==0&&array.length%2!=0)return;
	     int result=0;
	     for(int i=0;i<array.length;i++){
	    	 result=result^array[i];
	     }
	     int temp=result;
	     int num=1;
	     while(temp!=1){
	    	 num=num<<1;//乘以2
	    	 temp=temp>>1;//除以2
	     }
	     for(int i=0;i<array.length;i++){
	    	 if((array[i]&num)==0){
	    		 num1[0]=num1[0]^array[i];
	    	 }else{
	    		 num2[0]=num2[0]^array[i];
	    	 }
	     }
	}
	
	
	//判断二叉树是否是平衡二叉树
	int num1=0,result1=0,treenum=Integer.MAX_VALUE;
	public boolean IsBalanced_Solution(TreeNode root) {
        boolean flag=true;
        if(root!=null){
        TreeH(root);
        if(root.right==null)treenum=0;
        if(result1-treenum>1){
        	flag=false;
        }
        }
        return flag;
    }
	public void TreeH(TreeNode root){
		if(root!=null){
			num1++;
			if(root.left!=null){
				TreeH(root.left);
			}
			if(root.right!=null){
				TreeH(root.right);
			}
			if(root.right==null&&root.left==null){
				if(num1>result1)result1=num1;
				if(num1<treenum)treenum=num1;
					num1--;
				}else{
					num1--;
				}
		}
	}
	
	//二叉树的深度 
	int result=0;
	int num=0;
	public int TreeDepth(TreeNode root) {
        if(root!=null){
        	num++;
        	if(root.left!=null){
        		TreeDepth(root.left);
        	}
        	if(root.right!=null){
        		TreeDepth(root.right);
        	}
        	if(root.left==null&&root.right==null){
        		if(num>result)result=num;
        		num--;
        	}else{
        		num--;
        	}
        }
        return result;
    }	
	//数字在排序数组中出现的次数 
	public int GetNumberOfK(int [] array , int k) {
		boolean flag=false;
		if(array==null||array.length<=0)return 0;
        if(array[0]>array[array.length-1]) flag=true;
        if(flag){
        	if(k>array[0]||k<array[array.length-1]){
        		return 0;
        	}
        }else{
        	if(k<array[0]||k>array[array.length-1]){
        		return 0;
        	}
        }
       int result = binallyS(array, k, flag);
       int temp=result;
       int result1=0;
       if(result==-1)return 0;
       while(result>=0){
    	   if(array[result--]==k){
    		   result1++;
    	   }else{
    		   break;
    	   }
       }
       while(temp<array.length){
    	   if(array[temp++]==k){
    		   result1++;
    	   }else{
    		   break;
    	   }
       }
		return result1;
    }
	public int binallyS(int[] arr,int k,boolean flag){
		int s=0,e=arr.length-1;
		int mid=0;
		while(s<=e){
			mid=(s+e)>>1;
			if(k>arr[mid]){
				if(flag){
					e=mid-1;
				}else{
					s=mid+1;
				}
			}else if(k<arr[mid]){
				if(!flag){
					e=mid-1;
				}else{
					s=mid+1;
				}
			}else{
				return mid;
			}
		}
	 return -1;
	}
	
	//两个链表的第一个公共结点
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null)return pHead1;
		if(pHead2==null)return pHead2;
		int p1=0,p2=0;
		 ListNode h1=pHead1,h2=pHead2;
		 while(h1!=null){
			 p1++;
			 h1=h1.next;
		 }
		 while(h2!=null){
			 p2++;
			 h2=h2.next;
		 }
		 if(p1>p2){
			 int temp=p1-p2;
			 while(temp!=0){
				 pHead1=pHead1.next;
				 temp--;
			 }
		 }else{
			 int temp=p1-p2;
			 while(temp!=0){
				 pHead2=pHead2.next;
				 temp--;
			 }
		 }
		 while(pHead1!=pHead2){
			 pHead1=pHead1.next;
			 pHead2=pHead2.next;
		 }
		 return pHead1;
    }
	
	//数组中的逆序对
	int a=0;
    public  int InversePairs(int [] array) {
        if(array!=null&&array.length>=0)
        merges(array,0,array.length-1);
        return a;
    }
    
    public  void merges(int[] arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            //对左边归并
            merges(arr, start, mid);
            //对右边归并
            merges(arr, mid+1, end);
            //合并归并好的数组
            merge(arr, start,mid,end);
        }
    }
    public  void merge(int arr[],int start,int mid,int end){
        int s=mid,e=end;
        int[] temp=new int[end-start+1];
        int k=temp.length-1;
        while(s>=start&&e>mid){
            if(arr[s]>arr[e]){
                a+=(e-mid);
                a%=1000000007;
                temp[k--]=arr[s--];
            }else{
                temp[k--]=arr[e--];
            }
        }
        for(;s>=start;s--){
            temp[k--]=arr[s];
        }
        for(;e>mid;e--){
            temp[k--]=arr[e];
        }
        for(k=0;k<temp.length;k++){
            arr[start+k]=temp[k];
        }
    }
	
	//第一个只出现一次的字符 
	public int FirstNotRepeatingChar(String str) {
     if(str.length()==0||str==null)return -1;
     char[] charArray = str.toCharArray();
     LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
     for (char c : charArray) {
		if(map.containsKey(c)){
			map.put(c, map.get(c)+1);
		}else{
			map.put(c, 1);
		}
	}
     int result=0;
    Set<Character> keySet = map.keySet();
    for (Character character : keySet) {
    	if(map.get(character)==1){
			for (Character ch : charArray) {
				if(ch==character){
					return result;
				}
				result++;
			}
		}
	}
		return -1;
    }

	//丑数 
	public int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> list=new ArrayList<>();
        if(index>0){
        	list.add(1);
        	int i1=0,i2=0,i3=0;
        	int m1=0,m2=0,m3=0,min=0;
        	while(list.size()<index){
        		if(m1==0)m1=list.get(i1)*2;
        		if(m2==0)m2=list.get(i2)*3;
        		if(m3==0)m3=list.get(i3)*5;
        		min=Math.min(m1, Math.min(m2, m3));
        		list.add(min);
        		if(min==m1){i1++;m1=0;}
        		if(min==m2){i2++;m2=0;}
        		if(min==m3){i3++;m3=0;}
        	}
        	return list.get(index-1);
        }
		return 0;
    }
	//滑动窗口的最大值 
	 public ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
		 ArrayList<Integer> cnt=new ArrayList<>();
		 if(size==0)return cnt;
		 if(num.length<=0||num==null)return cnt;
		 int begin;
		 LinkedList<Integer> queue=new LinkedList<>();
		 for(int i=0;i<num.length;i++){
			 //过期标记
			 begin=i-size+1;
			 if(queue.isEmpty())queue.add(i);
			 //如果begin大于queue中第一个(也就是目前最大的数),说明此数不在这次的滑动窗口中，那就移除
			 if(begin>queue.peekFirst()) queue.pollFirst();
			 //从队列最后一个算起，循环判断队列中的数是否小于将要加入的数，是就说明队列中的数无法在做滑动窗口的最大值了。则移除
			 while(!queue.isEmpty()&&num[queue.peekLast()]<=num[i])
				 queue.pollLast();
			 //加入新加入的值，因为他没有与之后的数进行比较，他还有可能成为滑动窗口的最大值
			 queue.add(i);
			 //begin大于等于零时，此时已有滑动窗口最大值被发现，则加入
			 if(begin>=0)
				 cnt.add(num[queue.peekFirst()]);
				 
		 }
	        return cnt;
	    }
	 
	 
	//求1+2+3+...+n 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
	 public int Sum_Solution(int n) {
		 int sum=n;
		 //&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
		 boolean i = sum>0 && (sum+=Sum_Solution(sum-1))>0;
		 return sum;
	   }
	 
	 
	 
	
	//把数组排成最小的数 
	public String PrintMinNumber(int [] numbers) {
		StringBuilder result=new StringBuilder();
		if(numbers==null||numbers.length==0)return result.toString();
		ArrayList<Integer> arrList=new ArrayList<>();
		for(int i=0;i<numbers.length;i++){
			arrList.add(numbers[i]);
		}
		Collections.sort(arrList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String str1=o1+""+o2;
				String str2=o2+""+o1;
				return str1.compareTo(str2);//两两对比例如32 和 3 323<332 所以 32排在前面
			}
		});
		for (Integer integer : arrList) {
			result.append(integer);
		}
		return result.toString();
    }
	
	
	
	//整数中1出现的次数（从1到n整数中1出现的次数） 
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;//1的个数
		int i = 1;//当前位
		int current = 0,after = 0,before = 0;
		while((n/i)!= 0){           
		current = (n/i)%10; //高位数字
		before = n/(i*10); //当前位数字
		after = n-(n/i)*i; //低位数字
		//如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
		if (current == 0)
		count += before*i;
		//如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
		else if(current == 1)
		count += before * i + after + 1;
		//如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
		else{
		count += (before + 1) * i;
		}    
		//前移一位
		i = i*10;
		}
		return count;
		}
	
	
	
	//连续子数组的最大和
	public int FindGreatestSumOfSubArray(int[] array) {
		//b代表前面序列的和
		int b=0;
		int sum=0;
		for(int i=0;i<array.length;i++){
			//只有当前面的序列大于零才加这数
			if(b>0) b+=array[i];
			//如果前面序列小于零则没有必要加，直接跳到下一个数。加一个大于零的数才会大于本身
			else b=array[i];
			if(b>sum) sum=b;
			if(i==0) sum=b;
		}
        return sum;
    }
	
	
	
	//最小的K个数 (基于堆排序)
	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int f) {
		 ArrayList<Integer> arraylist=new ArrayList<>();
		 if(arr.length==0||arr==null)return arraylist;
		 int length=arr.length;
		 if(length<f){f=length;}
		 for(int i=0;i<f;i++){
			 for(int j=(length-i)/2-1;j>=0;j--){
				 int k=j;
				 while(2*k+1<length-i){
					 int less=2*k+1;
					 if(2*k+2<length-i){
						 if(arr[less]>arr[2*k+2]){
							 less++;
						 }
					 }
					 if(arr[k]>arr[less]){
						 int temp=arr[k];
						 arr[k]=arr[less];
						 arr[less]=temp;
						 k=less;
					 }else{
						 break;
					 }
				 }
			 }
			 int temp=arr[0];
			 arr[0]=arr[length-i-1];
			 arr[length-i-1]=temp;
			 arraylist.add(arr[length-i-1]);
		 }
		 return arraylist;   
	    }
	
	 
	//数组中出现次数超过一半的数字 （基于快排）
	public int MoreThanHalfNum_Solution(int [] array) {
		if(array.length==0||array==null)return 0;
		quickly(array, 0, array.length-1);
		int temp=array[array.length/2];
		int len=0;
		for (int i : array) {
			if(i==temp){
				len++;
			}
		}
		if(len>array.length/2){
			return temp;
		}else
		return 0;
    }
	public void quickly(int []arr,int start,int end){
		int s=start,e=end;
		int temp=arr[start];
		int t;
		while(s<e){
			while(s<e&&temp<arr[e])e--;
			if(s<e){
				t=arr[e];
				arr[e]=arr[s];
				arr[s]=t;
				s++;
			}
			while(s<e&&temp>arr[s]) s++;
			if(s<e){
				t=arr[e];
				arr[e]=arr[s];
				arr[s]=t;
				e--;
			}
		}
		if(s>start){
			quickly(arr, start, s-1);
		}
		if(e<end){
			quickly(arr,s+1,end);
		}
		
	}
	
	
	//字符串的全排列
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> a=new ArrayList<>();
	    if(str.equals("")||str==null){return a;}   
		char[] tochar = str.toCharArray();
		TreeSet<String> hash=new TreeSet<>();//用hashset取出来时无序的，所以选择treeset
	       getPer(tochar,0,tochar.length-1,hash);
	       for (String string : hash) {
			a.add(string);
		}
	       return null;//a;
    }
	private void getPer(char[] tochar, int start, int end,TreeSet<String> hash) {
		// TODO Auto-generated method stub
		
		if(start==end){
			hash.add(String.valueOf(tochar));
		}else{
		for(int i=start;i<=end;i++){
			swap(tochar,i,start);
			getPer(tochar, start+1, end,hash);
			swap(tochar, i, start);
		}
		}
	}
	private void swap(char[] tochar, int i, int start) {
		// TODO Auto-generated method stub
		if(i!=start){
			char temp=tochar[i];
			tochar[i]=tochar[start];
			tochar[start]=temp;
		}
	}
	
	
	//二叉搜索树与双向链表 （错误答案）
	 public TreeNode Convert(TreeNode root) {
		 if(root==null) return null;
		 Stack<TreeNode> stack=new Stack<>();
		 return Converts(root, stack);
	    }
	 public TreeNode Converts(TreeNode root,Stack<TreeNode> stack){
		 TreeNode t=root;
		 TreeNode pre=null;
		 while(t!=null||!stack.isEmpty()){
			 while(t!=null){
				 stack.push(t);
				 t=t.left;
			 }
			 if(!stack.isEmpty()){
				 t=stack.pop();
				 if(pre==null){pre=t;}
				 else if(t.left==pre){
					 pre.right=t;
				 }else if(pre.right==t){
					 t.left=pre;
				 }else{
					 t.left=pre;
					 pre.right=t;
				 }
				 pre=t;
				 t=t.right;
			 }
		 }
		 return pre;
	 }
	
	 
	 //二叉树中和为某一值的路径
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		//ArrayList<Integer> list = new ArrayList<Integer>();
		public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
			Stack<TreeNode> stack =new Stack<>();
		    return new SuanFa().FindPath1(root,target,stack,0);
		}
		public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target,Stack<TreeNode> stack,int temp) {
			if(root!=null){
				stack.push(root);
				temp+=root.val;
				if(root.left!=null){
					FindPath1(root.left, target, stack, temp);
				}
				if(root.right!=null){
					FindPath1(root.right, target, stack, temp);
				}
				if(root.right==null&&root.left==null){
					if(temp==target){
						//找到一条路径
						ArrayList<Integer> a=new ArrayList<>();
						for(int i=0;i<stack.size();i++){
							a.add(stack.get(0).val);
						}
						listAll.add(a);
					}
						temp-=stack.pop().val;
				}else{
					temp-=stack.pop().val;
				}
			}
			return listAll;
		}
	
		
		
		//判断一个后序序列是否是一个二叉树的后序序列
	public static boolean isBackSeq(int[] arr,int start,int end){
		int temp=-1;
		if(start<end){
			for(int i=start;i<end;i++){
				if(arr[i]>arr[end-1]){
					temp=i;
					break;
				}
			}
			if(temp==-1){
				return true;
			}
			for(int j=temp;j<end;j++){
				if(arr[j]<arr[end-1]){
					return false;
				}
			}
		}else{
			return true;
		}
		return isBackSeq(arr, start, temp)&&isBackSeq(arr, temp+1, end-1);
	}
	
	
	//前序遍历
	public static void shenduyouxian(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		if(root!=null){
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode r = stack.pop();
				System.out.println(r.val);
				if(r.right!=null) stack.push(r.right);
				if(r.left!=null) stack.push(r.left);
			}
		}
	}
	
	
	//从上往下打印出二叉树的每个节点，同层节点从左至右打印
	public static void printTree(TreeNode root){
		Queue<TreeNode> q=new LinkedList<>();
		if(root!=null){
			q.offer(root);
			while(!q.isEmpty()){
				TreeNode t=q.poll();
				if(t.left!=null){
					q.offer(t.left);
				}
				if(t.right!=null){
					q.offer(t.right);
				}
				System.out.println(t.val);
			}
		}
	}
	
	
	//重构二叉树
	public static TreeNode resetTwoTree(int pre[],int in[]){
		return reset(pre,0,pre.length-1,in,0,in.length-1);
	}
	private static TreeNode reset(int[] pre, int spre, int epre, int[] in, int sin, int ein) {
		// TODO Auto-generated method stub
		if(spre>epre||sin>ein){
			return null;
		}
		TreeNode root=new TreeNode(pre[spre]);
		for(int i=sin;i<=ein;i++){
			if(in[i]==pre[spre]){
				root.left=reset(pre, spre+1, i+spre-sin, in, sin, i-1);
				root.right=reset(pre, i+spre-sin+1, epre, in, i+1, ein);
			}
		}
		return root;
	}
}
class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
