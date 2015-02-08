import java.lang.Math;

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

    public static double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n,1);
    }

    public static double sqrtHelper(double n, double guess){
	if(Math.abs( 1- ( guess*guess / n ) ) <= 0.00001 ){
	    return guess;
	}
	return sqrtHelper(n , (n/guess + guess)/2 ); 
    }

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
	    System.out.println(sqrt(25));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(sqrt(100));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}

	try{
	    System.out.println(sqrt(-3));
	}catch(IllegalArgumentException e){
	    System.out.println("Caught IllegalArgumentException");
	}
    }
}
