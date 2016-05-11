import java.awt.Color;

//Prostokąt
public class Quad extends Square{
Quad(){
	super();
	
}
Quad(Color col, Point p1, Point p2){
	super(col, new Point (p1.getX(), p2.getY()), p1, p2, new Point (p2.getX(), p1.getY()));
}
}
