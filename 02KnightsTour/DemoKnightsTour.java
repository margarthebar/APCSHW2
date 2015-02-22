public class DemoKnightsTour{
    public static void main(String[]args){
	KnightsTour board = new KnightsTour(7);
	if(board.solve()){
	    System.out.println(board);
	}else{
	    System.out.println("No Solution!");
	}
    }
}
