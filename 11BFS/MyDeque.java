import java.util.*;
public class MyDeque<T>{
    Object[] storage = new Object[10];
    int head = -1;
    int tail = -1;
    int size = 0;
    public String toString(){
	String ans = "[ ";
	for(int i=0; i<storage.length; i++){
	    ans+=storage[i]+" ";
	}
	return ans+"]";
    }
    public void addFirst(T value){
	size++;
	if(head==tail+1){
	    resize();
	}
	if(head==0){
	    if(storage.length-1<=tail){
		resize();
	    }
	    head = storage.length;
	}
	if(head==-1){
	    head = 1;
	    tail = 0;
	}
	head--;
	storage[head] = value;
    }
    public void addLast(T value){
	size++;
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
	Object[] enlarged = new Object[storage.length*2];
	if(head!=0){
	    for(int i=head; i<storage.length; i++){
		enlarged[i-head]=storage[i];
	    }
	    if(head>tail){
		for(int i=0; i<=tail; i++){
		    enlarged[i+(storage.length-head)]=storage[i];
		}
		tail = storage.length - head + tail;
	    }else{
		tail = tail-head;
	    }
	    head = 0;
	}else{
	    for(int i=0; i<=tail; i++){
		enlarged[i] = storage[i];
	    }
	}
	storage = enlarged;
    }
    public T removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	size--;
	T removed = (T)storage[head];
	storage[head]=null;
	head++;
	if(storage.length>10 && size<=storage.length/4){
	    shrink();
	}
	if(size==0){
	    head = -1;
	    tail = -1;
	}
	return removed;	
    }
    public T removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	size--;
	T removed = (T)storage[tail];
	storage[tail]=null;
	tail--;
	if(storage.length>10 && size<=storage.length/4){
	    shrink();
	}
	if(size==0){
	    head = -1;
	    tail = -1;
	}
	return removed;
    }
    public T getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return (T)storage[head];
    }
    public T getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return (T)storage[tail];
    }
    public void shrink(){
	Object[] shrunk = new Object[storage.length/2];
	for(int i=head; i<=tail; i++){
	    shrunk[i-head]=storage[i];
	}
	tail = tail-head;
	head = 0;
	storage=shrunk;
    }
}
