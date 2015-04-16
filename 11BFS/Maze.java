import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private int startx, starty;
    private char[][] board;
    private int[] solution = new int[0];

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
			startx = index;
			starty = i;
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
	    wait(200);
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
    ////////////////////////////////////////beginning of new code
    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(boolean animate){
	return solve(animate,1);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    private boolean solve(boolean animate, int mode){

	Frontier rest = new Frontier(mode);
	Coordinate start = new Coordinate(startx,starty);//startx and starty are instance variables in my maze class

	rest.add(start);//put the start into the Frontier 
		
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(true)+rest.toString());
	    }
	    //get the top
	    Coordinate next = rest.remove();
	    //check if solved
	    if(board[next.getR()][next.getC()]=='E'){
		//solved!
		solved = true;
		addCoordinatesToSolutionArray(next);
		tracePath();
		//my point class has a reference to previous points, so the solution will be determined from the final point
	    }else{
		//not solved, so add neighbors to Frontier and mark the floor with x.
		board[next.getR()][next.getC()]='x';
		for(Coordinate p : getNeighbors(next)){
		    if(p!=null){
			rest.add(p);
		    }
		}

	    }
	}
	return solved;
    }
    public void tracePath(){
        for(int i=0; i<solution.length; i+=2){
	    board[solution[i]][solution[i+1]]='@';
	}
	System.out.println(toString(true));
    }
    public void addCoordinatesToSolutionArray(Coordinate cor){
	String[] sol = new String[solution.length+1];
	String ans = "";
	Coordinate current = cor;
	while(current!=null){
	    ans = ""+current.getR()+","+current.getC()+","+ans;
	    current = current.getPrev();
	}
	sol = ans.split(",");
	int[] finished = new int[sol.length];
	for(int i=0; i<sol.length; i++){
	    finished[i] = Integer.parseInt(sol[i]);
	}
	solution = finished;
    }
    public Coordinate[] getNeighbors(Coordinate cor){
	Coordinate[] neighbors = new Coordinate[4];
	Coordinate move = new Coordinate(0,0);
	if(cor.getR()!=0 && board[cor.getR()-1][cor.getC()]!='#' && board[cor.getR()-1][cor.getC()]!='x'){
	    move = new Coordinate(cor.getR()-1,cor.getC());
	    move.setPrev(cor);
	    neighbors[0] = move;
	}
	if(cor.getR()!=board.length-1 && board[cor.getR()+1][cor.getC()]!='#' && board[cor.getR()+1][cor.getC()]!='x'){
	    move = new Coordinate(cor.getR()+1,cor.getC());
	    move.setPrev(cor);
	    neighbors[1] = move;
	}
	if(cor.getC()!=0 && board[cor.getR()][cor.getC()-1]!='#' && board[cor.getR()][cor.getC()-1]!='x'){
	    move = new Coordinate(cor.getR(),cor.getC()-1);
	    move.setPrev(cor);
	    neighbors[2] = move;
	}
	if(cor.getC()!=board[0].length-1 && board[cor.getR()][cor.getC()+1]!='#' && board[cor.getR()][cor.getC()+1]!='x'){
	    move = new Coordinate(cor.getR(),cor.getC()+1);
	    move.setPrev(cor);
	    neighbors[3] = move;
	}
	return neighbors;
    }
}
