public class ctravelDriver{
    public static void main(String[]args){
	String fileContents = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	ctravel field = new ctravel(fileContents);
	System.out.println(field);
	System.out.println(field.pathFind());
    }
}
