import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private Frontier front;
    private Coordinate start;
    private boolean solved = false;
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
			start = new Coordinate(index,i);
			startx = index;
			starty = i;
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
    public boolean dive(LNodeBack<Coordinate> current){
	Coordinate cor = current.getValue();
	System.out.println(toString());
	if(board[cor.getR()][cor.getC()]=='#'){
	    current=current.getPrev();
	    System.out.println("current "+current.getValue().toString());
	    front.removeLast();
	    return false;
	}
	if(board[cor.getR()][cor.getC()]=='E'){
	    MyStack<Coordinate> path = current.pathFind();
	    while(!path.empty()){
		Coordinate corPath = path.pop();
		board[corPath.getR()][corPath.getC()]='@';
	    }
	    solved = true;
	    return true;
	}
	if(board[cor.getR()][cor.getC()]=='x'){
	    current = current.getPrev();
	    front.removeLast();
	    System.out.println("current "+current.getValue().toString());
	    return false;
	}
	board[cor.getR()][cor.getC()]='@';
	front.addMove(current);
	if(dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR()-1,cor.getC()))) ||
	   dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR()+1,cor.getC()))) ||
	   dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR(),cor.getC()-1))) ||
	   dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR(),cor.getC()+1)))){
	    solved = true;
	    return true;
	}
	if(board[cor.getR()-1][cor.getC()]==' '){
	    board[cor.getR()][cor.getC()]='@';
	    dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR()-1,cor.getC())));
	}
	if(board[cor.getR()+1][cor.getC()]==' '){
	    board[cor.getR()][cor.getC()]='@';
	    dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR()+1,cor.getC())));
	}
	if(board[cor.getR()][cor.getC()-1]==' '){
	    board[cor.getR()][cor.getC()-1]='@';
	    dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR(),cor.getC()-1)));
	}
	if(board[cor.getR()][cor.getC()+1]==' '){
	    board[cor.getR()][cor.getC()]='@';
	    dive(new LNodeBack<Coordinate>(new Coordinate(cor.getR(),cor.getC()+1)));
	}
	board[cor.getR()][cor.getC()]='x';
	return false;
    }

    public boolean solveBFS(boolean animate){
	while(!solved){
	    if(animate){
		wait(100);
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
    public boolean solveDFS(boolean animate){ 
	LNodeBack<Coordinate> current = front.getFirst();
	System.out.println(toString(true));
	return dive(current);
    }

    public void solveDFSHelper(boolean animate){

    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }
    
    public boolean solveDFS(){
	return solveDFS(false);
    }
    ////////////////////////////////////////beginning of new code
    private boolean solve(boolean animate, int mode){

	Frontier rest = new Frontier(mode);
	Coordinate start = new Coordinate(startx,starty);//startx and starty are instance variables in my maze class

	rest.add(start);//put the start into the Frontier 
		
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(true));
	    }
	    //get the top
	    Coordinate next = rest.remove();
	    //check if solved
	    if(board[next.getR()][next.getC()]=='E'){
		//solved!
		solved = true;
		addCoordinatesToSolutionArray(next);
		//my point class has a reference to previous points, so the solution will be determined from the final point
	    }else{
		//not solved, so add neighbors to Frontier and mark the floor with x.
		board[next.getR()][next.getC()]='x';
		for(Coordinate p : getNeighbors(next)){
		    rest.add(p);
		}

	    }
	}
	return solved;
    }
    //Frontier must have hasNext()
    public void addCoordinatesToSolutionArray(Coordinate cor){
	int[] sol = new int[solution.length+2];
	sol[solution.length] = cor.getR();
	sol[solution.length+1] = cor.getC();
	solution = sol;
    }
    public Coordinate[] getNeighbors(Coordinate cor){
	Coordinate[] neighbors = new Coordinate[0];
	Coordinate move = new Coordinate(0,0);
	if(cor.getR()!=0 && board[cor.getR()-1][cor.getC()]!='#' && board[cor.getR()-1][cor.getC()]!='x'){
	    move = new Coordinate(cor.getR()-1,cor.getC());
	}
	if(cor.getR()!=board.length-1 && board[cor.getR()+1][cor.getC()]!='#' && board[cor.getR()+1][cor.getC()]!='x'){
	    move = new Coordinate(cor.getR()+1,cor.getC());
	}
	if(cor.getC()!=0 && board[cor.getR()][cor.getC()-1]!='#' && board[cor.getR()][cor.getC()-1]!='x'){
	    move = new Coordinate(cor.getR(),cor.getC()-1);
	}
	if(cor.getC()!=board[0].length-1 && board[cor.getR()][cor.getC()+1]!='#' && board[cor.getR()][cor.getC()+1]!='x'){
	    move = new Coordinate(cor.getR(),cor.getC()+1);
	}
	move.setPrev(cor);
	Coordinate[] neighs = new Coordinate[neighbors.length+1];
	neighs[neighbors.length] = move;
	neighbors = neighs;
	return neighbors;
    }
}
