public class Coordinate{
    public int x,y,c;
    public Coordinate(int nx, int ny,int nc){
	x = nx;
	y = ny;
	c = nc;
    }
    public String toString(){
	return "("+x+","+y+")";
    }
}
