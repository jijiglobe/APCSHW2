import java.io.*;
import java.util.*;

class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    //finder methods
    public BSTreeNode<T> findLargestChild(){
	if(hasRight()){
	    return getRight.findLargestChild();
	}else{
	    return this;
	}
    }

    public BSTreeNode<T> findSmallestChild(){
	if(hasLeft()){
	    return getLeft.findLargestChild();
	}else{
	    return this;
	}
    }

    public BSTreeNode<T> findVal(T val){
	if(getData.compareTo(val) == 0){
	    return this;
	}else if(getLeft()!=null){   
	    BSTreeNode<T> left = getLeft.findVal(T);
	    if(left!=null){
		return left;
	    }
	}else if(getRight()!= null){
	
	    BSTreeNode<T> right = getRight.findVal(T);
	    if(right!=null){
		return right;
	    }
	}
	return null;
    }
}
//
//
//Your binary search tree skeleton file:
//import java.io.*;
//import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;
    private Random random;
    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
	random = new Random();
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
      BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    @SuppressWarnings("unchecked")
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(curr==null){
	    return t;
	}
	if(curr.getData().compareTo(t.getData())>0){
	    curr.setLeft(add(curr.getLeft(),t));
	}
	else{
	    curr.setRight(add(curr.getRight(),t));
	}
	return curr;
    }
    
    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	//root = remove( root, c );
	BSTree<T> location = root.findVal(c);
	if(location==null) return;
	if(random.nextInt(2)==0){
	    BSTree<T> maxSubtree =location.findLargestValue();
	    if(maxSubtree.hasLeft){
		BSTree<T> MSLeft = maxSubtree.getLeft();
		maxSubtree.setLeft
	}else{
	    
	}
	    
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

   
    public static void main( String[] args ) {
	BSTree<Integer> mytree = new BSTree<Integer>();
	for(int x=0; x<10;x++){
	    mytree.add(x);
	}
	mytree.inOrder();
    }

}
