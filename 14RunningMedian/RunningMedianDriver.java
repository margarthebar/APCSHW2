public class RunningMedianDriver{
    public static void main(String[]args){
	RunningMedian m = new RunningMedian();
	m.add(8);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(1);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(7);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(3);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(4);
	System.out.println(m.getMedian());
	System.out.println(m.toString());
	System.out.println();
	m.add(0);
	System.out.println(m.getMedian());
	System.out.println(m.toString());
	m.add(2);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(15);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(8);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
	m.add(16);
	//System.out.println(m.getMedian());
	//System.out.println(m.toString());
    }
}
