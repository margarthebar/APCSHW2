public class RunningMedian{
    public MyHeap smaller = new MyHeap(true);
    public MyHeap larger = new MyHeap(false);

    public void add(int value){
	
    }
    public double getMedian(){
	if(smaller.peek()==null && larger.peek()==null){
	    return null;
	}else if(smaller.peek()==null){
	    return (double)larger.peek();
	}else if(larger.peek()==null){
	    return (double)smaller.peek();
	}else{
	    //if more in smaller
	    //if more in larger
	    //if same size
	}
    }
}