public class MyDequeDriver{
    public static void main(String[]args){
	MyDeque<Coordinate> dq = new MyDeque<Coordinate>();
	dq.add(new Coordinate(0,0),7);
	dq.add(new Coordinate(1,1),1);
	dq.add(new Coordinate(2,2),5);
	dq.add(new Coordinate(3,3),6);
	dq.add(new Coordinate(4,4),0);
	dq.add(new Coordinate(5,5),3);
	dq.add(new Coordinate(6,6),8);
	dq.add(new Coordinate(7,7),2);
	dq.add(new Coordinate(8,8),4);
	System.out.println(dq.toString());
	System.out.println(dq.removeSmallest().toString());//(4,4)
	System.out.println(dq.toString());
        System.out.println(dq.removeSmallest().toString());//(1,1)
	System.out.println(dq.toString());
        System.out.println(dq.removeSmallest().toString());//(7,7)
	System.out.println(dq.toString());
	System.out.println(dq.removeSmallest().toString());//(5,5)
	System.out.println(dq.toString());
	System.out.println(dq.removeSmallest().toString());//(8,8)
	System.out.println(dq.toString());
    }
}
