import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
public class Sorts{
    //extra
    public static String name(){
	return "Burkart,Margaret";
    }
    public static int period(){
	return 6;
    }
    public static void insertionSort(int[]c){
	int x = 0;
	//test for each element in array
	for(int i=1;i<c.length;i++){
	    //compare to each element before it in the array
	    for(int j=0;j<i;j++){
		//if c[i]<c[j]
		if(c[i]<c[j]){
		    //store value to be moved towards the front
		    x = c[i];
		    //now shift everything over (k is just j)
		    for(int k=i;k>j;k--){
			c[k] = c[k-1];
		    }
		    //now add x to the vacant spot
		    c[j] = x;
		}
	    }
	}
    }

    public static void selectionSort(int[] c){
	int smallest = c[0];
	for(int i=0; i<c.length; i++){
	    smallest = c[i];
	    for(int j=i; j<c.length; j++){
		if(c[j]<smallest){
		    smallest = c[j];
		    c[j] = c[i];
		    c[i] = smallest;
		}
	    }
	}
    }

    public static void bubbleSort(int[]c){
	int temp = 0;
	for(int upper=c.length; upper>1; upper--){
	    for(int i=0; i<upper-1; i++){
		if(c[i+1]<c[i]){
		    temp = c[i];
		    c[i] = c[i+1];
		    c[i+1] = temp;
		}
	    }
	}
    }

