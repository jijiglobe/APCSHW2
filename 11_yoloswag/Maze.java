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
    private Coordinate end,start;
    private String[][] board;
    private int[] solution;
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {

	}
    }

    public boolean solve(boolean animate, int mode){
	if(mode == 0){
	    return solveBFS(animate);
	}else{
	    return solveDFS(animate);
	}
    }

    /** Same constructor as before...*/
    public Maze(String filename)throws Exception{ 
	
	//ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
	int c = 0;
     	//Scanner fileScanner = new Scanner(new File("c:\\file.txt"));
	String content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
	String[] contentLines = content.split("\n");
	board = new String[contentLines.length][];
	for(int x = 0;x<contentLines.length;x++){
	    String line = contentLines[x];
	    char[] cars = line.toCharArray();
	    board[x] = new String[cars.length];
	    for(int i=0;i<cars.length;i++){
		board[x][i] =""+ cars[i];
	    }
	}
	end = findEnd();
	start = findStart();
    }

    public String toString(){
	String ans = "";
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[x].length;y++){
		if(board[x][y].length() == 1){
		    ans +="  " + board[x][y];
		}else{
		    ans+=" "+board[x][y];
		}
	    }
	    ans+="\n\n";
	}
	return ans;
    }
    //do not do the funky character codes, this is used for non-animated printing,
    //it is just the string representation of the maze (before or after solving).


    public String toString(boolean animate){ 
	if(animate){
	    return clear+go(0,0)+hide+toString();
	}else{
	    return toString();
	}
    } //do the funky character codes when animate is true
    //this to string will be used in your animate, it would include the go(0,0) character, 
    //as well as the clear/hide/show characters as you need to use them.


    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public Coordinate findStart(){
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[x].length;y++){
		if( board[x][y].equals("S")){
		    return new Coordinate(x,y,0);
		}
	    }
	}
	return null;
    }

    public Coordinate findEnd(){
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[x].length;y++){
		if( board[x][y].equals("E")){
		    return new Coordinate(x,y,0);
		}
	    }
	}
	return null;
    }

    public void addCoordinate(int x, int y, MyDeque<Coordinate> queue, int counter){
	if(x >=0 && x<board.length && 
	   y >=0 && y<board[0].length){
	    if(board[x][y].equals(" ")){
		board[x][y] = "?";
		queue.addLast(new Coordinate(x,y,counter+1));
	    }if(board[x][y].equals("E")){
		queue.addLast(new Coordinate(x,y,counter+1));
	    }
	}
    }

    public void addCoordinateWithPriority(int x, int y, PQ<Coordinate> queue, int counter, int priority){
	if(x >=0 && x<board.length && 
	   y >=0 && y<board[0].length){
	    if(board[x][y].equals(" ")){
		board[x][y] = "?";
		queue.addFirst(new Coordinate(x,y,counter+1),priority);
	    }if(board[x][y].equals("E")){
		queue.addFirst(new Coordinate(x,y,counter+1),priority);
	    }
	}
    }
	    
 public boolean traceCoordinate(int x, int y, MyDeque<Coordinate> queue, int counter){
	if(x >=0 && x<board.length && 
	   y >=0 && y<board[0].length &&
	   board[x][y].equals("" + (counter - 1))){
	    queue.addLast(new Coordinate(x,y,counter+1));
	    return true;
	}
	return false;
    }
        
    public boolean solveBFS(boolean animate){   
	MyDeque<Coordinate> moves = new MyDeque<Coordinate>();
	moves.addLast(findStart());
	Coordinate current;
	while(moves.hasNext()){
	    current = moves.removeFirst();
	    int cx = current.x;
	    int cy = current.y;
	    int cc = current.c;
	    
	    if(cx >=0 && cx<board.length && 
	       cy >=0 && cy<board[0].length &&
	       board[cx][cy].equals("E")){
		//highlight(current);
		solution = solutionCoordinates(current);
		return true;
	    }		

	    board[cx][cy] =""+ cc;
	    if(animate){
		wait(2);
		//System.out.println(Arrays.toString(moves.getQueue()));
		System.out.println(this.toString(true));
	    }
	    addCoordinate(cx+1,cy,moves,cc);
	    addCoordinate(cx-1,cy,moves,cc);
	    addCoordinate(cx,cy+1,moves,cc);
	    addCoordinate(cx,cy-1,moves,cc);	    
	}
	return false;
    }

    public boolean solveBest(boolean animate){   
	PQ<Coordinate> moves = new PQ<Coordinate>();
	moves.addLast(findStart(),0);
	Coordinate current;
	while(moves.hasNext()){
	    current = moves.removeSmallest();
	    System.out.println(current);
	    int cx = current.x;
	    int cy = current.y;
	    int cc = current.c;
	    
	    if(cx >=0 && cx<board.length && 
	       cy >=0 && cy<board[0].length &&
	       board[cx][cy].equals("E")){
		//highlight(current);
		solution = solutionCoordinates(current);
		return true;
	    }		

	    board[cx][cy] =""+ cc;
	    if(animate){
		wait(100);
		System.out.println(this.toString(true));
		System.out.println("frontier: "+moves.getQueue());
	    }
	    int priority = Math.abs(end.x - cx)+Math.abs(end.y-cy);
	    addCoordinateWithPriority(cx+1,cy,moves,cc,priority);
	    addCoordinateWithPriority(cx-1,cy,moves,cc,priority);
	    addCoordinateWithPriority(cx,cy+1,moves,cc,priority);
	    addCoordinateWithPriority(cx,cy-1,moves,cc,priority);

	}
	return false;
    }

    public boolean solveAStar(boolean animate){   
	PQ<Coordinate> moves = new PQ<Coordinate>();
	moves.addLast(findStart(),0);
	Coordinate current;
	while(moves.hasNext()){
	    current = moves.removeSmallest();
	    System.out.println(current);
	    int cx = current.x;
	    int cy = current.y;
	    int cc = current.c;
	    
	    if(cx >=0 && cx<board.length && 
	       cy >=0 && cy<board[0].length &&
	       board[cx][cy].equals("E")){
		//highlight(current);
		solution = solutionCoordinates(current);
		return true;
	    }		

	    board[cx][cy] =""+ cc;
	    if(animate){
		wait(100);
		System.out.println(this.toString(true));
		System.out.println("frontier: "+moves.getQueue());
	    }
	    int priority = Math.abs(end.x - cx)+Math.abs(end.y-cy)+
		Math.abs(start.x - cx)+Math.abs(start.y-cy);
	    addCoordinateWithPriority(cx+1,cy,moves,cc,priority);
	    addCoordinateWithPriority(cx-1,cy,moves,cc,priority);
	    addCoordinateWithPriority(cx,cy+1,moves,cc,priority);
	    addCoordinateWithPriority(cx,cy-1,moves,cc,priority);

	}
	return false;
    }

    
    public MyDeque<Coordinate> trace(Coordinate pen){
	MyDeque<Coordinate> path = new MyDeque<Coordinate>();
	Coordinate current = pen;
	while(current.c!=0){
	    int cx = current.x;
	    int cy = current.y;
	    int cc = current.c;
	    if(traceCoordinate(cx+1,cy,path,cc)){
		current = new Coordinate(cx+1,cy,cc-1);
	    }else if(traceCoordinate(cx-1,cy,path,cc)){
		current = new Coordinate(cx-1,cy,cc-1);	    
	    }else if(traceCoordinate(cx,cy+1,path,cc)){
		current = new Coordinate(cx,cy+1,cc-1);
	    }else{
		traceCoordinate(cx,cy-1,path,cc);
		current = new Coordinate(cx,cy-1,cc-1);
	    }
	}
	return path;
    }
    
    public void highlight(Coordinate pen){
	MyDeque<Coordinate> path = trace(pen);
	while(path.hasNext()){
	    Coordinate holder = path.removeLast();
	    board[holder.x][holder.y] = "P";
	}				 
    }
    
    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	MyDeque<Coordinate> moves = new MyDeque<Coordinate>();
	moves.addLast(findStart());
	Coordinate current;
	while(moves.hasNext()){
	    current = moves.removeLast();
	    int cx = current.x;
	    int cy = current.y;
	    int cc = current.c;
	    
	    if(cx >=0 && cx<board.length && 
	       cy >=0 && cy<board[0].length &&
	       board[cx][cy].equals("E")){
		//highlight(current);
		solution = solutionCoordinates(current);
		return true;
	    }		

	    board[cx][cy] =""+ cc;
	    if(animate){
		wait(2);
		System.out.println(this.toString(true));
	    }
	    addCoordinate(cx+1,cy,moves,cc);
	    addCoordinate(cx-1,cy,moves,cc);
	    addCoordinate(cx,cy+1,moves,cc);
	    addCoordinate(cx,cy-1,moves,cc);	    
	}
	return false;
    }

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
    public int[] solutionCoordinates(Coordinate pen){
	MyDeque<Coordinate> path = trace(pen);
	int[] ans = new int[path.Size()*2];
	int i = 0;
	while(path.hasNext()){
	    Coordinate holder = path.removeLast();
	    ans[i] = holder.x;
	    i++;
	    ans[i] = holder.y;
	    i++;
	}				 
	return ans;
    }    

    public int[] solutionCoordinates(){
	return solution;
    }
    
    public static void main(String[]args) throws Exception{
	Maze myMaze = new Maze("myMaze");
	System.out.println(myMaze.solveAStar(true));
	System.out.println(Arrays.toString(myMaze.solutionCoordinates()));
	//System.out.println(myMaze.toString(false));
	}
}

