public class LinkedList{
    LNode start;

    public int get(int index){
	return 42;
    }
    public void set(int index, int n){
    }
    public int size(){
	return 42;
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
