import java.util.*;
public class MyDeque<T>{
    Object[] storage = new Object[5];
    int head = -1;
    int tail = -1;
    public String toString(){
	String ans = "[ ";
	for(int i=0; i<storage.length; i++){
	    ans+=storage[i]+" ";
	}
	System.out.println("\n"+head+" "+tail);
	return ans+"]";
    }
    public void addFirst(T value){
	if(head==tail+1){
	    resize();
	}
	if(head==0){
	    if(storage.length-1<=tail){
		resize();
	    }
	    head = storage.length;
	}
	head--;
	storage[head] = value;
    }
    public void addLast(T value){
	if(tail==storage.length-1 || (head!=0 && tail==head-1)){
	    resize();
	}
	storage[tail+1] = value;
	tail++;
	if(head==-1){
	    head = 0;
	}
    }
    public void resize(){
	System.out.println("resizing...");
	Object[] enlarged = new Object[storage.length*2];
	if(head!=0){
	    for(int i=head; i<storage.length; i++){
		enlarged[i-head]=storage[i];
	    }
	    for(int i=0; i<=tail; i++){
		enlarged[i+(storage.length-head)]=storage[i];
	    }
	    tail = storage.length - head + tail;
	    head = 0;
	}else{
	    for(int i=0; i<=tail; i++){
		enlarged[i] = storage[i];
	    }
	}
	storage = enlarged;
    }
    public T removeFirst(){
	if(storage[head]==null){
	    throw new NoSuchElementException();
	}
	T removed = (T)storage[head];
	storage[head]=null;
	head++;
	return removed;	
    }
    public T removeLast(){
	if(storage[head]==null){
	    throw new NoSuchElementException();
	}
	T removed = (T)storage[tail];
	storage[tail]=null;
	tail--;
	return removed;
    }
    public T getFirst(){
	if(storage[head]==null){
	    throw new NoSuchElementException();
	}
	return (T)storage[head];
    }
    public T getLast(){
	if(storage[head]==null){
	    throw new NoSuchElementException();
	}
	return (T)storage[tail];
    }
}
/*
  There are 6 public methods:
  1. void addFirst(T value)
  2. void addLast(T value)
  -When the array is full, resize, then add. 
  -No exceptions are required since you will resize.
  3. T removeFirst()  *warning*
  4. T removeLast()  *warning*
  -NoSuchElementException is thrown when there are no elements. 
  5. T getFirst()  *warning*
  6. T getLast()  *warning*
  -NoSuchElementException is thrown when there are no elements. 
  7. You need a method to resize and copy over the values to .
*/
