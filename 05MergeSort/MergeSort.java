public class MergeSort{
    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	merge(a,b,c,0,0,0);
    }
    public static int[] merge(int[] a, int[] b, int[] c, int aIndex, int bIndex, int cIndex){
	if(a[0]<=b[0]){
	    c[cIndex]=a[aIndex];
	    merge(a,b,c,aIndex+1,bIndex,cIndex+1);
	}else{
	    c[cIndex]=b[bIndex];
	    merge(a,b,c,aIndex,bIndex+1,cIndex+1);
	}
    }
}
