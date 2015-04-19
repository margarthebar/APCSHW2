import java.lang.Math;
public class Frontier{
    private Coordinate start;
    private Coordinate end;
    private int mode = -1;
    private MyDeque<Coordinate> moves = new MyDeque<Coordinate>();
    //mode 0 is BFS, mode 1 is DFS, mode 2 is Best, mode 3 is AStar
    public String toString(){
	return moves.toString();
    }
    public Frontier(Coordinate st, Coordinate nd, int mode){
	setStart(st);
	setEnd(nd);
	this.mode = mode;
    }
    public Coordinate getStart(){
	return start;
    }
    public void setStart(Coordinate st){
	start = st;
    }
    public Coordinate getEnd(){
	return end;
    }
    public void setEnd(Coordinate nd){
	end = nd;
    }
    public int distance(Coordinate cor){
	if(cor!=null){
	    return Math.abs(cor.getR()-end.getR()) + Math.abs(cor.getC()-end.getC());
	}else{
	    return -1;
	}
    }
    public void add(Coordinate cor){
	if(mode==0){
	    moves.addLast(cor);
	}else if(mode==1){
	    moves.addLast(cor);
	}else if(mode==2){
	    int priority = distance(cor);//distance to the end
	    moves.add(cor,priority);
	}else if(mode==3){
	    int priority = distance(cor)+cor.getSteps();//distance to the end + steps taken so far
	    moves.add(cor,priority);
	}
    }
    public Coordinate remove(){
	Coordinate removed;
	if(mode==0){
	    removed = moves.removeFirst();
	}else if(mode==1){
	    removed = moves.removeLast();
	}else if(mode==2){
	    removed = moves.removeSmallest();
	    System.out.println("2 "+moves.toString()+" removed: "+removed);
	    //System.out.println(moves.toString());
	}else if(mode==3){
	    removed = moves.removeSmallest();
	    System.out.println("3 "+moves.toString()+" removed: "+removed);
	    //System.out.println(moves.toString());
	}else{
	    removed = new Coordinate(0,0,null);
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
