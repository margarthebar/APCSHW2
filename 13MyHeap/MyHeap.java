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
    }
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
	
    }
    
}
