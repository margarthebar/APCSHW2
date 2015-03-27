public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Integer> dq = new MyDeque<Integer>();
	dq.addLast(1);
	dq.addLast(2);
	System.out.println(dq.toString());
	dq.addFirst(3);
	dq.addFirst(4);
	System.out.println(dq.toString());
	dq.addLast(5);
	dq.addLast(6);
	System.out.println(dq.toString());
    }
}
