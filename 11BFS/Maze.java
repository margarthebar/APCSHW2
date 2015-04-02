import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public char[][] maze = {
	    {'x','x','x','x','x','x'},
	    {'x','S','x',' ',' ','x'},
	    {'x',' ','x','x',' ','x'},
	    {'x',' ',' ',' ',' ','x'},
	    {'x',' ','x','x',' ','x'},
	    {'x',' ','x','E',' ','x'},
	    {'x',' ',' ','x',' ','x'},
	    {'x','x','x','x','x','x'}
	};
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    /** Same constructor as before...*/
    public String toString(){
	String ans = "";
	for(int r=0; r<maze.length ; r++){
	    for(int c=0; c<maze[r].length ; c++){
	        ans+=maze[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }

    /*
    public Maze(){
	board[0] = {'S','-','-','-','-'};
	board[1] = {'-','#','#','#','-'};
	board[2] = {'-','-','-','#','-'};
	board[3] = {'-','#','-','#','-'};
	board[4] = {'-','-','-','#','E'};
    }
    public Maze(String filename){
	int r=0;
	int c=0;
	String input = "";
	try{
	    File file = new File(filename);
	    Scanner sc = new Scanner(file);
	    input = sc.toString();
	    System.out.println(input);
	    while (sc.hasNext()) {
		input += sc.next();
		if(input.substring(input.length()-2,input.length()).equals("\n")){
		    r++;
		    input += sc.next();
		    c = input.length()-2;
		}
	    }
	    System.out.println("c "+c);
	    board = new char[r][c];
	    System.out.println("input "+input);
	    sc.close();
	    board = new char[5][5];
	    int row = 0;
	    int col = 0;
	    for(int i=0; i<input.length()-1; i++){
		if(input.substring(i,i+2).equals("\n")){
		    row++;
		    System.out.println("detected");
		}else{
		    System.out.println(input.charAt(i));
		    System.out.println(board[row][col]);
		    board[row][col]=input.charAt(i);
		    col++;
		}
	    }
	}catch(FileNotFoundException e){

	}
    }

    public String toString(){
	String ans = "";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[0].length; c++){
		ans+=board[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }

    public String toString(boolean animate){
	if(animate){
	    return clear+hide+toString()+show;
	}else{
	    return toString();
	}
    }
*/


    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */

    //public boolean solveBFS(boolean animate){    }


    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */

    //public boolean solveDFS(boolean animate){    }

}

