public class MergeSort{
    public static void mergeSort(int[] a){
	mergeSort(int[] a, int[] b);
    }
    public static int[] mergeSort(int[] a){
	//base case: one element
	if(a.length==1){
	    return a;
	}
	//if more than two elements
	int[] x = new int[a.length/2];
	int[] y = new int[a.length/2];
	for(int i=0; i<a.length/2; i++){
	    x[i] = a[i];
	}
	for(int j=a.length/2; j<a.length; j++){
	    y[j-a.length/2] = a[j];
	}
	return merge(mergeSort(x),mergeSort(y));
    }

    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	return merge(a,b,c,0,0,0);
    }
    public static int[] merge(int[] a, int[] b, int[] c, int aIndex, int bIndex, int cIndex){
	//if finished merging
	if(cIndex==c.length){
	    System.out.println("Done");
	    return c;
	}
	//if still b elements left over
	if(aIndex==a.length){
	    c[cIndex]=b[bIndex];
	    System.out.println("if still b elements left over");
	    return merge(a,b,c,aIndex,bIndex+1,cIndex+1);
	}
	//if still a elements left over
	if(bIndex==b.length){
	    c[cIndex]=a[aIndex];
	    System.out.println("if still a elements left over");
	    return merge(a,b,c,aIndex+1,bIndex,cIndex+1);
	}
	System.out.println("a[aIndex]: "+a[aIndex]+" b[bIndex]: "+b[bIndex]);
	if(a[aIndex]<=b[bIndex]){
	    c[cIndex]=a[aIndex];
	    System.out.println("if(a[aIndex]<=b[bIndex])");
	    return merge(a,b,c,aIndex+1,bIndex,cIndex+1);
	}else{
	    c[cIndex]=b[bIndex];
	    System.out.println("else");
	    return merge(a,b,c,aIndex,bIndex+1,cIndex+1);
	}
    }
    public static void main(String[]args){
	int[] a = {2,8,1,7,3,6,14};
	int[] b = {1,9,0,4,5,11,7};
	int[] c = merge(a,b);

	String ans="[";
	for(int i=0; i<c.length; i++){
	    ans+=c[i];
	    if(i<c.length-1){
		ans+=",";
	    }
	}
	ans+="]";
	System.out.println(ans);
    }
}
