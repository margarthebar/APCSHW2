public class DemoNQueens{
    public static void main(String[]args){
	NQueens board = new NQueens(8);
	if(board.solve()){
	    System.out.println(board);
	}else{
	    System.out.println("No Solution!");
	}
    }
}
