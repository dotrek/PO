package matches;

import java.util.ArrayList;

import com.mygdx.game.Referee;
import com.mygdx.game.Team;

public class VolleyBallGame extends Match {
	Referee Assistant1, Assistant2;

	public VolleyBallGame(Team t1, Team t2, ArrayList<Referee> refik) {
		super(t1, t2, refik);
		Assistant1 = refik.get(rand.nextInt(refik.size()));
		Assistant2 = refik.get(rand.nextInt(refik.size()));
		while (Assistant1 == Assistant2 || Assistant1 == super.getRef() || Assistant2 == super.getRef()) {
			Assistant1 = refik.get(rand.nextInt(refik.size()));
			Assistant2 = refik.get(rand.nextInt(refik.size()));
		}
		System.out.println("Asystowali: " + Assistant1.getName() + " " + Assistant1.getSurname() + " oraz "
				+ Assistant2.getName() + " " + Assistant2.getSurname());
		// TODO Auto-generated constructor stub
	}

}