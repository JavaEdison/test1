package com.zjf.thread;
/*
 * semaphore ʵ�������������߶���
 */
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class ThreadTools {
	static final Semaphore semaphore=new Semaphore(1);
	static CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
	class Productor implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true){
				semaphore.acquire();
				while(list.size()<10){
					list.add(1);
					System.out.println("�����߷���һ����Ʒ��Ŀǰ��"+list.size()+"����Ʒ");
				}
				System.out.println("������"+"�ȴ�����������");
				semaphore.release();
				Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class Consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					semaphore.acquire();
					while(!list.isEmpty()){
						list.remove(0);
						System.out.println("����������һ����Ʒ��Ŀǰ��ʣ"+list.size()+"����Ʒ");
					}
					System.out.println("���п�,�ȴ�����������");
					semaphore.release();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void userSemaphore(){
		for(int i=0;i<20;i++){
			Thread t=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						System.out.println("���һ���ź������߳�"+Thread.currentThread().getName()+"׼��ִ����....");
						Thread.sleep(100);
						System.out.println("�߳�"+Thread.currentThread().getName()+"ִ�����");
						semaphore.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t.start();
		}
	}
	public static void main(String[] args) {
		ThreadTools ttt=new ThreadTools();
		// TODO Auto-generated method stub
		Productor p=ttt.new Productor();
		Consumer con=ttt.new Consumer();
		Thread tt=new Thread(p);
		Thread tt1=new Thread(con);
		tt.start();
		tt1.start();
	}

}
