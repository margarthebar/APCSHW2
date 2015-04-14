public class Coordinate{
    private int r = 0;
    private int c = 0;
    public int getR(){
	return r;
    }
    public int getC(){
	return c;
    }
    public void setR(int row){
	r = row;
    }
    public void setC(int col){
	c = col;
    }
    public Coordinate(int row, int col){
	setR(row);
	setC(col);
    }
    public String toString(){
	return "("+getR()+","+getC()+")";
    }
}
