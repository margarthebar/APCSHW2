import java.util.*;
import java.io.*;
public class Maze{
    private static final String clear = "\033[2J";
    private static final String hide = "\033[?25l";
    private static final String show = "\033[?25h";
    private Frontier front;
    private Coordinate start;
    private boolean solved = false;
    private char[][] board;

    public Maze(String filename){
	int lines=0;
	int cols = 0;
	String input="";
	try{
	    File file = new File(filename);
	    Scanner sc = new Scanner(file);
	    input = sc.toString();
	    //goes through scanner and reads for lines
	    while (sc.hasNextLine()) {
		lines++;
		col=0;
		String line = sc.nextLine();
		for(int i=0; i<line.length(); i++){
		    input+=line.charAt(i);
		    cols++;
		}
		input+="/n";
	    }
	    System.out.println("c "+c);
	    System.out.println("input "+input);
	    sc.close();
	    board = new char[lines][cols];
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
		    //public boolean solveBFS(boolean animate){ }
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
		    public void dive(LNodeBack<Coordinate> current){
			Coordinate cor = current.getValue();
			System.out.println(toString(true));
			if(board[cor.getR()][cor.getC()]!='E'){
			    if(cor.getR()!=0 && board[cor.getR()-1][cor.getC()]!='#' && board[cor.getR()-1][cor.getC()]!='x'){
				Coordinate moveCor = new Coordinate(cor.getR()-1,cor.getC());
				LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
				move.setPrev(current);
				front.addMove(move);
				board[cor.getR()][cor.getC()]='x';
				dive(move);
				board[cor.getR()][cor.getC()]=' ';
				//System.out.println(front.printPath());
			    }
			    if(cor.getR()!=board.length-1 && board[cor.getR()+1][cor.getC()]!='#' && board[cor.getR()+1][cor.getC()]!='x'){
				Coordinate moveCor = new Coordinate(cor.getR()+1,cor.getC());
				LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
				move.setPrev(current);
				front.addMove(move);
				board[cor.getR()][cor.getC()]='x';
				dive(move);
				board[cor.getR()][cor.getC()]=' ';
				//System.out.println(front.printPath());
			    }
			    if(cor.getC()!=0 && board[cor.getR()][cor.getC()-1]!='#' && board[cor.getR()][cor.getC()-1]!='x'){
				Coordinate moveCor = new Coordinate(cor.getR(),cor.getC()-1);
				LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
				move.setPrev(current);
				front.addMove(move);
				board[cor.getR()][cor.getC()]='x';
				dive(move);
				board[cor.getR()][cor.getC()]=' ';
				//System.out.println(front.printPath());
			    }
			    if(cor.getC()!=board[0].length-1 && board[cor.getR()][cor.getC()+1]!='#' && board[cor.getR()][cor.getC()+1]!='x'){
				Coordinate moveCor = new Coordinate(cor.getR(),cor.getC()+1);
				LNodeBack<Coordinate> move = new LNodeBack<Coordinate>(moveCor);
				move.setPrev(current);
				front.addMove(move);
				board[cor.getR()][cor.getC()]='x';
				dive(move);
				board[cor.getR()][cor.getC()]=' ';
				//System.out.println(front.printPath());
			    }
			    front.removeMove();
			    //System.out.println(front.toString());
			    board[cor.getR()][cor.getC()]='x';
			}
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

		    //public boolean solveDFS(boolean animate){ }

		    public boolean solveDFS(boolean animate){
			LNodeBack<Coordinate> current = front.getFirst();
			Coordinate cor = current.getValue();
			dive(current);
			current = front.getFirst();
			if(board[cor.getR()][cor.getC()]=='E'){
			    MyStack<Coordinate> path = current.pathFind();
			    while(!path.empty()){
				Coordinate corPath = path.pop();
				board[corPath.getR()][corPath.getC()]='@';
			    }
			    solved = true;
			}
			return solved;
		    }
		    public boolean solveBFS(){
			return solveBFS(false);
		    }
		    public boolean solveDFS(){
			return solveDFS(false);
		    }
		}

	    }
