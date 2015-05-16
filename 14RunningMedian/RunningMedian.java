import java.util.*;
public class RunningMedian{
    public MyHeap smaller = new MyHeap(true);
    public MyHeap larger = new MyHeap(false);

    public void add(int value){
	if(smaller.size()==0 && larger.size()==0){
	    smaller.add(value);
	}else{
	    //add to correct heap
	    if((double)value<getMedian()){
		smaller.add(value);
	    }else{
		larger.add(value);
	    }
	    //look at sizes; if one=other+2, move root of one to other
	    if(smaller.size()==larger.size()+2){
		int root = smaller.remove();
		larger.add(root);
	    }else if(larger.size()==smaller.size()+2){
		int root = larger.remove();
		smaller.add(root);
	    }
	}
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
