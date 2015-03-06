public class quickSelect{
    public static void partition(int[] ary, int si, int ei){
	int[] d = new int[ary.length];
	for(int i=0; i<si; i++){
	    d[i]=ary[i];
	}
	for(int i=ei+1; i<ary.length; i++){
	    d[i]=ary[si];
	}
	int pivot = ary[si];
	for(int i=si; i<ei+1; i++){
	    if(ary[i]<pivot){
		d[si] = ary[i];
		si++;
	    }
	    if(ary[i]>pivot){
		d[ei] = ary[i];
		ei--;
	    }
	}
	ary[si] = pivot;
    }
    public static void main(String[] args){
	int[] a = {71,29,36,8,14,1,9,7,91,83,20};
	System.out.println(a.toString());
	partition(a,0,10);
	System.out.println(a.toString());
    }
}
