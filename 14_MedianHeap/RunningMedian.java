import java.util.*;
public class RunningMedian{
    MyHeap greater,lesser;
    Integer median;
    // ArrayList<Integer> overkill;

    public String name(){
	return "Jion Fairchild";
    }
    
    public RunningMedian(){
	greater = new MyHeap(false);
	lesser = new MyHeap();
	//overkill = new ArrayList<integer>();
    }

    /*public void store(){
	if(overkill.size()>2){
	    int lower = overkill.remove(0);
	    int higher = overkill.remove(0);
	    int med = overkill.remove(0);
	    if(lower>med){
		int store = higher;
		higher = med;
		lower = store;
	    }
	    lesser.add(lower);
	    greater.add(higher);
	}
	}*/
    
    /* public int getMedian(){
	if(median==null){
	    return (lesser.peek()+greater.peek())/2;
	}else {
	    return median;
	}
	}*/

    private void rebalance(){
	if(greater.Size() - lesser.Size() > 1){
	    lesser.add(greater.remove());
	}else if(lesser.Size() - greater.Size() > 1){
	    greater.add(lesser.remove());
	}
    }

    public void add(int value){
	if(value>getMedian()){
	    greater.add(value);
	}else{
	    lesser.add(value);
	}
	rebalance();
    }

    public String toString(){
	return "HEAP: "+lesser+"\n"+greater+ "/HEAP";
    }
    
    public double getMedian(){
	try{
	    if(greater.Size()>lesser.Size()){
		return greater.peek();
	    }else if(lesser.Size()>greater.Size()){
		return lesser.peek();
	    }else{
		return (greater.peek() + lesser.peek())/2.0;
	    }
	}catch(IndexOutOfBoundsException e){
	    return 0;
	}
    }
    /*public void add(int value){
	if(median==null){
	    median = value;
	    if(median>greater.peek()){
		int holder = median;
		median = greater.remove();
		greater.add(holder);
	    }else{
		int holder = median;
		median = lesser.remove();
		lesser.add(holder);
	    }
	}else{
	    if(median>greater.peek()){
		int holder = median;
		median = greater.remove();
		greater.add(holder);
	    }else{
		int holder = median;
		median = lesser.remove();
		lesser.add(holder);
	    }
	    median = null;
	    add(value);
	}
	}*/
    public static void main(String[]args){
	//ARM his = new ARM();
	RunningMedian mine =  new RunningMedian();
	Random random = new Random();
	for(int x = 0;x<10;x++){
	    int y = random.nextInt(10);
	    //his.add(y);
	    mine.add(y);
	    //System.out.printline(his.getMedian() == mine.getMedian());
	    System.out.println(y);
	    System.out.println(mine);
	    
	    System.out.println(mine.getMedian());
	}
	
    }
}
