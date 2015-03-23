public class MyQueueDriver{
    public static void main(String[]args){
	MyQueue<Integer> q = new MyQueue<Integer>();
	q.enqueue(0);
	q.enqueue(3);
	q.enqueue(7);
	System.out.println(q.dequeue());
    }
}
