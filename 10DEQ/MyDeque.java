import java.util.*;
public class MyDeque<T>{
    Object[] storage = new Object[5];
    int head = 0;
    int tail = 4;
    public void addFirst(T value){
	storage[head] = value;
	head++;
    }
    public void addLast(T value){
	storage[tail] = value;
	tail--;
    }
    /*
    public T removeFirst(){

    }
    public T removeLast(){

    }
    */
}
/*
There are 6 public methods:
1. void addFirst(T value)
2. void addLast(T value)
-When the array is full, resize, then add. 
-No exceptions are required since you will resize.

3. T removeFirst()  *warning*
4. T removeLast()  *warning*
-NoSuchElementException is thrown when there are no elements. 

5. T getFirst()  *warning*
6. T getLast()  *warning*
-NoSuchElementException is thrown when there are no elements. 

7. You need a method to resize and copy over the values to .

*/