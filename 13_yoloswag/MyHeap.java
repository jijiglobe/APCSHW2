public class MyHeap<T extends comparable>{
    private int[] heap;
    private int next;
    private boolean isMax;

    public String toString(){
	return Arrays.toString(heap);
    }
    
    
    public MyHeap(boolean max){
	heap = new int[10];
	next = 0;
	isMax = max;
    }

    public MyHeap(){
	this(true);
    }

    public int remove(){
	return heap[0];
    }
    
    public void add(){
	return;
    }
    
    public int peak(){
	return heap[0];
    }

}
