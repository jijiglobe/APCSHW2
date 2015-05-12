public class MyHeap<T extends comparable>{
    private ArrayList<Integer> heap;
    private int next;
    private boolean isMax;

    public String toString(){
	return Arrays.toString(heap);
    }
    
    
    public MyHeap(boolean max){
	heap = new ArrayList<Integer>();
	next = 0;
	isMax = max;
    }

    public MyHeap(){
	this(true);
    }

    public int remove(){
	int holder = heap.get(0);
	next--;
	heap.set(0,heap.remove(next));
	
    }
    
    public void add(int x){
	heap.add(x);
	reorder(next);
	next++;
    }
    
    public int peak(){
	return heap.get(0);
    }

    private void swap(int x, int y){
	int holder =  heap.get(y);
	heap.set(y, heap.get(x));
	heap.set(x,holder);
    }

    private void reorder(int x){
	if(x!=0){
	    if(heap.get(x)>heap.get(x/2)){
		swap(x,x/2);
		reorder(x/2);
	    }
	}
    }
}
