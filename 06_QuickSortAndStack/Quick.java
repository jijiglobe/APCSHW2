import java.util.*;

public class Quick{
    public static Random random = new Random();
    public static void swap(int[] array,int x1,int y1){
	int backup = array[y1];
	array[y1] = array[x1];
	array[x1] = backup;
    }
    public static int[] partition(int[] list, int left, int right, int p){
	int compare = list[p];
	swap(list,p,right);
	int copies = 0;
	int storeIndex = left;
	for(int i=left;i<right-1;i++){
	    if(list[i] < compare){
		swap(list,storeIndex,i);
		storeIndex++;
	    }
	    if(list[i] == compare){
		swap(list,storeIndex,right - copies);
		copies++;
	    }
	}
	System.out.println(Arrays.toString(list));
	int before = storeIndex;
	for(int i=1;i<copies;i++){
	    swap(list,storeIndex,right-i);
	    storeIndex--;
	}
	swap(list,right,storeIndex);
	return new int[] {before,storeIndex};
	
    }
    
    public static void quickh(int[] list,int left,int right){
	if(left<right-1){
	    int[] p = partition(list,left,right,random.nextInt(right-left)+left);
	    //System.out.println(p);
	    //partition(list,left,right-1,p);
	    quickh(list,left,p[0]);
	    quickh(list,p[1],right);
	}
    }

        public static void quick(int[] list){
	quickh(list,0,list.length-1);
    }
    /*   public static void partition(int[] array,int p){
	int compare = p;
	int s=0;
	int e=array.length-1;
	for(int i=0;i<e;i++){
	    if(array[i]<compare){
		swap(array,s,i);
		s++;
	    }
	    if(array[i] > compare){
		swap(array,e,i);
		e--;
	    }	    
	}
	array[s] = compare;
	}*/
    public static boolean isSorted(int[] array){
	for(int i=0;i<array.length-1;i++){
	    if(array[i]>=array[i+1]){
		return false;
	    }
	}
	return true;
    }
    public static void main(String[]args){
	int length = Integer.parseInt(args[0]);
        int[] array = new int[length];
	Random r = new Random(length);
	for(int i=0;i<length;i++){
	    array[i] = i/2;
	}
	for(int i=0;i<length;i++){
	    swap(array,i,r.nextInt(length));
	}
	//	System.out.println(Arrays.toString(array));
	System.out.println(Arrays.toString(array));
	//quick(array);
	partition(list,0,length-1,5);
	if(isSorted(array)){
	    System.out.println("YOU DIDIT");
	}else{
	    System.out.println(Arrays.toString(array));
	}
	//partition(array,0,length-1,5);
	//swap(array,0,9);
    }
}
