public class LNode<T>{
    private LNode<T> next,prev;
    private T value;

    public LNode(){
	this(null);
    }
    
    public LNode(T newval){
	setValue(newval);
    }
    
    public T getVal(){
	return value;
    }
    
    public LNode<T> getNext(){
	return next;
    }
    
    public void setValue(T newval){
	value = newval;
    }
    
    public void setNext(LNode<T> newnext){
	next = newnext;
    }
    
    public String toString(){
	return ""+value;
    }
    
    public LNode<T> getPrev(){
	return prev;
    }
    
    public void setPrev(LNode<T> np){
	prev = np;
    }
    
}
