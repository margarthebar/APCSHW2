import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> stack = new MyLinkedList<T>();
    
    public String name(){
	return "Burkart.Margaret";
    }

    public T push(T item){
	if(empty()){
	    stack.add(item);
	}else{
	    stack.add(0,item);
	}
	return item;
    }

    public T pop(){
	T removed = stack.get(0);
        stack.remove(0);
	return removed;
    }

    public T peek(){
	return stack.get(0);
    }

    public boolean empty(){
	return stack.size()==0;
    }
}
