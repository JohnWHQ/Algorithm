import java.util.*;
import java.util.concurrent.*;

class ProduceAndConsumer{
	public static void main(String[] args) {
		Sourse s = new Sourse();
		Thread t1 = new Thread(new Producer(s));
		Thread t2 = new Thread(new Consumer(s));

		t1.start();
		try{
			Thread.sleep(5);
		}catch(Exception e){

		}
		
		t2.start();
	}
}
class Sourse{
	BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
	public void produce(int data){
		try{
			blockingQueue.put(data);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("produce size:" + blockingQueue.size());
	}
	public int comsume(){
		int cur = 0;
		try{
			cur = blockingQueue.take();
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("comsume size:" + blockingQueue.size());
		return cur;
	}		
}

class Producer implements Runnable{
	Sourse s;
	public Producer(Sourse s){
		this.s = s;
	}
	@Override
	public void run(){
		Random r = new Random();
		while(true){
			int x = r.nextInt();
			s.produce(x);
			System.out.println("Producer fuck :" + x);
		}
	}
}
class Consumer implements Runnable{
	Sourse s;
	public Consumer(Sourse s){
		this.s = s;
	}
	@Override
	public void run(){
		Random r = new Random();
		while(true){
			int x = s.comsume();
			System.out.println("Consumer fuck :" + x);
		}
	}	
}