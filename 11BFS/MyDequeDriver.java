public class MyDequeDriver{
    public static void main(String[]args){
	Coordinate start = new Coordinate(3,16,null);
	Coordinate end = new Coordinate(3,1,null);
	Frontier front = new Frontier(start,end,2);
	Coordinate prev = start;

	front.add(prev);
	System.out.println(front.toString());
	prev = new Coordinate(3,15,prev);
	front.add(prev);
	System.out.println(front.toString());
	System.out.println(front.remove());
	System.out.println(front.toString());
	prev = new Coordinate(3,14,prev);
	front.add(prev);
	System.out.println(front.toString());
	System.out.println(front.remove());
	System.out.println(front.toString());
    }
}
