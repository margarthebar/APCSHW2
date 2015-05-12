public class MyHeapDriver{
    public static void main(String[]args){
	MyHeap h = new MyHeap();
        for(int i=1; i<8; i++){
	    h.add(i);
	}
	System.out.println(h.toString());
    }
}
