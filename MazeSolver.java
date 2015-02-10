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
