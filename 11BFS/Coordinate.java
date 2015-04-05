public class Coordinate{
    private int x = 0;
    private int y = 0;
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setX(int ex){
	x = ex;
    }
    public void setY(int why){
	y = why;
    }
    public Coordinate(int ex, int why){
	setX(ex);
	setY(why);
    }
    public String toString(){
	return "("+getX()+","+getY()+")";
    }
}
