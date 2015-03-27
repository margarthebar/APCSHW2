public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Integer> dq = new MyDeque<Integer>();
	dq.addLast(1);
	dq.addLast(2);
	System.out.println(dq.toString());
	dq.addLast(3);
	dq.addLast(4);
	System.out.println(dq.toString());
    }
}
