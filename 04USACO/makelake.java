public class makelake{
    public int[][] land;
    public int waterElev, numMoves;

    public makelake(int rows, int cols, int elevation, int moves){
	land= new int[][]{ {28, 25, 20, 32, 34, 36},
		{27, 25, 20, 20, 30, 34},
		{24, 20, 20, 20, 20, 30},
		{20, 20, 14, 14, 20, 20} };
	waterElev = elevation;
	numMoves = moves;
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

    public static void main(String[] args){
	makelake lake = new makelake(4,6,22,2);
	System.out.println(lake);
	lake.stomp(1, 4, 4);
	System.out.println(lake);

    }

    

}
