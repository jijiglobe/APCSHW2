import java.util.*;
import java.io.*;
public class MyLinkedList<T>{
    private LNode<T> initial,last;
    private int length;
    
    public MyLinkedList(){
	this(null);
    }
    
    public MyLinkedList(T data){
	initial = new LNode<T>(null); 
	initial.setNext(new LNode<T>(data));
	last = initial;
    }
    
    public String toString(){
	LNode<T> current = initial.getNext();
	String ans = "["+current;
	while(current.getNext() != null){
	    current = current.getNext();
	    ans +=", "+current;
	}
	return ans + "]";
    }
    
    public void add(T data){
	last.setNext(new LNode<T>(data));
	last.getNext().setPrev(last);
	last = last.getNext();
	length++;
    }
    
    public void add(T data, int i){
	LNode<T> current = getNode(i-1);
	LNode<T> nnode = new LNode<T>(data);
	nnode.setNext(current.getNext());
	current.setNext(nnode);
	length++;
    }
    
    private LNode<T> getNode(int i){
	LNode<T> current = initial;
	for(int x =0;x<i;x++){
	    current = current.getNext();
	}
	return current.getNext();
    }
    
    public T get(int i){
	return getNode(i).getVal();
    }

    public int size(){
	return length;
    }
    
    public T remove(int i){
	LNode<T> tbr = getNode(i);
	tbr.getPrev().setNext(tbr.getNext());
	tbr.getNext().setPrev(tbr.getPrev()); 
	length--;
	return tbr.getVal();
    }
    
    public static void main(String[]args){
	MyLinkedList<Integer> mine = new MyLinkedList<Integer>();
	ArrayList<Integer> theirs =  new ArrayList<Integer>();
	boolean isgood = true;
	for(int i=0;i<10;i++){
	    mine.add(i);
	    theirs.add(i);
	}
	for(int i=0;i<5;i++){
	    Random r =  new Random();
	    int x = r.nextInt(mine.size()-1);
	    mine.add(x,x);
	    theirs.add(x,x);
	}
	System.out.println(mine);
	System.out.println(theirs);
	System.out.println(mine.toString().equals(theirs.toString()));
	System.out.println(isgood);
    }

}
