import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> stack = new MyLinkedList<T>();
    
    public String name(){
	return "Burkart.Margaret";
    }

    public T push(T item){
	return item;
    }

    public T pop(){
	return stack.remove();
    }

    public T peek(){
	return stack.;
    }

    public boolean empty(){
	return stack.size()==0;
    }
}
