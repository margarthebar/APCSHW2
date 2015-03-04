import java.lang.Math;
public class ctravel{
    public String[][] land;
    public int seconds;
    public String[] original;
    public String[] coordinates;
    public int paths = 0;

    public ctravel(String input){
	String[] in = input.split("\n");
	original = in[0].split(" ");
	land = new String[Integer.parseInt(original[0])][Integer.parseInt(original[1])];
	seconds = Integer.parseInt(original[2]);
	coordinates = in[in.length-1].split(" ");
	for(int i=1; i<in.length-1; i++){
	    for(int c=0; c<land[0].length; c++){
		land[i-1][c] = in[i].substring(c,c+1);
	    }
	}
    }
    public int pathFind(){
	pathFind(Integer.parseInt(coordinates[0])-1,Integer.parseInt(coordinates[1])-1,Integer.parseInt(coordinates[2])-1,Integer.parseInt(coordinates[3])-1,seconds);
	return paths;
    }
    public boolean pathFind(int r1, int c1, int r2, int c2, int sec){
	//base case: if off land
	if(r1<0 || r1>=land.length || c1<0 || c1>=land[0].length){
	    return false;
	}
	//base case: if moves gone
	if(sec==0){
	    if(r1==r2 && c1==c2){
		return true;
	    }
	    return false;
	}
	//base case: if solution not possible
	if(Math.abs(r1-r2)+Math.abs(c1-c2)>sec){
	    return false;
	}
	//base case: if *
	if(!land[r1][c1].equals(".")){
	    return false;
	}
	//else
	if(pathFind(r1,c1+1,r2,c2,sec-1)){
	    paths+=1;
	}
	if(pathFind(r1,c1-1,r2,c2,sec-1)){
	    paths+=1;
	}
	if(pathFind(r1+1,c1,r2,c2,sec-1)){
	    paths+=1;
	}
	if(pathFind(r1-1,c1,r2,c2,sec-1)){
	    paths+=1;
	}
	return false;
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
