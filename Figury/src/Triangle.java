import java.awt.Color;


public class Triangle extends Rectangle{
Line l1, l2, l3;
public Triangle (){
	super();
	l1 = new Line();
	l2 = new Line();
	l3 = new Line();
}

public Triangle(Color col, Point p1, Point p2, Point p3){
super(col);
l1 = new Line (p1,p2);
l2 = new Line (p2,p3);
l3 = new Line (p3,p1);
}
public void przesun(int dx, int dy){
	l1.przesun(dx, dy);
	l2.przesun(dx, dy);
	l3.przesun(dx, dy);
}
public String toString(){
	return color+"\n"+l1.toString()+"\n"+l2.toString()+"\n"+l3.toString();
}
}
