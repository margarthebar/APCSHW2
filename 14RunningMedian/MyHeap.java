import java.lang.Math;

public class MyHeap{
    public int[] data;
    public boolean max;

    public MyHeap(){// -> creates a max heap
	this(true);
    }
    public MyHeap(boolean isMax){
	data = new int[10];
	data[0]=0;
	max=isMax;
    }

    public String toString(){
	String ans = "";
	int levels = 1+(int)(Math.log((double)data[0])/Math.log(2.0));
	int numsOnLevel = 1;
	int counter = 1;
	int numTabs = (int)Math.pow(2.0,(double)levels-1);;
	for(int i=1; i<=data[0]; i++){
	    if(counter>numsOnLevel){
		ans+="\n";
		counter=1;
		numsOnLevel*=2;
		levels--;
		numTabs = (int)Math.pow(2.0,(double)levels-1);
		System.out.println();
	    }
	    System.out.println(numTabs);
	    for(int j=0; j<numTabs; j++){
		ans+="\t";
	    }
	    ans+=data[i];
	    numTabs = (int)Math.pow(2.0,(double)levels);
	    counter++;
	}

	return ans;
    }
 
    public void add(int n){// -> add the int to the heap
	grow();
        int spotIndex = data[0]+1;
	data[spotIndex]=n;
	data[0]+=1;
	pushUp(spotIndex);
    }
    public void grow(){
	int numElements = data[0]+1;
	if(numElements*2>=data.length){
	    int[] dt = new int[data.length*2];
	    for(int i=0; i<numElements; i++){
		dt[i]=data[i];
	    }
	    data=dt;
	}
    }
    public void pushUp(int i){
	if(i>1){
	    int diff = data[i]-data[i/2];
	    boolean swap=false;
	    if(max){
		swap = diff>0;
	    }else{
		swap = diff<0;
	    }
	    if(swap){
		int temp = data[i];
		data[i]=data[i/2];
		data[i/2]=temp;
		pushUp(i/2);
	    }
	}
    }
    public int pushDown(int i){
	if(peek()!=0 && i<data[0]){
	    int leftChild = i*2;
	    int rightChild = i*2+1;
	    int diff = 0;
	    int direction = -1;
	    boolean swap = false;
	    if(leftChild<=data[0]){
		diff = data[i]-data[leftChild];
		direction = 0;
	    }else if(rightChild<=data[0]){
		diff = data[i]-data[rightChild];
		direction = 1;
	    }
	    if(max){
	        swap = diff<0;
	    }else{
		swap = diff>0;
	    }
	    int temp = data[i];
	    if(swap){
		if(direction==0){
		    data[i]=data[leftChild];
		    data[leftChild]=temp;
		    pushDown(leftChild); 
		}else if(direction==1){
		    data[i]=data[rightChild];
		    data[rightChild]=temp;
		    pushDown(rightChild);
		}
	    }
	}
	return 0;
    }
    public int remove(){// -> remove the root and return the value  O(logn)
	int oldRoot = data[1];
	data[1]=data[data[0]];
	int index = 1;
	data[data[0]]=0;
	data[0]=data[0]-1;
	pushDown(1);
	return oldRoot;
    }
    public int peek(){// -> return the value of the root but do not remove it.  O(1)
	return data[1];
    }

    
}
