package matches;

import java.util.ArrayList;

import com.mygdx.game.Referee;
import com.mygdx.game.TugOfWarTeam;

public class tugHalfFinals {
	ArrayList<TugOfWarTeam> teams;
	int maxWins = 0;
	TugOfWarGame m1, m2;

	public TugOfWarGame getM1() {
		return m1;
	}

	public TugOfWarGame getM2() {
		return m2;
	}

	public tugHalfFinals(ArrayList<TugOfWarTeam> x, ArrayList<Referee> refs) {

		teams = new ArrayList<TugOfWarTeam>();
		for (TugOfWarTeam team : x) {
			if (team.getWins() > maxWins) {
				maxWins = team.getWins();

			}
		}
		for (int i = maxWins; i >= 0; i--) {
			for (TugOfWarTeam team : x) {
				if (team.getWins() == i && teams.size() < 4)
					teams.add(team);

			}
		}
		m1 = new TugOfWarGame(teams.get(0), teams.get(1), refs);
		m2 = new TugOfWarGame(teams.get(2), teams.get(3), refs);
	}
}