import java.util.*;
public class RunningMedian{
    public MyHeap smaller = new MyHeap(true);//where the numbers smaller than the median go
    public MyHeap larger = new MyHeap(false);//where the numbers larger than the median go

    public void add(int value){
	if(smaller.size()==0 && larger.size()==0){//if both are empty, put one in smaller (doesn't matter which)
	    smaller.add(value);
	}else{
	    //add to correct heap
	    if((double)value<getMedian()){//if value smaller than the median, move to smaller
		smaller.add(value);
	    }else{//if value larger than the median, move to larger
		larger.add(value);
	    }
	    //look at sizes; redistribute in one is too large
	    if(smaller.size()==larger.size()+2){//if too many in smaller, move one to larger
		int root = smaller.remove();
		larger.add(root);
	    }else if(larger.size()==smaller.size()+2){//if too many in larger, move one to smaller
		int root = larger.remove();
		smaller.add(root);
	    }
	}
    }
    public double getMedian(){
	if(smaller.size()==0 && larger.size()==0){//if none in either, throw an exception
	    throw new NoSuchElementException();
	}else if(smaller.size()==0){//if none in smaller, return one in larger
	    return (double)larger.peek();
	}else if(larger.size()==0   ){//if none in larger, return one in smaller
	    return (double)smaller.peek();
	}else{
	    if(smaller.size()>larger.size()){//if more in smaller, return root of larger
		return (double)smaller.peek();
	    }else if(larger.size()>smaller.size()){//if more in larger, return root of smaller
		return (double)larger.peek();
	    }else{//if equals, return the average of the roots of both
		return ((double)smaller.peek()+(double)larger.peek())/2;
	    }
	}
    }
}
