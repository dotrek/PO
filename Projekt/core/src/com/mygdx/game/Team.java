package com.mygdx.game;

public class Team {
	String teamName;
	public int wins;
	public int loses;

	Team() {
		wins = 0;
		loses = 0;
	}

	Team(String name) {
		teamName = name;
		wins = 0;
		loses = 0;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getWins() {
		return wins;
	}

	public int getLoses() {
		return loses;
	}

	void changeName(String newName) {
		teamName = newName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTeamName();
	}

}