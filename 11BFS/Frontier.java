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
    public LNodeBack<Coordinate> removeMove(){
	return moves.removeFirst();
    }
    public LNodeBack<Coordinate> getFirst(){
	return moves.getFirst();
    }
    public LNodeBack<Coordinate> getLast(){
	return moves.getLast();
    }
    public String printPath(){
	String ans = "[";
	MyStack<Coordinate> path = new MyStack<Coordinate>();
	LNodeBack<Coordinate> current = getLast();
	while(current.getPrev()!=null){
	    path.push(current.getValue());
	    current = current.getPrev();
	}
	path.push(current.getValue());
	while(!path.empty()){
	    ans+=path.pop().toString()+",";
	}
	ans+="]";
	return ans;
    }
}
