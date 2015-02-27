public class MergeSort{
    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	merge(a,b,c,0);
    }
    public static int[] merge(int[] a, int[] b, int[] c, int index){
	if(a[0]<=b[0]){
	    c[index]=a[0];
	}else{
	    c[index]=b[0];
	}
    }
}
