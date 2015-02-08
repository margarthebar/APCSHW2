public class demoRecursion{
    public static void main(String[]args){
	Recursion r = new Recursion();

	System.out.println(r.name());

	try{
	    System.out.println(r.fact(5));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(r.fact(-3));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(r.fib(7));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(r.sqrt(25));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(r.sqrt(100));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(r.sqrt(-3));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}
    }
}
