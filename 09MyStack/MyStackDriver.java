public class MyStackDriver{
    public static void main(String[]args){
	MyStack<Integer> s = new MyStack<Integer>();
	System.out.println("before:");
	if(s.empty()){
	    System.out.println("true");
	}else{
	    System.out.println("false");
	}
	s.push(5);
	s.push(-1);
	s.push(0);
	System.out.println("after:");
        if(s.empty()){
	    System.out.println("true");
	}else{
	    System.out.println("false");
	}

	System.out.println(s.peek());
	System.out.println(s.pop());
	if(s.empty()){
	    System.out.println("true");
	}else{
	    System.out.println("false");
	}

	System.out.println(s.peek());
	System.out.println(s.pop());
	if(s.empty()){
	    System.out.println("true");
	}else{
	    System.out.println("false");
	}

	System.out.println(s.peek());
	System.out.println(s.pop());
	if(s.empty()){
	    System.out.println("true");
	}else{
	    System.out.println("false");
	}
    }
}
