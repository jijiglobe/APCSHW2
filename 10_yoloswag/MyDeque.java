import java.util.*;
public class MyDeque<T>{
    private T[] queue;
    private int start,fin,size;
    
    public String name(){
	return "fairchild.jion";
    }

    @SuppressWarnings("unchecked")
    public MyDeque(){
	queue = (T[]) (new Object[15]);
        start = 7;
	fin = 7;
    }
    
    public void addFirst(T val){
	if(size<queue.length){
	    start--;
	    size++;
	    queue[start] = val;
	}else{
	    enlarge(size*2);
	}
	addFirst(val);
    }
    
    //    public void enlarge(int nsize){
    public boolean hasNext(){
	return start!=fin;
    }

    public T removeFirst(){
	if(start!=queue.length){
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
	    return queue[fin++];
	}else{
	    fin = queue.length -1;
	    size --;
	    return queue[0];
	}
    }

    @SuppressWarnings("unchecked")
    public void enlarge(int nsize){
        T[] holder = (T[]) (new Object[nsize]);
	start =nsize/2;
	fin = start;
	while(hasNext()){
	    holder[fin] = removeLast();
	    fin++;
	}
	queue = holder;
    }
}
