import java.util.*;
public class filename{
    public static String pasture ="4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
    public static int r,c,E,N;
    public static int[][] intpasture;
    public static int[][] instructions;

    public static void makeusablestuff(String pasture){
	String[] stuff = pasture.split("\n");//splits pasture by line
	String[] line1 = stuff[0].split(" ");//process line1 and get r,c,E,N,
	r = Integer.parseInt(line1[0]);
	c = Integer.parseInt(line1[1]);
	E = Integer.parseInt(line1[2]);
	N = Integer.parseInt(line1[3]);
	
	intpasture = new int[r][c];

	for(int i=1;i<r+1;i++){
	    String[] tempvar = stuff[i].split(" ");
	    for(int t=0;t<tempvar.length;t++){
		intpasture[i-1][t] = Integer.parseInt(tempvar[t]);
	    }

	}
	instructions = new int[N][3];
	for(int i=1;i<N+1;i++){
	    String[] tempvar = stuff[i+r].split(" ");
	    for(int t=0;t<tempvar.length;t++){
		instructions[i-1][t] = Integer.parseInt(tempvar[t]);
	    }

	}
	/*	for(int i=r+1;i<c+r+1;i++){
	    instructions[i-r-1] = stuff[i].split(" ");
	    }*/
	
    }

    public static void stomp(int xcor, int ycor, int stomps){
	//int[] stuffs = new int[9];
	int max = 0;

	for(int x = -1;x<2;x++){ // attain maximum thing
	    for(int y=-1;y<2;y++){
		//stuffs[3*y+x] = intpasture[x][y];
		//System.out.println(""+(x+xcor)+" , "+(y+ycor));
		if(intpasture[x+xcor][y+ycor] > max)
		    max = intpasture[x+xcor][y+ycor];
	    }
	}
	//System.out.println(Arrays.deepToString(intpasture));
	//System.out.println(max);
	for(int x = -1;x<2;x++){
	    for(int y=-1;y<2;y++){
		if(intpasture[x+xcor][y+ycor] > max-stomps)
		    //System.out.println("Blarglewargle");
		    intpasture[x+xcor][y+ycor] = max-stomps;
	    }
	}
    }
    
    public static void doStomps(){
	for(int x=0;x<instructions.length;x++){
	    stomp(instructions[x][0],instructions[x][1],instructions[x][2]);
	}
    }
    
    public static void fill(){
	for(int x=0;x<intpasture.length;x++){
	    for(int y=0;y<intpasture[x].length;y++){
		intpasture[x][y] = E-intpasture[x][y];
	    }
	}
    }
    
    public static int calculate(){
	int agg = 0;
	for(int x=0;x<intpasture.length;x++){
	    for(int y=0;y<intpasture[x].length;y++){
		if(intpasture[x][y]>0){
		    agg+=intpasture[x][y];
		}
	    }
	}
	return agg*72*72;
    }

    //YOUR MAIN IS HERE!!!!!
    public static void main(String[]args){
	makeusablestuff(pasture);
	doStomps();
	fill();
	//System.out.println(Arrays.deepToString(intpasture));
	System.out.println(calculate());
    }
}
