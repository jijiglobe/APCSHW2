import java.util.*;
public class RunningMedian{
    MyHeap greater,lesser;
    int median;
    ArrayList<Integer> overkill;

    public String name(){
	return "Jion Fairchild";
    }
    
    public RunningMedian(){
	greater = new MyHeap();
	lesser = new MyHeap();
	overkill = new ArrayList<integer>();
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
    
    public void getMedian(int value){
	if(median==null){
	    return (lesser.peek()+greater.peek())/2;
	}else {
	    return median;
	}
    }

    public void add(int value){
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
    }

}
