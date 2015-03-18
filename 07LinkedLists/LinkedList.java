import java.util.*;

public class LinkedList<T> implements Iterable<T>{
    public class LinkedListIterator<T> implements Iterator<T>{
	LNode<T> place;
	public T next(){
	    T ans = place.getValue();
	    place = place.getNext();
	    return ans;
	}
	public boolean hasNext(){
	    return place!=null;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
	public LinkedListIterator(LNode<T> point){
	    place = point;
	}
    }

    private LNode<T> start;
    private LNode<T> end = start;
    private int size = 0;

    public String name(){
	return "Burkart.Margaret";
    }

    public T get(int index) throws IndexOutOfBoundsException{
	int count = 0;
	LNode<T> current = start;
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	while(count<index){
	    count++;
	    current = current.getNext();
	}
	return current.getValue();
    }
    public void set(int index, T n) throws IndexOutOfBoundsException{
	int count = 0;
	LNode<T> current = start;
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	while(count!=index){
	    count++;
	    current = current.getNext();
	}
	current.setValue(n);
    }
    public int size(){
	return size;
    }
    public int indexOf(T value){
	LNode<T> current = start;
	for(int i=0; i<size(); i++){
	    if(current.getValue()==value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    public void remove(int index) throws IndexOutOfBoundsException{
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	if(index==0){
	    start = start.getNext();
	    size--;
	}else{
	    LNode<T> current = start;
	    int count = 0;
	    boolean done = false;
	    while(!done && current.getNext()!=null){
		if(count+1==index){
		    if(index==size()-1){
			current.setNext(null);
			end = current;
		    }else{
			current.setNext(current.getNext().getNext());
		    }
		    done = true;
		    size--;
		}
		current = current.getNext();
		count++;
	    }
	}
    }
    public boolean add(T value){
	if(size()==0){
	    start = new LNode<T>(value);
	    end = start;
	    size++;
	}else{
	    LNode<T> current = start;
	    while(current.getNext()!=null){
		current = current.getNext();
	    }
	    LNode<T> addition = new LNode<T>(value);
	    current.setNext(addition);
	    end = addition;
	    size++;
	}
	return true;
    }
    public void add(int index, T value) throws IndexOutOfBoundsException{
	LNode<T> current = start;
	int count = 0;
	LNode<T> addition = new LNode<T>(value);
	LNode<T> after = current;
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	if(index==0){
	    addition.setNext(current);
	    start=addition;
	    size++;
	}else if(index==size-1){
	    add(value);
	}else{
	    boolean done = false;
	    while(current!=null && !done){
		if(count+1==index){
		    after = current.getNext();
		    current.setNext(addition);
		    addition.setNext(after);
		    done=true;
		}else{
		    count++;
		    current = current.getNext();
		}
	    }
	    size++;
	}
    }
    public String toString(){
	String ans = "[ ";
	LNode<T> current = start;
	while(current!=null){
	    ans+=current.toString()+",";
	    current = current.getNext();
	}
	return ans.substring(0,ans.length()-1)+" ]";
    }

    public Iterator<T> iterator(){
	return new LinkedListIterator<T>(start);
    }
}
