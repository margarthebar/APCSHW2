public class Coordinate{
    private int r = 0;
    private int c = 0;
    private Coordinate prev;
    private int steps=-1;
    public int getR(){
	return r;
    }
    public int getC(){
	return c;
    }
    public Coordinate getPrev(){
	return prev;
    }
    public int getSteps(){
	return steps;
    }
    public void setR(int row){
	r = row;
    }
    public void setC(int col){
	c = col;
    }
    public void setPrev(Coordinate prv){
	prev = prv;
    }
    public Coordinate(int row, int col, Coordinate c){
	setR(row);
	setC(col);
	setPrev(c);
	if(c!=null){
	    steps = c.getSteps()+1;
	}else{
	    steps = 0;
	}
    }
    public String toString(){
	return "("+getR()+","+getC()+")";
    }
}
