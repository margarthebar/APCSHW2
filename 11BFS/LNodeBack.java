public class LNodeBack<T>{
    private T value;
    private LNodeBack<T> prev;

    public LNodeBack(T n){
	setValue(n);
    }
    public LNodeBack<T> getPrev(){
	return prev;
    }
    public T getValue(){
	return value;
    }
    public void setPrev(LNodeBack<T> prv){
	prev = prv;
    }
    public void setValue(T n){
	value = n;
    }
    /*
    public String toString(){
	return ""+value+printPath();
    }
    */
    public String toString(){
	return ""+value;
    }

   public String printPath(){
	String ans = "[";
	MyStack<T> path = new MyStack<T>();
	LNodeBack<T> current = this;
	while(current.getPrev()!=null){
	    path.push(current.getValue());
	    current = current.getPrev();
	}
	path.push(current.getValue());
	while(!path.empty()){
	    ans+=path.pop().toString()+",";
	}
	ans+="]";
	return ans;
    }
}
