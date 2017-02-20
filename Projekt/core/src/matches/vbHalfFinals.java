package matches;

import java.util.ArrayList;

import com.mygdx.game.Referee;
import com.mygdx.game.VolleyBallTeam;

public class vbHalfFinals {
	ArrayList<VolleyBallTeam> teams;
	int maxWins = 0;
	VolleyBallGame m1, m2;

	public VolleyBallGame getM1() {
		return m1;
	}

	public VolleyBallGame getM2() {
		return m2;
	}

	public vbHalfFinals(ArrayList<VolleyBallTeam> x, ArrayList<Referee> refs) {

		teams = new ArrayList<VolleyBallTeam>();
		for (VolleyBallTeam team : x) {
			if (team.getWins() > maxWins) {
				maxWins = team.getWins();

			}
		}
		for (int i = maxWins; i >= 0; i--) {
			for (VolleyBallTeam team : x) {
				if (team.getWins() == i && teams.size() < 4)
					teams.add(team);

			}
		}
		m1 = new VolleyBallGame(teams.get(0), teams.get(1), refs);
		m2 = new VolleyBallGame(teams.get(2), teams.get(3), refs);
	}
}