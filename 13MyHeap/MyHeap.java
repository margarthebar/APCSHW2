public class MyHeap{
    public int[] data;

    public MyHeap(){// -> creates a max heap
	data = new int[10];
	data[0]=0;
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
		ans+=""+data[i];
		levelCounter=0;
		level++;
	    }
	}
	return ans;
    }
    //public int remove(){}// -> remove the root and return it
    public void add(int n){// -> add the int to the heap
        int spotIndex = data[0]+1;
	data[spotIndex]=n;	
    }
    /*
    public int findNextOpenSpot(){
	
	return 0;
    }
    public void resize(){

    }
    public void push(int i){

    }
    */
}
