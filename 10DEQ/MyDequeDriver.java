import java.util.*;
public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Integer> dq = new MyDeque<Integer>();
	dq.addLast(1);
	System.out.println(dq.toString());
	dq.addLast(2);
	System.out.println(dq.toString());
	dq.addFirst(3);
	System.out.println(dq.toString());
	dq.addFirst(4);
	System.out.println(dq.toString());
	dq.addLast(5);
	System.out.println(dq.toString());
	dq.addLast(6);
	System.out.println(dq.toString());
	dq.addFirst(7);
	System.out.println(dq.toString());
	dq.addFirst(8);
	System.out.println(dq.toString());
	dq.addFirst(9);
	System.out.println(dq.toString());
	dq.addFirst(10);
	System.out.println(dq.toString());
	dq.addFirst(11);
        System.out.println(dq.toString());
	dq.addLast(12);
	System.out.println(dq.toString());
	dq.addLast(13);
	System.out.println(dq.toString());
	dq.addLast(14);
	System.out.println(dq.toString());
	dq.addLast(15);
	System.out.println(dq.toString());
	dq.addLast(16);
	System.out.println(dq.toString());
	dq.addLast(17);
	System.out.println(dq.toString());
	dq.addLast(18);
	System.out.println(dq.toString());
	dq.addLast(19);
	System.out.println(dq.toString());
	dq.addLast(20);
	System.out.println(dq.toString());
	dq.addLast(21);
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	System.out.println(dq.getFirst());
	System.out.println(dq.getLast());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.removeLast();
	System.out.println(dq.toString());
	dq.addFirst(8);
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	dq.addFirst(8);
	System.out.println(dq.toString());
	dq.removeFirst();
	System.out.println(dq.toString());
	try{
	    dq.removeLast();
	}catch(NoSuchElementException e){
	    System.out.println("caught exception");
	}
	try{
	    dq.removeFirst();
	}catch(NoSuchElementException e){
	    System.out.println("caught exception");
	}
	try{
	    System.out.println(dq.getFirst());
	}catch(NoSuchElementException e){
	    System.out.println("caught exception");
	}
	try{
	    System.out.println(dq.getLast());
	}catch(NoSuchElementException e){
	    System.out.println("caught exception");
	}
    }
}
