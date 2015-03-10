public class quickSelect{
    public static void partition(int[] ary, int si, int ei){
    int[] d = new int[ary.length];
    for(int i=0; i<si; i++){
        d[i]=ary[i];
    }
    for(int i=ei+1; i<ary.length; i++){
        d[i]=ary[i];
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
    public static int partitionInPlace(int[] ary, int si, int ei){
    int pi = si+(int)(Math.random()*(ei-si+1));
    int pivot = ary[pi];
    int end = ei;
    int i = si;
    while(i<=end && si!=ei){
        if(ary[i]<pivot){
        int x = ary[i];
        ary[i] = ary[si];
        ary[si] = x;
        si++;
        if(x==pivot){
            pi = si;
        }else if(ary[i]==pivot){
            pi = i;
        }
        i++;
        }else if(ary[i]>pivot){
        int x = ary[i];
        ary[i] = ary[ei];
        ary[ei] = x;
        ei--;
        if(x==pivot){
            pi = ei;
        }else if(ary[i]==pivot){
            pi = i;
        }
        }else{
        i++;
        }
    }
    int x = ary[si];
    ary[si] = pivot;
    ary[pi] = x;
    System.out.println("pivot: "+pivot+" "+toString(ary));
    return pi;
    }
    public static int select(int[] ary, int index){
    return select(ary,index,0,ary.length-1);
    }
    public static int select(int[] ary, int index, int si, int ei){
    int pi = partitionInPlace(ary,si,ei);
    if(pi < index){
        return select(ary,index,pi+1,ei);
    }else if(pi > index){
        return select(ary,index,si,pi-1);
    }
    return ary[pi];
    }
    public static void quickSort(int[] ary){
    quickSort(ary,0,ary.length-1);
    }
    public static void quickSort(int[] ary, int si, int ei){
	if(si<ei){
	    int startsi = si;
	    int startei = ei;
	    int pi = si+(int)(Math.random()*(ei-si+1));
	    int pivot = ary[pi];
	    int end = ei;
	    int i = si;
	    while(i<=end && si!=ei){
		if(ary[i]<pivot){
		    int x = ary[i];
		    ary[i] = ary[si];
		    ary[si] = x;
		    si++;
		    if(x==pivot){
			pi = si;
		    }else if(ary[i]==pivot){
			pi = i;
		    }
		    i++;
		}else if(ary[i]>pivot){
		    int x = ary[i];
		    ary[i] = ary[ei];
		    ary[ei] = x;
		    ei--;
		    if(x==pivot){
			pi = ei;
		    }else if(ary[i]==pivot){
			pi = i;
		    }
		}else{
		    i++;
		}
	    }
        int x = ary[si];
        ary[si] = pivot;
        ary[pi] = x;
        System.out.println("pivot: "+pivot+" "+"si:"+si+" ei"+ei+" "+toString(ary));
        quickSort(ary,startsi,pi-1);
        quickSort(ary,pi+1,startei);
	}
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
    //System.out.println(toString(a));
    //System.out.println(select(a,7));
    //System.out.println(select(a,4));
    //System.out.println(select(a,2));
    quickSort(a);
    System.out.println(toString(a));
    }
}
