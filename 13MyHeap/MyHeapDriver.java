public class MyHeapDriver{
    public static void main(String[]args){
	MyHeap h = new MyHeap();
        h.add(16);
	System.out.println(h.toString());
	System.out.println();
	h.add(32);
	System.out.println(h.toString());
	System.out.println();
	h.add(10);
	System.out.println(h.toString());
	System.out.println();
	h.add(40);
	System.out.println(h.toString());
	System.out.println();
	h.add(9);
	System.out.println(h.toString());
	System.out.println();
	h.add(50);
	System.out.println(h.toString());
	System.out.println();
	h.remove();
	System.out.println(h.toString());
	System.out.println();
	h.remove();
	System.out.println(h.toString());
	System.out.println();

	/*
	MyHeap g = new MyHeap();
	g.add(1);
	System.out.println(g.toString());
	g.add(3);
	System.out.println(g.toString());
	g.add(4);
	System.out.println(g.toString());
	g.add(0);
	System.out.println(g.toString());
	g.remove();
	System.out.println(g.toString());
	*/
    }
}
