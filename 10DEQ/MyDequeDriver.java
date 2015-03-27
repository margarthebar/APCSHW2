public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Integer> dq = new MyDeque<Integer>();
	dq.addLast(1);
	System.out.println(dq.toString());
	dq.addLast(2);
	System.out.println(dq.toString());
	dq.addFirst(3);
	System.out.println(dq.toString());
	dq.addFirst(4);
	System.out.println(dq.toString());
	dq.addLast(5);
	System.out.println(dq.toString());
	dq.addLast(6);
	System.out.println(dq.toString());
	dq.addFirst(7);
	System.out.println(dq.toString());
	dq.addFirst(8);
	System.out.println(dq.toString());
	dq.addFirst(9);
	System.out.println(dq.toString());
	dq.addFirst(10);
	System.out.println(dq.toString());
	dq.addFirst(11);
        System.out.println(dq.toString());
    }
}
