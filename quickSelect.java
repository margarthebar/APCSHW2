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
	int end = ei+1;
	for(int i=si+1; i<end; i++){
	    if(ary[i]<pivot){
		d[si] = ary[i];
		si++;
	    }
	    if(ary[i]>pivot){
		d[ei] = ary[i];
		ei--;
	    }
	}
	d[si] = pivot;
	System.out.println(toString(d));
    }
    public static String toString(int[] a){
	String ans = "{";
	for(int i=0; i<a.length; i++){
	    ans+=a[i];
	    if(i!=a.length-1){
		ans+=",";
	    }
	}
	ans+="}";
	return ans;
    }
    public static void main(String[] args){
	int[] a = {71,29,36,8,14,1,9,7,91,83,20};
	System.out.println(toString(a));
	partition(a,0,10);
    }
}
