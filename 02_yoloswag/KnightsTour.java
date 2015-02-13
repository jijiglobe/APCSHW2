import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


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
	//build your knights tour here...
	for(int x = 0;x<board.length;x++){
	    for(int y=0;y<board[0].length;y++){
		int val =board[x][y];
		if(val<10){
		    ans+="  "+val;
		}else if(x<100){
		    ans +=" "+val;
		}else{
		    ans+=val;
		}
	    }
	    ans+="\n";
	}
	return clear + hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }

    
    public boolean solve(){
	return solve(0,0,1);
    }

    public boolean solve(int startx, int starty){
	return solve(startx,starty,0);
    }


    
    public boolean solve(int x,int y,int cmn){
	/*	System.out.println(this);
	wait(20);//*/
	//	boolean solved = true;
	try{
	    if(board[x][y] != 0){

		return false;
	    }
	}catch(IndexOutOfBoundsException e){
	    return false;
	}/*
	for(int i=0;i<board.length;i++){
	    for(int t=0;t<board.length;t++){
		if(board[i][t]==0){
		    solved = false;
		}
	    }
	}
	if(solved){
	    return true;
	    }*/

	board[x][y] = cmn;
	if(cmn >board.length*board.length - 1){
	    System.out.println(this);
	    wait(20);
	    return true;
	}
	
	//stuff to do below
	if(solve(x+2,y+1,cmn+1)||solve(x+2,y-1,cmn+1)||solve(x+1,y+2,cmn+1)||solve(x+1,y-2,cmn+1)||
	   solve(x-2,y+1,cmn+1)||solve(x-2,y-1,cmn+1)||solve(x-1,y+2,cmn+1)||solve(x-1,y-2,cmn+1)){
	    return true;
	}
	board[x][y]=0;
	return false;
    }

    public static void main(String[]args){
	KnightsTour tour = new KnightsTour(Integer.parseInt(args[0]));
	System.out.println(tour.solve());
    }
}