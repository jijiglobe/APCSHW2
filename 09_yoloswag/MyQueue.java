public class MyQueue<T> extends MyLinkedList<T>{
    public T element(){
	return get(0);
    }
    public boolean offer(T val){
	return add(val);
    }
    public T peek(){
	return get(0);
    }
    public T poll(){
	T val = peek();
	remove(0);
	return val;
    }
    public T remove(){
	T val = peek();
	remove(0);
	return val;
    }
    public T dequeue(){
	return remove();
    }
    public boolean enqueue(T val){
	return add(val);
    }
}
