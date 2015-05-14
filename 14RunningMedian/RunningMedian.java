import java.util.*;
public class RunningMedian{
    public MyHeap smaller = new MyHeap(true);
    public MyHeap larger = new MyHeap(false);

    public void add(int value){
	
    }
    public double getMedian(){
	if(smaller.size()==0 && larger.size()==0){
	    throw new NoSuchElementException();
	}else if(smaller.size()==0){
	    return (double)larger.peek();
	}else if(larger.size()==0   ){
	    return (double)smaller.peek();
	}else{
	    if(smaller.size()>larger.size()){
		return (double)smaller.peek();
	    }else if(larger.size()>smaller.size()){
		return (double)larger.peek();
	    }else{
		return ((double)smaller.peek()+(double)larger.peek())/2;
	    }
	}
    }
}