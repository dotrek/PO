	

public class Line extends Point{
Point p1, p2;
 public Line(){
	 p1=new Point();
	 p2=new Point();
 }
 public Line(Point pkt1, Point pkt2){
	 p1=new Point(pkt1);
	 p2=new Point(pkt2);
 }
 public Line (Line l){
	 p1=l.p1;
	 p2=l.p2;
 }
public void przesun (int dx, int dy){
	p1.przesun(dx, dy);
	p2.przesun(dx, dy);
}
public String toString(){
	return p1.toString()+p2.toString();
	}
	
}

