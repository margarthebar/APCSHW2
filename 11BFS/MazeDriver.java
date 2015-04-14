public class MazeDriver{
    public static void main(String[]args){
<<<<<<< HEAD
	//Maze m = new Maze("sampleMaze.txt");
	Maze m = new Maze();
=======
	/*
	Maze m = new Maze("sampleMaze2.txt");
>>>>>>> 39f25642ce5c21908f9a8e5ab14af27e425a3154
	System.out.println(m.toString());
	m.solveBFS(true);

	Maze n = new Maze("sampleMaze.txt");
	System.out.println(n.toString());
	n.solveBFS();
	*/
	Maze m2 = new Maze("sampleMaze2.txt");
	System.out.println(m2.toString());
	m2.solveDFS(true);
    }
}
