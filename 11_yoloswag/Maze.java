import java.util.*;
import java.io.*;
import java.nio.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private char[][] board;


    /** Same constructor as before...*/
    public Maze(String filename)throws Exception{ 
	
	//ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
	int c = 0;
     	//Scanner fileScanner = new Scanner(new File("c:\\file.txt"));
	String content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
	String[] contentLines = content.split("\n");
	board = new char[contentLines.length][];
	for(int x = 0;x<contentLines.length;x++){
	    String line = contentLines[x];
	    char[] cars = line.toCharArray();
	    board[x] = new char[cars.length];
	    for(int i=0;i<cars.length;i++){
		board[x][i] = cars[i];
	    }
	}
    }

    public String toString(){
	String ans = "";
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[x].length;y++){
		ans += board[x][y];
	    }
	    ans+="\n";
	}
	return ans;
    }
    //do not do the funky character codes, this is used for non-animated printing,
    //it is just the string representation of the maze (before or after solving).


    public String toString(boolean animate){ 
	return toString();
    } //do the funky character codes when animate is true
    //this to string will be used in your animate, it would include the go(0,0) character, 
    //as well as the clear/hide/show characters as you need to use them.


    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   
	return true;
	
    }
    
    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){return false;    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){return new int[2]; }    

    public static void main(String[]args) throws Exception{
	Maze myMaze = new Maze("myMaze");
	System.out.println(myMaze);

    }
}

