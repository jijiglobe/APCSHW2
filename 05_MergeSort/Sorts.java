import java.util.*;
public class Sorts{
    public static int[] selection(int[] array){
	for(int i=0;i<array.length;i++){
	    int least = i;
	    int t=i;
	    for(;t<array.length;t++){
		if(array[t]<array[least]){
		    least = t;
		}
	    }
	    int copy= array[i];
	    array[i] = array[least];
	    array[least] = copy;
	}
	return array;
    }
    
    
    public static void shifto(int[] array,int index2){
	int copy = array[index2];
	while(index2>0&&copy<array[index2-1]){
	    change(array,index2,array[index2-1]);
	    index2--;
	} 
	change(array,index2,copy);

    }

    public static int change(int[] array, int index, int value){
	int returnval = array[index];
	array[index] = value;
	return returnval;
    }

    
    public static int[] insertion(int[]array){	
	for(int i=0;i<array.length-1;i++){
	    if(array[i]<array[i+1]){
		shifto(array,i+1);
	    }
	}
	return array;
    }

    public static int[] Merge(int[] arr1, int[] arr2){
	int x = 0;
	int y = 0;
	boolean last1 = true;
	int[] ans = new int[arr1.length+arr2.length];
	while(x<arr1.length && y<arr2.length){
	    if(arr1[x]<arr2[y]){
		ans[x+y] = arr1[x];
		x++;
		last1 = true;
	    }else{
		ans[x+y] = arr2[y];
		y++;
		last1 = false;
	    }	
	}
	if(last1){
	   
	    while(y<arr2.length){
		//System.out.println(Arrays.toString(ans));
		ans[x+y] = arr2[y];
		y++;
	    }
	}else{
	   
	    while(x<arr1.length){
		ans[x+y] = arr1[x];
		x++;
	    }
	} 
	return ans;
    }

    public static int[] radix(int[] array){
	int madesorts = 0;
	int digit = 10;
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(20);
	for(int i=0;i<10;i++){
	    bucket.add(new ArrayList<Integer>());
	}
	while(madesorts< 3){
	    //bucket.clear();
	    for(int i=0;i<array.length;i++){
		bucket.get((array[i]%digit)/(digit/10)).add(array[i]);//adds the current value to the end of the corresponding bucket
	    }
	    digit++;
	    if(bucket.get(0).size() == array.length){ //checks if the array is already sorted
		madesorts++;
	    }
	    int index = 0;
	    for(ArrayList<Integer> i : bucket){ // reads the elements from the bucket and adds them back to array 
		for(int t : i){
		    array[index] = t;
		    index++;
		}
	    }
	    for(int i=0;i<bucket.size();i++){
		bucket.get(i).clear();
	    }
	    digit*=10;
	}
	return array;
    }
    
    public static int[] MergeSort(int[] arr){
	if(arr.length<40){
	    return selection(arr);
	}
	else{
	    return Merge(MergeSort(Arrays.copyOfRange(arr,0,arr.length/2)),
			 MergeSort(Arrays.copyOfRange(arr,arr.length/2,arr.length)));
	}
    }
     
    public static void mergesort(int[] arr){
	//arr = MergeSort(arr); 
	System.out.println(Arrays.toString(MergeSort(arr)));

    }
    
    
    
    //MAIN BELOW
    public static void main(String[]args){
	/*
	  int[] thing = new int[10000];
	  for(int x=0;x<10000;x++){
	  thing[9999-x] = x;
	  }
	  //merge(thing);
	  Arrays.sort(thing);
	  //System.out.println(Arrays.toString(thing));
	  //System.out.println(Arrays.toString(Merge(new int[] {1,3,5,7,9,10,11,12},new int[] {2,4,6,8})));
	  */
    }
    
}
