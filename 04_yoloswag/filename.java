public class filename{
    String pasture ="4 6 22 2
28 25 20 32 34 36
27 25 20 20 30 34
24 20 20 20 20 30
20 20 14 14 20 20
1 4 4
1 1 10";
    public int r,c,E,N;
    public static int[][] intpasture;
    public static int[][] instructions;

    public static void makeusablestuff(String pasture){
	String[] stuff = pasture.split("\n");//splits pasture by line
	String[] line1 = stuff[0].break(" ");//process line1 and get r,c,E,N,
	r = Integer.parseInt(line1[0]);
	c = Integer.parseInt(line1[1]);
	E = Integer.parseInt(line1[2]);
	N = Integer.parseInt(line1[3]);
	
	
    }	
    public static void main(String[]args){
	
    }
}
