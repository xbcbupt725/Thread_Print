
public class TwoThread {
	public static void main(String[] args){
		LockObj obj = new LockObj();
		MyTask task = new MyTask(obj);
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
}



class MyTask implements Runnable{
	LockObj obj = null;
	public MyTask(LockObj obj){
		this.obj = obj;
	}
	public void run(){
		while(obj.get()< 100){
			synchronized(obj){
				obj.notifyAll();
				obj.increase();
				obj.print();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}