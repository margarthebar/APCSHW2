public class Recursion{
    public static String name(){
	return "Burkart,Margaret";
    }

    public static int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}else if(n==0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public static int fib(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}else if(n==0){
	    return 0;
	}else if(n==1){
	    return 1;
	}
	return fib(n-2)+fib(n-1);
    }

    /*
    public static double sqrt(double n){

    }
    */

    public static void main(String[]args){
	System.out.println(name());

	try{
	    System.out.println(fact(5));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(fact(-3));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(fib(7));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(fib(-3));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}
    }
}
