import java.awt.Color;

//kwadrat
public class Quadrat extends Quad{
Quadrat (){
	super();
}
Quadrat(Color col, Point p1, int x){
	super (col, p1, new Point (p1.getX()+x, p1.getY()+x));
}
}
