public class LinkedListDriver{
    public static void main(String[]args){
	LinkedList s = new LinkedList();
	System.out.println(s.toString());
	s.add(3);
	System.out.println(s.toString());
	s.add(2);
	s.add(9);
	s.add(0);
	System.out.println(s.toString());
	
	System.out.println(s.indexOf(9));
	System.out.println(s.size());
	
    }
}
