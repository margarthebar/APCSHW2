public class LinkedListDriver{
    public static void main(String[]args){
	LinkedList<Integer> i = new LinkedList<Integer>();
	LinkedList<String> s = new LinkedList<String>();
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

    }
}
