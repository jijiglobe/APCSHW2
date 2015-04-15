import java.util.*;
import java.lang.*;
public class PQ<T extends Comparable>{
    private T[] queue;
    private int start,fin,size;
    
    public String name(){
	return "fairchild.jion";
    }

    public T[] getQueue(){
	return queue;
    }

    @SuppressWarnings("unchecked")
    public PQ(){
	queue = (T[]) (new Object[15]);
        start = 7;
	fin = 7;
    }
    
    public void addFirst(T val){
	if(start!=fin || size==0){
	    if(start!=0){
		start--;
		size++;
		queue[start] = val;
	    }else{
		start = queue.length-1;
		size++;
		queue[start] = val;
	    }
	}else{
	     enlarge(size*2);
	     addFirst(val);
	}
	
    }
    public void addLast(T val){
	if(start!=fin || size==0){
	    if(fin<queue.length-1){
		fin++;
		size++;
		queue[fin-1] = val;
	    }else{
		fin = 0;
		size++;
		queue[queue.length-1] = val;
	    }
	}else{
	     enlarge(size*2);
	     addLast(val);
	}
    }
    
    //    public void enlarge(int nsize){
    public boolean hasNext(){
	return size!=0;
    }

    public T removeFirst(){
	if(start<queue.length-1){
	    size--;
	    start++;
	    return queue[start-1];
	}else{
	    size --;
	    start = 0;
	    return queue[queue.length-1];
	}
    }

	
    public T removeLast(){
	if(fin!=0){
	    fin--;
	    size--;
	    return queue[fin];
	}else{
	    fin = queue.length -1;
	    size --;
	    return queue[queue.length-1];
	}
    }

    @SuppressWarnings("unchecked")
    public void enlarge(int nsize){
        T[] holder = (T[]) (new Object[nsize]);
	int nstart = nsize/2;
	int nfin = nstart;
	while(hasNext()){
	    holder[nfin] = removeFirst();
	    nfin++;
	}
	queue = holder;
	start = nstart;
	fin = (nfin)%nsize;
	size = nsize/2;
	//System.out.println(Arrays.toString(queue));
    }

    public int Size(){
	return size;
    }

    public T removeSmallest(){
	T smallest = queue[start];
	for(int i=1;i<=size;i++){
	    if( queue[i].compareTo(smallest)<0){
		smallest = queue[i];
	    }
	}
	return smallest;
    }

    public T removeLargest(){
	return queue[start];
    }
    /*public static void main(String[]args){
	MyDeque<Integer> deq = new MyDeque<Integer>();
	for(Integer x = 0;x<20;x++){
	    System.out.println(Arrays.toString(deq.getQueue()));
	    deq.addFirst(x);
	}
	while(deq.hasNext()){
	    System.out.println(deq.removeFirst());

	}
	}*/
}
