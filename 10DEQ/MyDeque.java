import java.util.*;
public class MyDeque<T>{
    Object[] storage = new Object[5];
    int head = 0;
    int tail = 0;
    public String toString(){
	String ans = "[ ";
	for(int i=0; i<storage.length; i++){
	    ans+=storage[i]+" ";
	}
	return ans+"]";
    }
    public void addFirst(T value){
	if(head==0){
	    if(storage.length-1>tail){
		head = storage.length-1;
	    }else{
		resize();
		head = storage.length-1;
	    }
	}
	storage[head] = value;
	head--;
    }
    public void addLast(T value){
	if(tail>=storage.length || (head!=0 && tail==head+1)){
	    resize();
	}
	storage[tail] = value;
	tail++;
    }
    public void resize(){
	Object[] enlarged = new Object[storage.length*2];
	for(int i=0; i<tail; i++){
	    enlarged[i] = storage[i];
	}
	if(head!=0){
	    head =  enlarged.length-(storage.length-head);
	}
	for(int j=storage.length-1; j>=tail; j--){
	    int index = enlarged.length-1-(storage.length-1-j);
	    enlarged[index] = storage[j];
	}
	storage = enlarged;
    }
    /*
      public T removeFirst(){
      }
      public T removeLast(){
      }
    */
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
