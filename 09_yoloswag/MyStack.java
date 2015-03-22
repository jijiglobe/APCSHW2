public class MyStack<T> extends MyLinkedList<T>{
    public boolean empty(){
	return get(0).equals(null);
    }
    public T peek(){
	return get(0);
    }
    public T pop(){
	T ans = peek();
	remove(0);
	return ans;
    }
    public T push(T data){
	add(data,0);
	return data;
    }
    public int search(T data){
	//LNode<T> current = getNode(0);
	LNode<T> current = getNode(0);
	int pos = 0;
	while(!current.equals(null)){
	    if(current.getVal().equals(data)){
		return pos;
	    }
	    current = current.getNext();
	    pos++;
	    
	}
	return -1;
    }	    
}
