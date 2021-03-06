import java.util.*;
public class MyDeque<T>{
    Object[] storage = new Object[10];
    int[] priorities = new int[10];
    int head = -1;
    int tail = -1;
    int size = 0;
    public int size(){
	return size;
    }
    public String toString(){
	String ans = "[ ";
	for(int i=0; i<storage.length; i++){
	    ans+=storage[i]+" ";
	}
	return ans+"]";
    }
    public void add(T value, int priority){
	addLast(value);
	priorities[tail]=priority;
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
	int[] enlargedP = new int[priorities.length*2];
	if(head!=0){
	    for(int i=head; i<storage.length; i++){
		enlarged[i-head]=storage[i];
		enlargedP[i-head]=priorities[i];
	    }
	    if(head>tail){
		for(int i=0; i<=tail; i++){
		    enlarged[i+(storage.length-head)]=storage[i];
		    enlargedP[i+(priorities.length-head)]=priorities[i];
		}
		tail = storage.length - head + tail;
	    }else{
		tail = tail-head;
	    }
	    head = 0;
	}else{
	    for(int i=0; i<=tail; i++){
		enlarged[i] = storage[i];
		enlargedP[i] = priorities[i];
	    }
	}
	storage = enlarged;
	priorities = enlargedP;
    }
    public T removeSmallest(){
	if(size==0){
	    throw new NoSuchElementException();
	}else if(size==1){
	    size--;
	    T removed = (T)storage[head];
	    storage[head] = null;
	    priorities[head] = -1;
	    head = -1;
	    tail = -1;
	    return removed;
	}else{
	    int location = head;
	    int priority = priorities[head];
	    //System.out.println(storage[location]+" "+priority);
	    int i=head;
	    int end;
	    if(head<tail){
		end = tail;
	    }else{
		end = priorities.length+tail;
	    }
	    while(i<=end){
		int index = i%priorities.length;
		if(storage[index]!=null && priorities[index]>=0 && priorities[index]<priority){
		    priority = priorities[index];
		    location = index;
		}
		i++;
	    }
	    T removed = (T)storage[location];
	    storage[location] = storage[head];
	    priorities[location]=priorities[head];
	    storage[head]=null;
	    priorities[head]=-1;
	    head=(head+1)%storage.length;
	    size--;
	    if(storage.length>10 && size<=storage.length/4){
		shrink();
	    }
	    if(size==0){
		head = -1;
		tail = -1;
	    }
	    return removed;
	}
    }
    public T removeLargest(){
	if(size==0){
	    throw new NoSuchElementException();
	}else if(size==1){
	    size--;
	    T removed = (T)storage[head];
	    storage[head] = null;
	    priorities[head] = -1;
	    head = -1;
	    tail = -1;
	    return removed;
	}else{
	    int location = head;
	    int priority = priorities[head];
	    //System.out.println(storage[location]+" "+priority);
	    int i=head;
	    int end;
	    if(head<tail){
		end = tail;
	    }else{
		end = priorities.length+tail;
	    }
	    while(i<=end){
		int index = i%priorities.length;
		if(storage[index]!=null && priorities[index]>=0 && priorities[index]>priority){
		    priority = priorities[index];
		    location = index;
		}
		i++;
	    }
	    T removed = (T)storage[location];
	    storage[location] = storage[head];
	    priorities[location]=priorities[head];
	    storage[head]=null;
	    priorities[head]=-1;
	    head=(head+1)%storage.length;
	    size--;
	    if(storage.length>10 && size<=storage.length/4){
		shrink();
	    }
	    if(size==0){
		head = -1;
		tail = -1;
	    }
	    return removed;
	}
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
