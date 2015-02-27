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
	int[] stuffs = new int[9];
	for(int x = xcor
    }

    public static void main(String[]args){
	makeusablestuff(pasture);
	for(int i=0; i<intpasture.length;i++){
	    //	    System.out.println(Arrays.asList(intpasture[i]));
	    String shit = "";
	    for(int t=0;t<intpasture[i].length;t++){
		shit+=intpasture[i][t];
	    }
	    System.out.println(shit);

	}
	//System.out.println(instructions);
	for(int i=0; i<instructions.length;i++){
	    //	    System.out.println(Arrays.asList(intpasture[i]));
	    String shit = "";
	    for(int t=0;t<instructions[i].length;t++){
		shit+=instructions[i][t];
	    }
	    System.out.println(shit);

	}
	//System.out.println(instructions);
    }
}
