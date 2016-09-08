
public class LockObj{
	private int i = 0;
	public void print(){
		String name = Thread.currentThread().getName();
		System.out.println(name +"==="+ i);
	}
	public void increase(){
		++i;		
	}
	public int get() {
		// TODO Auto-generated method stub
		return i;
	}
}