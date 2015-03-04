public class makelakeDriver{
    public static void main(String[]args){
	String fileContents ="4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	makelake lake = new makelake(fileContents);
	System.out.println(lake.make());
    }
}
