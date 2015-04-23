public class MazeDriver{
    public static void main(String[]args){
	Maze m2 = new Maze("sampleMaze3.txt");
	System.out.println(m2.toString());
	m2.solveAStar(true);
    }
}
