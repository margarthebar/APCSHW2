public class MyQueueDriver{
    public static void main(String[]args){
	MyQueue<Integer> q = new MyQueue<Integer>();
	System.out.println(q.toString());
	q.enqueue(0);
	System.out.println(q.toString());
	q.enqueue(3);
	System.out.println(q.toString());
	q.enqueue(7);
	System.out.println(q.toString());
	System.out.println(q.dequeue());
	System.out.println(q.toString());
	System.out.println(q.dequeue());
	System.out.println(q.toString());
	System.out.println(q.dequeue());
	System.out.println(q.toString());
    }
}
