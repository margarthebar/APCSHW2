public class ctravel{
    public int[][] land;
    public int seconds;
    public String[] original;
    public String[] coordinates;

    public ctravel(String input){
	String[] in = input.split("\n");
	original = in[0].split(" ");
	land = new int[Integer.parseInt(original[0])][Integer.parseInt(original[1])];
	seconds = Integer.parseInt(original[2]);
	coordinates = in[in.length-1].split(" ");
	for(int i=1; i<in.length-1; i++){
	    String[] line = in[i].split(" ");
	    for(int c=0; c<land[0].length; c++){
		land[i-1][c] = Integer.parseInt(line[i-1]);
	    }
	}
    }
}
