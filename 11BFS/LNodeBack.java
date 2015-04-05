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
    public void setNext(LNodeBack<T> prv){
	prev = prv;
    }
    public void setValue(T n){
	value = n;
    }
    public String toString(){
	return ""+value;
    }
}
