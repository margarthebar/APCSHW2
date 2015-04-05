import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private Frontier front;
    
    private char[][] board;
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    /** Same constructor as before...*/
    public Maze(String filename){
	int lines=0;
	String input="";
	try{
	    File file = new File(filename);
	    Scanner sc = new Scanner(file);
	    //goes through scanner and reads for lines
	    while (sc.hasNextLine()) {
		lines++;
		String line = sc.nextLine();
		for(int i=0; i<line.length(); i++){
		    input+=line.charAt(i);
		}
		input+="/n";
	    }
	    String[] temp = input.split("/n");
	    board = new char[lines][temp[0].length()];
	    int index = 0;
	    //copies input from scanner into lines
	    for(String s: temp){
		for(int i=0; i<s.length(); i++){
		    if(s.charAt(i)=='S'){
			front = new Frontier(new LNodeBack<Coordinate>(new Coordinate(index,i)));
		    }
		    board[index][i] = s.charAt(i);
		}
		index++;
	    }

	    sc.close();
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

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public void branch(){
	
    }
    //public boolean solveBFS(boolean animate){}

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    //public boolean solveDFS(boolean animate){    }
    /*
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    */
}

/*
public class MazeSolver{
    public static char[][] mazeSolve(char[][] maze){
	int x = 0;
	int y = 0;
	char[][] copy = new char[maze.length][maze[0].length];
	for(int r=0; r<maze.length ; r++){
	    for(int c=0; c<maze[r].length ; c++){
		copy[r][c] = maze[r][c];
		if(maze[r][c]=='S'){
		    x = r;
		    y = c;
		}
	    }
	}
	System.out.println(toString(copy));
	System.out.println(x);
	System.out.println(y);
	return mazeHelp(copy,x,y);
    }
    public static char[][] mazeHelp(char[][] maze, int x, int y){
	return maze;
    }
    public static String toString(char[][] maze){
	String ans = "";
	for(int r=0; r<maze.length ; r++){
	    for(int c=0; c<maze[r].length ; c++){
		ans+=maze[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }
    public static void main(String[]args){
	char[][] maze = {
	    {'x','x','x','x','x','x'},
	    {'x','S','x',' ',' ','x'},
	    {'x',' ','x','x',' ','x'},
	    {'x',' ',' ',' ',' ','x'},
	    {'x',' ','x','x',' ','x'},
	    {'x',' ','x','E',' ','x'},
	    {'x',' ',' ','x',' ','x'},
	    {'x','x','x','x','x','x'}
	};
	System.out.println(toString(maze));
	System.out.println(toString(mazeSolve(maze)));
    }
}
*/
