public class MazeDriver{
    public static void main(String[]args){
	Maze m = new Maze("sampleMaze2.txt");
	System.out.println(m.toString());
	m.solveBFS(true);
    }
}
