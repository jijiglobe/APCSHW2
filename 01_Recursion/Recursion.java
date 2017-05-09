// public interface hw1{
//     public String name();
//     public int fact(int n);
//     public int fib(int n);
//     public double sqrt(double n); 
// }
public class recursion implements hw1{
    public String name(){
	return "Fairchild,Jion";
    }
    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n<2){
	    return n;
	}
	else return n*fact(n-1);
    }
    
    public int fib(int n){
	if( n<0){
	    throw new IllegalArgumentException();
	}
	if( n==0||n==1){
	    return n;
	}else{
	    return fib(n-1)+ fib(n-2);
	}
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrth(n,n/2);
    }
    public double sqrth(double n, double guess){
	double g2 = (guess*guess - n)/2;
	if(g2<0.0001 && g2>-0.0001){
	    return guess;
	}else{
	    return sqrth(n,(n/guess+guess)/2);
	}
    }

    public static void main(String[] args){
	recursion r = new recursion();
       	for(int i=0;i<10;i++){
	    System.out.println(r.fact(i));
	}
	System.out.println("FIBBY");
	for(int i=0;i<10;i++){
	    System.out.println(r.fib(i));
	    }
	System.out.println(r.name());
	for(int i=0;i<10;i++){
	    System.out.println(r.sqrt(i*i));
	}
	
    }
}
