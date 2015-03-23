import java.util.*;
public class MyQueue<T>{
    private MyLinkedList<T> line = new MyLinkedList<T>();

    public boolean enqueue(T n){
	line.add(n);
	return true;
    }
    public T dequeue(){
	T ans = line.get(0);
	line.remove(0);
	return ans;
    }

    public String toString(){
	return line.toString();
    }
}
