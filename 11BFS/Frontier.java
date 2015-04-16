public class Frontier{
    private LNodeBack<Coordinate> start;
    private int mode = -1;
    //mode 0 is BFS, mode 1 is DFS
    public Frontier(){
	this(-1);
    }
    public Frontier(int mode){
        this.mode = mode;
    }
    public Frontier(LNodeBack<Coordinate> st){
	setStart(st);
	moves.addLast(st);
    }

    public void add(Coordinate cor){
	LNodeBack<Coordinate> node = new LNodeBack<Coordinate>(cor);
	if(moves.size()==0){
	    setStart(node);
	}
	if(mode==0){
	    moves.addLast(node);
	}else if(mode==1){
	    moves.addLast(node);

	}
    }
    public Coordinate remove(){
	Coordinate removed = new Coordinate(0,0);
	if(mode==0){
	    removed = moves.removeFirst().getValue();
	}else if(mode==1){
	    removed = moves.removeLast().getValue();
	}
	return removed;
    }
    public boolean hasNext(){
	return moves.size()!=0;
    }

    public LNodeBack<Coordinate> getStart(){
	return start;
    }
    public void setStart(LNodeBack<Coordinate> st){
	start = st;
    }

    private MyDeque<LNodeBack<Coordinate>> moves = new MyDeque<LNodeBack<Coordinate>>();
    
    public String toString(){
	return moves.toString();
    }
    public void addMove(LNodeBack<Coordinate> cor){
	moves.addLast(cor);
    }
    public LNodeBack<Coordinate> removeMove(){
	return moves.removeFirst();
    }
    public LNodeBack<Coordinate> removeLast(){
	return moves.removeLast();
    }
    public LNodeBack<Coordinate> getFirst(){
	return moves.getFirst();
    }
    public LNodeBack<Coordinate> getLast(){
	return moves.getLast();
    }
    public String printPath(){
	String ans = "[";
	MyStack<Coordinate> path = getLast().pathFind();
	while(!path.empty()){
	    Coordinate cor = path.pop();
	    ans+=cor.toString()+",";
	}
	ans+="]";
	return ans;
    }
}
