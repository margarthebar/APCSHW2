public class makelake{
    public int[][] land;
    public int waterElev;
    public String[] in;
    public String[] original;
    public int[][] stomps;
    

    public makelake(String input){
	in = input.split("\n");
	original = in[0].split(" ");
	land = new int[Integer.parseInt(original[0])][Integer.parseInt(original[1])];
	stomps = new int[Integer.parseInt(original[3])][3];

	for(int i=1; i<stomps.length; i++){
	    String[] line = in[i].split(" ");
	    for(int j=0; j<line.length; j++){
		land[i-1][j] = Integer.parseInt(line[j]);
	    }
	}
	for(int i=in.length-stomps.length; i<in.length; i++){
	    String[] line = in[i].split(" ");
	    stomps[i-(in.length-stomps.length)][0] = Integer.parseInt(line[0]);
	    stomps[i-(in.length-stomps.length)][1] = Integer.parseInt(line[1]);
	    stomps[i-(in.length-stomps.length)][2] = Integer.parseInt(line[2]);
	}
	waterElev = Integer.parseInt(original[2]);
    }

    public int make(){
	for(int i=0; i<stomps.length; i++){
	    stomp(stomps[i][0],stomps[i][1],stomps[i][2]);
	}
	fill();
	return calculate();
    }

    public void stomp(int row, int col, int inches){
	int maxElevation = 0;
	int newElevation = 0;
	for(int r = -1; r <  2; r ++){
	    for(int c = -1; c < 2; c++){
		if(land[row+r][col+c] > maxElevation){
		    maxElevation = land[row+r][col+c];
		}
	    }
	    newElevation = maxElevation - inches;
	}
	for(int r=-1;r<2;r++){
	    for(int c=-1; c<2; c++){
		if(land[row+r][col+c] > newElevation){
		    land[row+r][col+c]=newElevation;
		}   
	    }
	}

    }

    public void fill(){
	for(int r = 0; r < land.length; r++){
	    for(int c =0; c <land[0].length; c++){
		if(land[r][c]>waterElev){
		    land[r][c]=0;
		}else{
		    land[r][c] = waterElev - land[r][c];
		}
	    }
	}
	
    }
    public int calculate(){
       int depth = 0;
       for(int r = 0; r < land.length; r++){
	    for(int c =0; c <land[0].length; c++){
		depth+=land[r][c];
	    }
	}
       return depth*(6*12)*(6*12);
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
