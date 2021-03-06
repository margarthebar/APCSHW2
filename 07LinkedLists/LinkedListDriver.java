public class LinkedListDriver{
    public static void main(String[]args){
	MyLinkedList<Integer> i = new MyLinkedList<Integer>();
	MyLinkedList<String> s = new MyLinkedList<String>();
	//tests add(value)
	System.out.println("add(value)");
	i.add(0);
	i.add(1);
	i.add(2);
	System.out.println(i);
	s.add("happy");
	s.add("birthday");
	s.add("to");
	s.add("you");
	System.out.println(s);
	System.out.println();

	System.out.println("add(index, value)");
	i.add(1,9);
	i.add(0,10);
	i.add(4,11);
	System.out.println(i);
	s.add(1,"marvelous");
	s.add(0,"a");
	s.add(0,"have");
	System.out.println(s);
	System.out.println();

	System.out.println("get(index)");
	System.out.println(i.get(0));
	System.out.println(i.get(1));
	System.out.println(i.get(2));
	System.out.println(i.get(3));
	System.out.println(i.get(4));
	System.out.println(i.get(5));
	try{
	    System.out.println(i.get(6));
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(i);
	System.out.println(s.get(0));
	System.out.println(s.get(1));
	System.out.println(s.get(2));
	System.out.println(s.get(3));
	System.out.println(s.get(4));
	System.out.println(s.get(5));
	System.out.println(s.get(6));
	try{
	    System.out.println(s.get(7));
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(s);
	System.out.println();

	System.out.println("set(index,value)");
	i.set(0,42);
	i.set(3,66);
	i.set(5,101);
	try{
	    i.set(6,404);
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(i);
	s.set(2,"very");
	s.set(0,"Sending");
	s.set(6,"me");
	try{
	    s.set(7,"hooray!");
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(s);
	System.out.println();

	System.out.println("indexOf(value)");
	System.out.println(i.indexOf(42));
	System.out.println(i.indexOf(0));
	System.out.println(i.indexOf(9));
	System.out.println(i.indexOf(66));
	System.out.println(i.indexOf(2));
	System.out.println(i.indexOf(101));
	try{
	    System.out.println(i.indexOf(3));
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(i);
	System.out.println(s.indexOf("Sending"));
	System.out.println(s.indexOf("a"));
	System.out.println(s.indexOf("very"));
	System.out.println(s.indexOf("marvelous"));
	System.out.println(s.indexOf("birthday"));
	System.out.println(s.indexOf("to"));
	System.out.println(s.indexOf("me"));
	try{
	    System.out.println(s.indexOf("what"));
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(s);
	System.out.println();

	System.out.println("remove(index)");
	i.remove(0);
	i.remove(4);
	i.remove(2);
	try{
	    i.remove(3);
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(i);
	s.remove(1);
	s.remove(5);
	s.remove(0);
	try{
	    s.remove(4);
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e.toString());
	}
	System.out.println(s);
	System.out.println();

	for(Integer n:i){
	    System.out.println(n+"printing");
	}

    }
}
