import java.util.ArrayList;

public class Picture{
private ArrayList<Object> list;
public Picture(){
	list = new ArrayList<Object>();
}
public void add (Triangle tr){
	list.add(tr);
}
public void add(Square sq){
	list.add(sq);
}
public String toString(){
	if(!list.isEmpty()){
	String stringi=new String("Współrzędne punktów figur to: ");
		for (int i = 0;i<list.size();i++) {
			stringi+=list.get(i).toString();
		}
		return stringi;
	}
	else
		return "Lista pusta";
}

}

