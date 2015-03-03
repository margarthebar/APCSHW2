public class MergeSort{
    public static int[] mergeSort(int[] a){
	//base case: one element
	if(a.length==1){
	    return a;
	}
	//if more than one element
	int[] x = new int[a.length/2];
	int[] y = new int[a.length/2];
	for(int i=0; i<a.length/2; i++){
	    x[i] = a[i];
	}
	for(int j=0; j<a.length/2; j++){
	    y[j] = a[a.length/2+j];
	}
	return merge(mergeSort(x),mergeSort(y));
    }

    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
        int aIndex = 0;
	int bIndex = 0;
	int cIndex = 0;
	while(aIndex<a.length && bIndex<b.length){
	    if(a[aIndex]<=b[bIndex]){
		c[cIndex] = a[aIndex];
		aIndex+=1;
	    }else{
		c[cIndex] = b[bIndex];
		bIndex+=1;
	    }
	    cIndex+=1;
	}
	if(aIndex<a.length){
	    while(aIndex<a.length){
		c[cIndex] = a[aIndex];
		aIndex+=1;
		cIndex+=1;
	    }
	}
	if(bIndex<b.length){
	    while(bIndex<b.length){
		c[cIndex] = b[bIndex];
		bIndex+=1;
		cIndex+=1;
	    }
	}
	return c;
    }

    public static void main(String[]args){
	int[] a = {5,2,8,4,77,23,8,3,6,1245,987,3,3,1,22,76,23,13412,0,2,9};
	    int[] c = mergeSort(a);

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
