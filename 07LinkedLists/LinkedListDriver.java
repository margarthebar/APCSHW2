public class LinkedListDriver{
    public static void main(String[]args){
	LinkedList<Integer> s = new LinkedList<Integer>();
	System.out.println(s.toString());
	s.add(3);
	System.out.println(s.toString());
	s.add(2);
	s.add(9);
	s.add(0);
	System.out.println(s.toString());
	System.out.println(s.indexOf(9));
	System.out.println(s.size());
	System.out.println(s.get(2));
	s.set(3,6);
	System.out.println(s);
	s.add(2,16);
	System.out.println(s);
	s.remove(2);
	System.out.println(s);
    }
}