public class MergeSort{
    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	merge(a,b,c,0,0,0);
    }
    public static int[] merge(int[] a, int[] b, int[] c, int aIndex, int bIndex, int cIndex){
	//if finished merging
	if(cIndex==c.length){
	    return c;
	}
	//if still b elements left over
	if(aIndex==a.length){
	    c[cIndex]=b[bIndex];
	    merge(a,b,c,aIndex,bIndex+1,cIndex+1);
	}
	//if still a elements left over
	if(bIndex==b.length){
	    c[cIndex]=a[aIndex];
	    merge(a,b,c,aIndex+1,bIndex,cIndex+1);
	}
	if(a[0]<=b[0]){
	    c[cIndex]=a[aIndex];
	    merge(a,b,c,aIndex+1,bIndex,cIndex+1);
	}else{
	    c[cIndex]=b[bIndex];
	    merge(a,b,c,aIndex,bIndex+1,cIndex+1);
	}
    }
    public static void main(String[]args){
	int[] a = {2,8,1,7,3,6,14};
	int[] b = {1,9,0,4,5,11,7};
	int[] c = merge(a,b);

	System.out.println(c);
    }
}
