public class Coordinate{
    private int r = 0;
    private int c = 0;
    private Coordinate prev;
    public int getR(){
	return r;
    }
    public int getC(){
	return c;
    }
    public Coordinate getPrev(){
	return prev;
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
    public Coordinate(int row, int col){
	setR(row);
	setC(col);
    }
    public String toString(){
	return "("+getR()+","+getC()+")";
    }
}
