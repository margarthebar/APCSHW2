import java.lang.Math;

public class MyHeap{
    public int[] data;
    public boolean max;

    public String name(){
	return "Burkart,Margaret";
    }
    public MyHeap(){// -> creates a max heap
	this(true);
    }
    public MyHeap(boolean isMax){
	data = new int[10];
	data[0]=0;
	max=isMax;
    }
    public int size(){
	return data[0];
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
	    }
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
    private void swap(int i1, int i2){
	int temp = data[i1];
	data[i1]=data[i2];
	data[i2]=temp;
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
		swap(i,i/2);
		pushUp(i/2);
	    }
	}
    }
    public void pushDownMax(int i){
	int leftChild = i*2;
	int rightChild = i*2+1;
	int direction = -1;//-1 is none, 0 is left, 1 is right
	boolean swap = false;
	if(leftChild>data[0]){//if no children, don't swap
	    swap = false;
	}
	if(rightChild>data[0]){//if no right child, check to swap with left child
	    swap = data[leftChild]>data[i];
	    direction = 0;
	}else{
	    if(data[leftChild]>data[rightChild]){//if left child greater than right child
		swap = data[leftChild]>data[i];//if left child max, swap
		direction = 0;
	    }else{//right child greater than or equal to left child
		swap = data[rightChild]>data[i];//if right child max, swap
		direction = 1;
	    }
	}
	if(swap){
	    if(direction==0){
		swap(i,leftChild);
		pushDownMax(leftChild);
	    }else{
		swap(i,rightChild);
		pushDownMax(rightChild);
	    }
	}
    }
    public void pushDownMin(int i){
	//System.out.println(i);
        int leftChild = i*2;
	int rightChild = i*2+1;
	int direction = -1;//-1 is none, 0 is left, 1 is right
	boolean swap = false;
	if(i>size()){
	    swap = false;
	}else if(leftChild>data[0]){//if no children, don't swap
	    swap = false;
	}else if(rightChild>data[0]){//if no right child, check to swap with left child
		swap = data[leftChild]<data[i];
		direction = 0;
	    }else{
		if(data[leftChild]<data[rightChild]){//if left child less than right child
		    swap = data[leftChild]<data[i];//if left child min, swap
		    direction = 0;
		}else{//right child less than or equal to left child
		    swap = data[rightChild]<data[i];//if right child max, swap
		    direction = 1;
		}
	}
	if(swap){
	    if(direction==0){
		swap(i,leftChild);
		pushDownMin(leftChild);
	    }else{
		swap(i,rightChild);
		pushDownMin(rightChild);
	    }
	}
    }
    public void pushDown(int i){
	if(max){
	    pushDownMax(i);
	}else{
	    pushDownMin(i);
	}
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
