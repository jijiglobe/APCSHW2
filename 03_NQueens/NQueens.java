
import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private boolean[][]board;
    private int[][] location;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "";
	for(int y=0;y<board[0].length;y++){
	    for(int x=0;x<board.length;x++){
		if(board[x][y]){
		    ans+="Q ";
		}else{
		    ans+="# ";
		}
	    }
	    ans+="\n";
	}
		ans+="\n";
	for(int y=0;y<location[0].length;y++){
	    for(int x=0;x<location.length;x++){
		ans+=" "+location[x][y];
	    }
	    ans+="\n";
	}
	

	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new boolean[size][size];
	location = new int[size][2];
	for(int x=0;x<location.length;x++){
	    for(int y=0;y<location[x].length;y++){
		location[x][y] = -1;
	    }
	}
    }

    

    public boolean solve(){
	return solve(0);
    }


    public boolean solve(int starty){
	if(solve(0,starty,0)){
	    
	    for(int x = 0;x<location.length;x++){
		board[location[x][0]][location[x][1]] = true;
	    }
	    return true;
	}
	return false;
    }

    public boolean isvalid(int x,int y,int cmn){
	
	for(int i=0;i<location.length;i++){
	    
	    int x1 = location[i][0];
	    int y1 = location[i][1];
	    if(x1>=0){
		//boolean good = true;
		if(x1 == x){
		    //good = false;
		    
		    return false;
		}
		if(y1 == y){
		    //good = false;
		    //		System.out.println("OMIGODWHY");
		    // System.out.println(y);
		    // System.out.println(y1);
		    return false;
		}
		//System.out.println(x1);
		//System.out.println(y1);
		if(x-x1 == Math.abs(y-y1)){
		    //good = false;
		    //System.out.println("something else");
		    return false;
		}
	   
	    }
	}
	return true;	
    }
		
    public boolean solve(int x,int y,int cmn){
	if(cmn >= board.length) return true;

	if(y<0 || y>=board.length) return false;
	if(isvalid(x,y,cmn)){
	    //  board[x][y] = true;
	    location[cmn][0] = x;
	    location[cmn][1] = y;
	    //wait(20);
	    //System.out.println(this);

	    return solve(x+1,0,cmn+1)||solve(x,y+1,cmn);
	}
	
	//	board[x][y] = false;
	location[cmn][0] = -1;
	location[cmn][1] = -1;
	return solve(x,y+1,cmn);
	//System.out.println(this);
	//return false;
	
    }

    public static void main(String[]args){
	NQueens puzzle = new NQueens(20);
	System.out.println(puzzle.solve(1));
	System.out.println(puzzle);
    }
}
