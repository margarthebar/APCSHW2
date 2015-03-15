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
	System.out.println(s.get(2));
	s.set(3,6);
	System.out.println(s+" "+s.size());
	s.add(2,16);
	System.out.println(s+" "+s.size());
	s.add(4,11);
	System.out.println(s+" "+s.size());
	s.remove(2);
	System.out.println(s+" "+s.size());
	s.remove(0);
	System.out.println(s+" "+s.size());
	s.remove(s.size()-1);
	System.out.println(s+" "+s.size());
	try{
	    s.get(30);
	}catch(IndexOutOfBoundsException e){
	    System.out.println(e);
	}
	System.out.println(s+" "+s.size());
	try{
	    s.set(30,4);
        }catch(IndexOutOfBoundsException e){
	     System.out.println(e);
	}
	System.out.println(s+" "+s.size());
	try{
	    s.remove(30);
        }catch(IndexOutOfBoundsException e){
	     System.out.println(e);
	}
	System.out.println(s+" "+s.size());
	try{
	    s.add(30,2);
        }catch(IndexOutOfBoundsException e){
	     System.out.println(e);
	}
	System.out.println(s+" "+s.size());
	
    }
}
