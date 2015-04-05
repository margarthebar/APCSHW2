public class Frontier{
    private LNodeBack<Coordinate> start;
    public LNodeBack<Coordinate> getStart(){
	return start;
    }
    public void setStart(LNodeBack<Coordinate> st){
	start = st;
    }

    private MyDeque<LNodeBack<Coordinate>> moves = new MyDeque<LNodeBack<Coordinate>>();
    
    public Frontier(LNodeBack<Coordinate> st){
	setStart(st);
	moves.addLast(st);
    }
    
    public String toString(){
	return moves.toString();
    }
    public void addMove(LNodeBack<Coordinate> cor){
	moves.addLast(cor);
    }
    public LNodeBack<Coordinate> getLast(){
	return moves.getLast();
    }
}
