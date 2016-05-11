import java.util.Random;



public class Point {
private int x,y;
Random rand = new Random();
 public Point(){
	 x = rand.nextInt(10);
	 y = rand.nextInt(10);
 }
 public Point(int ix, int iy){
	 x=ix;
	 y=iy;
 }
 public Point(Point p){
	 x=p.x;
	 y=p.y;
 }
 public void przesun(int dx, int dy){
	 x+=dx;
	 y+=dy;
 }
 
 public int getX() {
	return x;
}
public int getY() {
	return y;
}
public String toString(){
	 return "("+x+","+y+")";
 }
}
