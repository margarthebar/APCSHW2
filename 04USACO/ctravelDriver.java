public class ctravelDriver{
    public static void main(String[]args){
	String fileContents = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	ctravel field = new ctravel(fileContents);
	System.out.println(field);
	System.out.println(field.pathFind());

	String fileContents1 = "3 3 4\n...\n...\n...\n1 1 3 3";
	ctravel field1 = new ctravel(fileContents1);
	System.out.println(field1);
	System.out.println(field1.pathFind());

	String fileContents2 = "5 5 14\n....*\n.....\n..*..\n.....\n*....\n1 1 5 5";
	ctravel field2 = new ctravel(fileContents2);
	System.out.println(field2);
	System.out.println(field2.pathFind());

	String fileContents3 = "7 7 22\n....*..\n.*.....\n..*...*\n.......\n*...*..\n.*.....\n....*..\n1 1 7 7";
	ctravel field3 = new ctravel(fileContents3);
	System.out.println(field3);
	System.out.println(field3.pathFind());
    }
}
