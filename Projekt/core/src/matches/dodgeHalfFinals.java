package matches;

import java.util.ArrayList;

import com.mygdx.game.DodgeBallTeam;
import com.mygdx.game.Referee;

public class dodgeHalfFinals {
	ArrayList<DodgeBallTeam> teams;
	int maxWins = 0;
	DodgeBallGame m1, m2;

	public DodgeBallGame getM1() {
		return m1;
	}

	public DodgeBallGame getM2() {
		return m2;
	}

	public dodgeHalfFinals(ArrayList<DodgeBallTeam> x, ArrayList<Referee> refs) {

		teams = new ArrayList<DodgeBallTeam>();
		for (DodgeBallTeam team : x) {
			if (team.getWins() > maxWins) {
				maxWins = team.getWins();

			}
		}
		for (int i = maxWins; i >= 0; i--) {
			for (DodgeBallTeam team : x) {
				if (team.getWins() == i && teams.size() < 4)
					teams.add(team);

			}
		}
		m1 = new DodgeBallGame(teams.get(0), teams.get(1), refs);
		m2 = new DodgeBallGame(teams.get(2), teams.get(3), refs);
	}
}