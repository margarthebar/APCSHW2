public class MazeSolver{
    public static char[][] mazeSolve(char[][] maze){
	int x,y;
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
	return mazeHelp(copy,x,y);
    }
    public static char[][] mazeHelp(char[][] maze, int x, int y){
	return maze;
    }

    public static void main(String[]args){
	
    }
}
