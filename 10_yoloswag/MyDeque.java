import java.util.*;
public class MyDeque<T>{
    private T[] queue;
    private int start,fin,size;
    
    public String name(){
	return "fairchild.jion";
    }

    public T[] getQueue(){
	return queue;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(){
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
	fin = nfin;
	size = nsize/2;
    }

    public static void main(String[]args){
	MyDeque<Integer> deq = new MyDeque<Integer>();
	for(Integer x = 0;x<20;x++){
	    deq.addFirst(x);
	    //System.out.println(Arrays.toString(deq.getQueue()));
	}
	while(deq.hasNext()){
	    System.out.println(deq.removeFirst());

	}
    }
}
