public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Integer> dq = new MyDeque<Integer>();
	dq.addFirst(2);
	dq.addLast(1);
	System.out.println(dq.toString());
    }
}