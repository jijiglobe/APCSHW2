import java.util.*;
public class MyDeque<T>{
    private T[] queue;
    private int start,fin,size;
    
    public String name(){
	return "fairchild.jion";
    }

    public MyDeque(){
	queue = new T[10];
        start = 4;
	fin = 4;
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
	size--;
	start++;
	return queue[start-1];
    }
	
    public T removeLast(){
	fin--;
	size--;
	return queue[fin++];
    }
    
    
}
