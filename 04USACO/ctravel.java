public class ctravel{
    public String[][] land;
    public int seconds;
    public String[] original;
    public String[] coordinates;

    public ctravel(String input){
	String[] in = input.split("\n");
	original = in[0].split(" ");
	land = new String[Integer.parseInt(original[0])][Integer.parseInt(original[1])];
	seconds = Integer.parseInt(original[2]);
	coordinates = in[in.length-1].split(" ");
	System.out.println(this);
	for(int i=1; i<in.length-1; i++){
	    for(int c=0; c<land[0].length; c++){
		land[i-1][c] = in[i].substring(c,c+1);
	    }
	}
    }
    public String toString(){
	String res = "";
	for(int i=0; i<land.length; i++){
	    for(int j=0; j<land[0].length; j++){
		res += land[i][j] + " ";
	    }
	    res += "\n";
	}
	return res;

    } 
}
