public class LinkedList{
    LNode start;

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
    }
    public int size(){
	int count = 0;
	if(start==null){
	    return count;
	}else{
	    count = 1;
	    LNode current = start;
	    while(current.getNext()!=null){
		count++;
		current = current.getNext();
	    }
	    return count;
	}
    }
    public int indexOf(int value){
	return 42;
    }
    public void remove(int index){
    }
    public void add(int value){
	if(size()==0){
	    start = new LNode(value);
	}else{
	    LNode current = start;
	    while(current.getNext()!=null){
		current = current.getNext();
	    }
	    current.setNext(new LNode(value));
	}
    }
    public void add(int value, int index){
    }
    public String toString(){
	return "42";
    }
}
