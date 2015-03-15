public class LinkedList{
    private LNode start;
    private LNode end = start;
    private int size = 0;

    public int get(int index){
	int count = 0;
	LNode current = start;
	while(count<index){
	    count++;
	    current = current.getNext();
	}
	return current.getValue();
    }
    public void set(int index, int n){
	int count = 0;
	LNode current = start;
	while(count!=index){
	    count++;
	    current = current.getNext();
	}
	current.setValue(n);
    }
    public int size(){
	return size;
    }
    public int indexOf(int value){
	LNode current = start;
	for(int i=0; i<size(); i++){
	    if(current.getValue()==value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    public void remove(int index){
	if(index==0){
	    start = start.getNext();
	}else{
	    LNode current = start;
	    int count = 0;
	    boolean done = false;
	    while(current.getNext()!=null && !done){
		if(count+1==index){
		    if(index==size()-1){
			end = current;
		    }
		    current.setNext(current.getNext().getNext());
		    done = true;
		}
		current = current.getNext();
		count++;
	    }
	}
    }
    public boolean add(int value){
	if(size()==0){
	    start = new LNode(value);
	    end = start;
	    size++;
	}else{
	    LNode current = start;
	    while(current.getNext()!=null){
		current = current.getNext();
	    }
	    LNode addition = new LNode(value);
	    current.setNext(addition);
	    end = addition;
	    size++;
	}
	return true;
    }
    public void add(int index, int value){
	LNode current = start;
	int count = 0;
	LNode addition = new LNode(value);
	LNode after = current;
	if(index==0){
	    addition.setNext(current);
	    size++;
	}else if(index==size-1){
	    add(value);
	    size++;
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
	LNode current = start;
	while(current!=null){
	    ans+=current.toString()+",";
	    current = current.getNext();
	}
	return ans+" ]";
    }
}
