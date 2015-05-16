public class RunningMedianDriver{
    public static void main(String[]args){
	RunningMedian m = new RunningMedian();
	m.add(8);
	System.out.println(m.getMedian());
	m.add(1);
	System.out.println(m.getMedian());
	m.add(7);
	System.out.println(m.getMedian());
    }
}
