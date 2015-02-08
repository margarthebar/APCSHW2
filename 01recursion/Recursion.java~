import java.lang.Math;
public class Recursion{
    public String name(){
	return "Burkart,Margaret";
    }

    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}else if(n==0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}else if(n==0){
	    return 0;
	}else if(n==1){
	    return 1;
	}
	return fib(n-2)+fib(n-1);
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n,1);
    }

    public double sqrtHelper(double n, double guess){
	if(Math.abs( 1- ( guess*guess / n ) ) <= 0.00001 ){
	    return guess;
	}
	return sqrtHelper(n , (n/guess + guess)/2 ); 
    }

}