     public static void radixSort(int[]c){
	int place = 10;
	ArrayList<ArrayList<Integer>> bucketArray = new ArrayList<ArrayList<Integer>>(10);
	//intialize buckets
	for(int i=0;i<10;i++){
	    bucketArray.add(new ArrayList<Integer>());
	}
	//find the necessary number of passes through the original array
	int digits = 1;
	for(int a:c){
	    if((""+a).length()>digits){
		digits = (""+a).length();
	    }   
	}
	//sort into buckets
	for(int i=0; i<digits; i++){
	    for(int a:c){
		bucketArray.get((a%place-a%(place/10))/(place/10)).add(a);
	    }
	    place*=10;
	    //copy values in order over to original array
	    int indexOriginal = 0;
	    for(ArrayList<Integer> a:bucketArray){
		for(int el:a){
		    c[indexOriginal]=el;
		    indexOriginal++;
		}
		//erase values in bucketArray for reuse
		a.clear();
	    }
	}
    }
     public static int[] mergeSort(int[] a){
	//base case: already sorted
	 boolean sorted = true;
	 for(int i=0; i<a.length-1; i++){
	     if(sorted && a[i]>a[i+1]){
		 sorted = false;
	     } 
	 }
	 if(sorted){
	     return a;
	 }

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

    public static void quickSort(int[] ary){
    quickSort(ary,0,ary.length-1);
    }
    public static void quickSort(int[] ary, int si, int ei){
	//System.out.println("si:"+si+" ei:"+ei);
	if(si<ei){
	    int startsi = si;
	    int startei = ei;
	    int equalsi = si;
	    int pi = si+(int)(Math.random()*(ei-si+1));
	    int pivot = ary[pi];
	    int end = ei;
	    int i = si;
	    while(i<=end && equalsi<=ei){
		if(ary[i]<pivot){
		    //System.out.println(i+" "+equalsi+" "+ary[i]+"<"+pivot);
		    int x = ary[i];
		    ary[i] = ary[si];
		    ary[si] = x;
		    si++;
		    equalsi++;
		    i++;
		    //System.out.println(Arrays.toString(ary));
		}else if(ary[i]==pivot){
		    //System.out.println(i+" "+equalsi+" "+ary[i]+"=="+pivot);
		    equalsi++;
		    i++;
		    //System.out.println(Arrays.toString(ary));
		}else if(ary[i]>pivot){
		    //System.out.println(i+" "+equalsi+" "+ary[i]+">"+pivot);
		    int x = ary[i];
		    ary[i] = ary[ei];
		    ary[ei] = x;
		    ei--;
		    //System.out.println(Arrays.toString(ary));
		}
	    }
	    //System.out.println("pivot: "+pivot+" "+Arrays.toString(ary));
        quickSort(ary,startsi,si-1);
        quickSort(ary,equalsi,startei);
	}
    }
    public static int[] randomArray(){
	Random rand = new Random(1000);
	int[] ans = new int[1000];
	for(int i=0;i<1000;i++){
	    ans[i] = rand.nextInt();
	    if(ans[i]<0){
		ans[i]*=-1;
	    }
	}
	return ans;
    }
     public static int[] randomArray(int size){
	Random rand = new Random(size);
	int[] ans = new int[size];
	for(int i=0;i<size;i++){
	    ans[i] = rand.nextInt();
	    if(ans[i]<0){
		ans[i]*=-1;
	    }
	}
	return ans;
    }
    public static int[] randomArray(int low, int high, int size){
	Random rand = new Random();
	int[] ans = new int[size];
	for(int i=0;i<size;i++){
	    ans[i] = rand.nextInt(high-low)+low;
	}
	return ans;
    }
    public static int[] randomArray(int low, int high){
	Random rand = new Random();
	int[] ans = new int[1000000];
	for(int i=0;i<1000000;i++){
	    ans[i] = rand.nextInt(high-low)+low;
	}
	return ans;
    }

    public static void main(String[]args){
	long startTime,endTime;

	int[] test = {11,7,8,9,6,1,8,2,5,8,52};
	int[] test0 = {0,0,0,0,0,0,0,0,0,0,0};
	int[] test01 = {0,0,0,0,0,0,0,0,0,0};
	int[] testSmall = {2,7,1,6,6,8,2,5,1,7,8,3,5,9,0,4};
	int[] testBig =  randomArray(-20,20,40);
	int[] testBigger = randomArray();
	int[] testBiggest = randomArray(1000000);

	
	quickSort(test);
	System.out.println(Arrays.toString(test));
	quickSort(test0);
	System.out.println(Arrays.toString(test0));
	quickSort(test01);
	System.out.println(Arrays.toString(test01));
	quickSort(testSmall);
	System.out.println(Arrays.toString(testSmall));
	quickSort(testBig);
	System.out.println(Arrays.toString(testBig));
	quickSort(testBigger);
	quickSort(testBiggest);

	
	/*int[] a = randomArray();
	startTime = System.currentTimeMillis();
	bubbleSort(a);
	endTime = System.currentTimeMillis();
	System.out.println("bubbleSort: "+(endTime-startTime));

	int[] b = randomArray();
	startTime = System.currentTimeMillis();
	insertionSort(b);
	endTime = System.currentTimeMillis();
	System.out.println("insertionSort: "+(endTime-startTime));

	int[] c = randomArray();
	startTime = System.currentTimeMillis();
	selectionSort(c);
	endTime = System.currentTimeMillis();
	System.out.println("selectionSort: "+(endTime-startTime));

	int[] d = randomArray();
	startTime = System.currentTimeMillis();
	radixSort(d);
	endTime = System.currentTimeMillis();
	System.out.println("radixSort: "+(endTime-startTime));

	int[] e = {1,2,2,3,4,5,6,6,7,8,8,9};
	startTime = System.currentTimeMillis();
	mergeSort(e);
	endTime = System.currentTimeMillis();
	System.out.println("mergeSort: "+(endTime-startTime));

	int[] f = {9,8,8,7,6,6,5,4,3,2,2,1};
	startTime = System.currentTimeMillis();
	mergeSort(f);
	endTime = System.currentTimeMillis();
	System.out.println("mergeSort: "+(endTime-startTime));

	int[] g = randomArray(1,4);
	startTime = System.currentTimeMillis();
	mergeSort(g);
	endTime = System.currentTimeMillis();
	System.out.println("mergeSort: "+(endTime-startTime));

	int[] h = randomArray(-1000000,1000001);
	startTime = System.currentTimeMillis();
	mergeSort(h);
	endTime = System.currentTimeMillis();
	System.out.println("mergeSort: "+(endTime-startTime));*/
    }
}
