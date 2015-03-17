public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(T n){
	setValue(n);
    }
    public LNode<T> getNext(){
	return next;
    }
    public T getValue(){
	return value;
    }
    public void setNext(LNode<T> nxt){
	next = nxt;
    }
    public void setValue(T n){
	value = n;
    }
    public String toString(){
	return ""+value;
    }
}
