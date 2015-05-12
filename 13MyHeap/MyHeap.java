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
	String ans = "[";
	for(int i=0; i<data.length; i++){
	    ans+=data[i]+",";
	}
	ans+="]";
	return ans;
    }

    /*public String toString(){
	String ans = "";
	int level = 1;
	int levelCounter = 0;
	for(int i=1; i<=data[0]; i++){
	    if(levelCounter<level){
		ans+=data[i];
		levelCounter++;
	    }else{
		ans+="\n"+data[i];
		levelCounter=1;
		level*=2;
	    }
	}
	return ans;
	}*/
    //public int remove(){}// -> remove the root and return it
    public void add(int n){// -> add the int to the heap
        int spotIndex = data[0]+1;
	data[spotIndex]=n;
	data[0]+=1;
	push(spotIndex);
    }
    /*
    public int findNextOpenSpot(){
	
	return 0;
    }
    public void resize(){

    }*/
    public void push(int i){
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
		push(i/2);
	    }
	}
    }
    
}
