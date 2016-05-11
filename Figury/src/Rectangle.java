import java.awt.Color;


public class Rectangle {
protected Color color;
Rectangle(){
	color=new Color(100);
}
Rectangle (Color c){
	color=c;
}

public Color getColor(){
	return color;
}


}

