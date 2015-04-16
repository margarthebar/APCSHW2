public class Frontier{
    private Coordinate start;
    private int mode = -1;
    private MyDeque<Coordinate> moves = new MyDeque<Coordinate>();
    //mode 0 is BFS, mode 1 is DFS
    public String toString(){
	return moves.toString();
    }
    public Frontier(){
	this(-1);
    }
    public Frontier(int mode){
	this.mode = mode;
    }
    public Coordinate getStart(){
	return start;
    }
    public void setStart(Coordinate st){
	start = st;
    }
    public void add(Coordinate cor){
	if(moves.size()==0){
	    setStart(cor);
	}
	if(mode==0){
	    moves.addLast(cor);
	}else if(mode==1){
	    moves.addLast(cor);
	}else if(mode==2){
	    int priority = 0;//distance to the end
	    moves.addLast(cor);
	    moves.add(cor,priority);
	}else if(mode==3){
	    int priority = 1;//distance to the end + steps taken so far
	    moves.addLast(cor);
	    moves.add(cor,priority);
	}
    }
    public Coordinate remove(){
	Coordinate removed = new Coordinate(0,0);
	if(mode==0){
	    removed = moves.removeFirst();
	}else if(mode==1){
	    removed = moves.removeLast();
	}
	return removed;
    }
    public boolean hasNext(){
	return moves.size()!=0;
    }
    public Coordinate getFirst(){
	return moves.getFirst();
    }
    public Coordinate getLast(){
	return moves.getLast();
    }
}