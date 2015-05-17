import java.util.*;
public class MyHeap{
    private ArrayList<Integer> heap;
    private int next;
    private boolean isMax;

    public String name(){
	return "Jion Fairchild";
    }

    public String toString(){ 
	String ans = "[";
	for(Integer x : heap){
	    ans+=x+",";
	}
	return ans.substring(0,ans.length()-1)+"]";
    }
        
    public MyHeap(boolean max){
	heap = new ArrayList<Integer>();
	heap.add(0);
	next = 1;
	isMax = max;
    }

    public MyHeap(){
	this(true);
    }
    
    public int Size(){
	return heap.size()-1;
    }

    public int remove(){
	if(heap.size()<3){
	    next--;
	    return heap.remove(1);
	}
	int holder = heap.get(1);
	next--;
	heap.set(1,heap.remove(heap.size()-1));
	backOrder(1);
	return holder;
	
    }
    
    public void add(int x){
	heap.add(x);
	reorder(next);
	next++;
    }
    
    public int peek(){
	return heap.get(1);
    }

    private void swap(int x, int y){
	int holder =  heap.get(y);
	heap.set(y, heap.get(x));
	heap.set(x,holder);
    }

    public boolean inOrder(int x,int y){
	if(isMax){
	    return x>y;
	}else{
	    return !(x>y);
	}
    }

    private void reorder(int x){
	if(x>1){
	    if(inOrder(heap.get(x),heap.get(x/2))){
		swap(x,x/2);
		reorder(x/2);
	    }
	}
    }


    public void backOrder(int x){
	int left = x*2;
	int right = x*2 +1;
	int swapper;
	System.out.println(this);
	try{
	    if(inOrder(heap.get(left),heap.get(right))
	       ){
		swapper = left;
	    }else{
		swapper = right;
	    }
	    
	    if(inOrder(heap.get(swapper),heap.get(x))){
		swap(x,swapper);
		backOrder(swapper);
	    }
	    
	} catch(IndexOutOfBoundsException e){
	    return;
	}
    }
    public static void main(String[]args){
	MyHeap mine = new MyHeap(false);
	Random random = new Random(2);
	for(int x=0;x<8;x++){
	    int y = random.nextInt(10);
	    mine.add(y);
	    /*if(random.nextBoolean()){
		mine.remove();
		}*/
	    System.out.println(y);
	}
	System.out.println("GANGSTA");
	for(int x=0;x<8;x++){
	    //System.out.println(mine);
	    System.out.println(mine.remove());
	}
    }

}
