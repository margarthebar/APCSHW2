import java.util.*;
import java.io.*;


public class NQueens{
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
	//build NQueens board
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[0].length; c++){
		for(int i=0; i<3-(""+board[r][c]).length(); i++){
		    ans+=" ";
		}
		ans+=board[r][c];
	    }
	    ans+="\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new int[size][size];		
    }

    

    public boolean solve(){
	for(int c=0; c<board.length; c++){
	    if(solve(0,c)){
		return true;
	    }
	}
	return false;			
    }


    public boolean solve(int x, int y){
	return solve(x,y,1);
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(150);

	//base case: if off board
	if(x<0 || x>=board[0].length || y<0 || y>=board.length){
	    return false;
	}

	//base case: if solves
	if(currentMoveNumber==board.length){
	    return true;
	}
	//base case: if threatened
	if(board[x][y]==-1){
	    return false;
	}
	//else
	board[x][y]=currentMoveNumber;
	////mark threatened spaces with a -1
	//////horizontal
	for(int c=0; c<board.length; c++){
	    if(c!=y){
		board[x][c]=-1;
	    }
	}
	//////vertical
	for(int r=0; r<board.length; r++){
	    if(r!=x){
		board[r][y]=-1;
	    }
	}
	//////TL to BR diagonal
	for(int i=-x; i<board.length-x; i++){
	    if(i!=0 && x+i>=0 && y+i>=0 && x+i<board.length && y+i<board.length){
		board[x+i][y+i]=-1;
	    }
	}
	//////BL to TL diagonal

	for(int c=0; c<board.length; c++){
	    if(solve(x+1,c,currentMoveNumber+1)){
		return true;
	    }
	}
	board[x][y]=0;
	return false;
    }


}
