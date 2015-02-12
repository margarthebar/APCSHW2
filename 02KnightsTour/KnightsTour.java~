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
	for(int r=0; r<size; r++){
	    for(int c=0; c<size; c++){
		board[r][c]=-1;
	    }
	}
	board[0][0]=-1;			
    }

    

    public void solve(){
	solve(0,0);			
    }


    public void solve(int startx, int starty){
	solve(startx,starty,0);
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	//base case: if off board
	if(x<0 || x>=board[0].length || y<0 || y>board.length){
	    return false;
	}
	//base case: if on 0 and right number of moves
	if(board[x][y]==0 && currentMoveNumber==size*size-1){
	    return true;
	}
	//base case: if solves
	//base case: if on a bad number
	if(board
		
	return false;
    }


}
