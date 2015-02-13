
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
	String ans = "\n";
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[0].length;y++){
		if(board[x][y]){
		    ans+="Q";
		}else{
		    ans+=" ";
		}
	    }
	}
		
	//build your knights tour here...
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new boolean[size][size];
	location = new int[size][2];
    }

    

    public boolean solve(){
	return solve(0,0,0);
    }


    public boolean solve(int startx, int starty){
	return solve(x,y,0);
    }



		
    public boolean solve(int x,int y,int cmn){
	//legal move check case
	for(int i=0;i<location.length;i++){
	    int x1 = location[i][0];
	    int y1 = location[i][0];
	    if(x1 == x)
		return false;
	    if(y1 == y){
		return false;
	    }if(Math.abs((y-y1)/(x-x1)) == 1){
		return false;
	    }
	}

	//solved case
	if(cmn == board.length){
	    return true;
	}
	board[x][y] = true;
	board[cmn][0] = x;
	board[cmn][1] = y;
	//move check case
	boolean solvable = false
	for(int i=0;i<board.length;i++){
	    if(solve(x,i,cmn+1)){
		solvable = true;
	    }

	}

	wait(20);
	System.out.println(this);
				
	return false;
    }


}