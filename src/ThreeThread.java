
public class ThreeThread {
	public static void main(String[] args){
		LockObj obj = new LockObj();
		Task task = new Task(obj);
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Task implements Runnable{
	private LockObj obj = null;
	public Task(LockObj obj){
		this.obj = obj;
	
	}
	public void run(){
		while(true){
			synchronized(obj){
				obj.notifyAll();
				if(("t" + (obj.get()%3 +1)) .equals(Thread.currentThread().getName())){
					obj.print();
					obj.increase();
				}
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