import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private Frontier front;
    private Coordinate start;
    private boolean solved = false;
    
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
			start = new Coordinate(index,i);
			front = new Frontier(new LNodeBack<Coordinate>(start));
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
	    return hide+clear+toString()+show;
	}else{
	    return toString();
	}
    }
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public void branch(LNodeBack<Coordinate> current){
	Coordinate cor = current.getValue();
	if(cor.getR()!=0 && board[cor.getR()-1][cor.getC()]!='#' && board[cor.getR()-1][cor.getC()]!='x'){
	    Coordinate moveCor = new Coordinate(cor.getR()-1,cor.getC());
	    LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
	    move.setPrev(current);
	    front.addMove(move);
	    //System.out.println(front.printPath());
	}
	if(cor.getR()!=board.length-1 && board[cor.getR()+1][cor.getC()]!='#' && board[cor.getR()+1][cor.getC()]!='x'){
	    Coordinate moveCor = new Coordinate(cor.getR()+1,cor.getC());
	    LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
	    move.setPrev(current);
	    front.addMove(move);
	    //System.out.println(front.printPath());
	}
	if(cor.getC()!=0 && board[cor.getR()][cor.getC()-1]!='#' && board[cor.getR()][cor.getC()-1]!='x'){
	    Coordinate moveCor = new Coordinate(cor.getR(),cor.getC()-1);
	    LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
	    move.setPrev(current);
	    front.addMove(move);
	    //System.out.println(front.printPath());
	}
	if(cor.getC()!=board[0].length-1 && board[cor.getR()][cor.getC()+1]!='#' && board[cor.getR()][cor.getC()+1]!='x'){
	    Coordinate moveCor = new Coordinate(cor.getR(),cor.getC()+1);
	    LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
	    move.setPrev(current);
	    front.addMove(move);
	    //System.out.println(front.printPath());
	}
	front.removeMove();
	//System.out.println(front.toString());
	board[cor.getR()][cor.getC()]='x';
    }
    public boolean solveBFS(boolean animate){
	while(!solved){
	    if(animate){
		wait(200);
	    }
	    solveBFSHelper(animate);
	    System.out.println(toString(animate));
	}
	return true;
    }

    public void solveBFSHelper(boolean animate){
	LNodeBack<Coordinate> current = front.getFirst();
	Coordinate cor = current.getValue();
	if(board[cor.getR()][cor.getC()]=='E'){
	    MyStack<Coordinate> path = current.pathFind();
	    while(!path.empty()){
		Coordinate corPath = path.pop();
		board[corPath.getR()][corPath.getC()]='@';
	    }
	    solved = true;
	}else{
	    branch(current);
	}
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    //public boolean solveDFS(boolean animate){    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }
    /*
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
