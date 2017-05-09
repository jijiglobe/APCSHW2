import java.util.*;
public class PQ<T>{
    private T[] queue;
    private int[] priorities;
    private int start,fin,size;
    
    public String name(){
	return "fairchild.jion";
    }

    public String getQueue(){
	/*String ans  = ""+queue[start];
	for(int x=0;x<size;x++){
	    ans+=","+queue[(start+x)%queue.length];
	}
	return ans;
	*/
	return Arrays.toString(priorities)+"\n"+Arrays.toString(queue);
    }

    @SuppressWarnings("unchecked")
    public PQ(){
	priorities = new int[15];
	Arrays.fill(priorities,-1);
	queue = (T[]) (new Object[15]);
        start = 7;
	fin = 7;
    }
    
    public void addFirst(T val, int priority){
	if(start!=fin || size==0){
	    if(start!=0){
		start--;
		size++;
		queue[start] = val;
		priorities[start] = priority;
	    }else{
		start = queue.length-1;
		size++;
		queue[start] = val;	
		priorities[start] = priority;
	    }
	}else{
	     enlarge(size*2);
	     addFirst(val,priority);
	}
	
    }
    public void addLast(T val, int priority){
	if(start!=fin || size==0){
	    if(fin<queue.length-1){
		fin++;
		size++;
		queue[fin-1] = val;
		priorities[fin-1] = priority;
	    }else{
		fin = 0;
		size++;
		queue[queue.length-1] = val;
		priorities[queue.length-1] = priority;
	    }
	}else{
	     enlarge(size*2);
	     addLast(val,priority);
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
	int[] pholder = new int[nsize];
	Arrays.fill(pholder,-1);
	int nstart = nsize/2;
	int nfin = nstart;
	int startholder = start;
	while(hasNext()){
	    holder[nfin] = removeFirst();
	    pholder[nfin] = priorities[startholder%queue.length];
	    startholder++;
	    nfin++;
	}
	queue = holder;
	priorities = pholder;
	start = nstart;
	fin = (nfin)%nsize;
	size = nsize/2;
	//System.out.println(Arrays.toString(queue));
    }

    public int Size(){
	return size;
    }

    public T removeSmallest(){
	int smallest = start;
	for(int x=0;x<priorities.length;x++){
	    if(priorities[x]!=-1 && priorities[x]<priorities[smallest]){
		smallest = x;
	    }
	}
	T pull = queue[smallest];
	if(start!=smallest){
	    priorities[smallest] = priorities[start];
	    priorities[start] = -1;
	}
	queue[smallest] = removeFirst();
	return pull;
    }

    public static void main(String[]args){
	PQ<Integer> deq = new PQ<Integer>();
	Random random = new Random();
	//	ArrayList<Integer> test = new ArrayList<Integer>();
	//ArrayList<Integer> athing = new ArrayList<Integer>();
	for(Integer x = 0;x<20;x++){
	    //System.out.println(deq.getQueue());
	    int p = random.nextInt(10);
	    //test.add(p);
	    System.out.println(p);
	    deq.addFirst(p,p);
	}
	//System.out.println(" ");
	//Arrays.sort(test);
	while(deq.hasNext()){
	    System.out.println(deq.getQueue());
	    //System.out.println(deq.removeSmallest());
	    //athing.add(deq.removeSmallest());
	    //System.out.println(athing.equals(test));
	}
    }
}
