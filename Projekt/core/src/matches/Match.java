package matches;

import java.util.ArrayList;
import java.util.Random;

import com.mygdx.game.Referee;
import com.mygdx.game.Team;

public class Match {
	static Team whoWon;
	Team team1, team2;
	Referee ref;
	Random rand = new Random();

	public Match(Team t1, Team t2, ArrayList<Referee> refik) {
		team1 = t1;
		team2 = t2;
		ref = refik.get(rand.nextInt(refik.size()));
		System.out.println("Mecz między " + team1.toString() + " a " + team2.toString());
		int i = (int) (Math.random() * 2);
		if (i == 1) {
			System.out.println("Wygrał " + team1.toString());
			whoWon = team1;
			team1.wins++;
			team2.loses++;
		} else {
			System.out.println("Wygrał " + team2.toString());
			whoWon = team2;
			team2.wins++;
			team1.loses++;
		}

		System.out.println("Sędziował " + ref.getName() + " " + ref.getSurname());
	}

	public Team getWhoWon() {
		return whoWon;
	}

	public Team getTeam1() {
		return team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public Referee getRef() {
		return ref;
	}
}