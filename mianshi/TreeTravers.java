package mianshi;

import java.util.Stack;

//二叉树的六种遍历方式
public class TreeTravers {
		//1.递归
	//先序遍历
	public static void pre_traverse(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			pre_traverse(root.left);
			pre_traverse(root.right);
		}
	}
	//中序遍历
	public static void in_traverse(TreeNode root){
		if(root!=null){
			in_traverse(root.left);
			System.out.print(root.val+" ");
			in_traverse(root.right);
		}
	}
	//后序遍历
	public static void beh_traverse(TreeNode root){
		if(root!=null){
			beh_traverse(root.left);
			beh_traverse(root.right);
			System.out.print(root.val+" ");
		}
	}
	//非递归
	//先序遍历
	public static void preTraverse(TreeNode root){
		if(root!=null){
			Stack<TreeNode> stack=new Stack<>();
			stack.push(root);
			TreeNode t=root;
			while(!stack.isEmpty()){
				t=stack.pop();
				System.out.print(t.val+" ");
				if(t.right!=null){
					stack.push(t.right);
				}
				if(t.left!=null){
					stack.push(t.left);
				}
			}
		}
	}
	//先序遍历
		public static void preTraverse2(TreeNode root){
			Stack<TreeNode> stack=new Stack<>();
			TreeNode t=root;
			while(t!=null||!stack.isEmpty()){
				while(t!=null){
					stack.push(t);
					System.out.print(t.val+" ");
					t=t.left;
				}
				if(!stack.isEmpty()){
					t=stack.pop();
					t=t.right;
				}
			}
		}
	//中序遍历
	public static void inTraverse(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode t=root;
		while(t!=null||!stack.isEmpty()){
			while(t!=null){
			stack.push(t);
			t=t.left;
		}
		if(!stack.isEmpty()){
			t=stack.pop();
			System.out.print(t.val+" ");
			t=t.right;
		}
	}
	}
	//后序遍历
	public static void behTraverse2(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode t=root;
		TreeNode node=t;
		while(t!=null||!stack.isEmpty()){
			while(t!=null){
				stack.push(t);
				t=t.left;
			}
			t=stack.pop();
			while(t!=null&&(t.right==null||t.right==node)){
				System.out.print(t.val+" ");
				node=t;
				if(stack.isEmpty()){
					return;
				}
				t=stack.pop();
			}
			stack.push(t);
			t=t.right;
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		TreeNode l1=new TreeNode(1);
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
		r1.right=r3;
		r3.left=r2;
		r3.right=r4;
		//beh_traverse(root);
		behTraverse2(root);
	}
}
