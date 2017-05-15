package com.zjf.thread;
/*
 * semaphore 实现消费者生产者队列
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
					System.out.println("生产者放入一个产品，目前有"+list.size()+"个产品");
				}
				System.out.println("队列满"+"等待消费者消费");
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
						System.out.println("消费者消费一个产品，目前所剩"+list.size()+"个产品");
					}
					System.out.println("队列空,等待生产者生产");
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
						System.out.println("获得一个信号量，线程"+Thread.currentThread().getName()+"准备执行中....");
						Thread.sleep(100);
						System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
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
