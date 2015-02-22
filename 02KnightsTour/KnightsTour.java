import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "burkart.margaret";
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[0].length; c++){
		for(int i=0; i<3-(""+board[r][c]).length(); i++){
		    ans+=" ";
		}
		ans+=board[r][c];
	    }
	    ans+="\n";
	}
	return clear+ hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];		
    }

    

    public boolean solve(){
	return solve(0,0);			
    }


    public boolean solve(int x, int y){
	return solve(x,y,1);
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//System.out.println("\n"+currentMoveNumber);
	//wait(1);
	//base case: if off board
	if(x<0 || x>=board[0].length || y<0 || y>=board.length){
	    return false;
	}
	//base case: if on 0 and right number of moves
	if(board[x][y]==1 && currentMoveNumber==board.length*board.length){
	    return true;
	}
	//base case: if solves
	if(currentMoveNumber==board.length*board.length+1){
	    return true;
	}
	//base case: if on a bad number
	if(board[x][y]!=0){
	    return false;
	}
	board[x][y]=currentMoveNumber;
	if(solve(x+1,y+2,currentMoveNumber+1) || solve(x+1,y-2,currentMoveNumber+1) ||
	   solve(x-1,y+2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1) ||
	   solve(x+2,y+1,currentMoveNumber+1) || solve(x-2,y+1,currentMoveNumber+1) ||
	   solve(x+2,y-1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1)){
	    return true;
	}
	board[x][y]=0;	
	return false;
    }


}
