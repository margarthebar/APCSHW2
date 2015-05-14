public class MyHeapDriver{
    public static void main(String[]args){
	MyHeap h = new MyHeap();
        h.add(16);
	System.out.println(h.toString());
	h.add(32);
	System.out.println(h.toString());
	h.add(10);
	System.out.println(h.toString());
	h.add(40);
	System.out.println(h.toString());
	h.add(9);
	System.out.println(h.toString());
	h.add(50);
	System.out.println(h.toString());
	h.remove();
	System.out.println(h.toString());
	h.remove();
	System.out.println(h.toString());
    }
}
