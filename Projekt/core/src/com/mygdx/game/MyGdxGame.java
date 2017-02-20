package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import Exceptions.NotEnoughSizeException;
import Exceptions.SameNameException;
import matches.DodgeBallGame;
import matches.DodgeFinal;
import matches.TugFinal;
import matches.TugOfWarGame;
import matches.VolleyBallGame;
import matches.dodgeHalfFinals;
import matches.tugHalfFinals;
import matches.vbFinal;
import matches.vbHalfFinals;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch, miniBatch;
	private Sound whistle;
	private Music waves;
	Texture background;
	Stage stage;
	OrthographicCamera camera;
	TextButton button, button1, button2, button4, button5, exit;
	Skin skin;
	Label label, vTeams, tTeams, dTeams;
	Window window, windowTeams, windowRefs, windowMatches;
	DodgeBallTeam dodgeTeam;
	TextField teamname;
	ArrayList<Team> teamList = new ArrayList<Team>();
	ArrayList<DodgeBallTeam> dodgeTeamList = new ArrayList<DodgeBallTeam>();
	ArrayList<TugOfWarTeam> towTeamList = new ArrayList<TugOfWarTeam>();
	ArrayList<VolleyBallTeam> vbTeamList = new ArrayList<VolleyBallTeam>();
	ArrayList<Referee> refList = new ArrayList<Referee>();
	String vbTeams, towtTeams, dodgeTeams, allRefs;
	Dialog dialog;
	vbHalfFinals vbHalf;
	dodgeHalfFinals dodgeHalf;
	tugHalfFinals tugHalf;
	vbFinal vbf;
	DodgeFinal dodgeFinal;
	TugFinal tugFinal;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("beach.jpg");
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		// Adding menu buttons
		button = new TextButton("Start!", skin);
		button1 = new TextButton("Teams", skin);
		button2 = new TextButton("Referees", skin);
		button4 = new TextButton("Save", skin);
		button5 = new TextButton("Load", skin);
		whistle = Gdx.audio.newSound(Gdx.files.internal("whis.wav"));
		waves = Gdx.audio.newMusic(Gdx.files.internal("waves.mp3"));
		waves.play();
		// Adding window buttons
		exit = new TextButton("Exit", skin);
		label = new Label("Copacabana beach games!", skin); // title label

		// Adding windows for options
		window = new Window("Games Management", skin);
		windowTeams = new Window("Teams Management", skin);
		windowRefs = new Window("Referee Management", skin);
		window.setVisible(false);
		windowTeams.setVisible(false);
		windowRefs.setVisible(false);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Bounds();
		WindowPreferences();
		WindowTeamPreferences();
		WindowRefsPreferences();
		stage.addActor(button);
		stage.addActor(button1);
		stage.addActor(button2);
		stage.addActor(button4);
		stage.addActor(button5);
		stage.addActor(label);
		stage.addActor(exit);
		stage.addActor(window);
		stage.addActor(windowTeams);
		stage.addActor(windowRefs);

		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void resize(int width, int height) {
		camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		camera.update();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch.end();
		stage.draw();

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {

	}

	public void Bounds() {

		button.setBounds(Gdx.graphics.getWidth() / 2 - button.getWidth(), Gdx.graphics.getHeight() / 3,
				button.getPrefWidth() * 2, button.getPrefHeight() * 1.5f);
		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				window.setVisible(true);

			}
		});

		button1.setBounds(button.getX(), Gdx.graphics.getHeight() / 3 - button.getHeight(), button.getWidth(),
				button.getHeight());
		button1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				waves.stop();
				windowTeams.setVisible(true);

			}
		});
		button2.setBounds(button.getX(), Gdx.graphics.getHeight() / 3 - button.getHeight() * 2, button.getWidth(),
				button.getHeight());
		button2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				waves.stop();
				windowRefs.setVisible(true);
			}
		});
		button4.setPosition(Gdx.graphics.getWidth() - button4.getWidth(), button4.getY());
		button4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
		});
		button5.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("click");

			}
		});
		exit.setBounds(Gdx.graphics.getWidth() / 2 - exit.getWidth(), 0, exit.getPrefWidth() * 2, exit.getPrefHeight());
		exit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				Gdx.app.exit();
			}
		});
		label.setFontScale(4);
		label.setBounds(0f, Gdx.graphics.getHeight() / 2f, label.getPrefWidth(), label.getPrefHeight());

	}

	public void WindowTeamPreferences() {

		// initializing
		TextButton add = new TextButton("Add new Team", skin);
		final TextButton addVb = new TextButton("VolleyBall", skin);
		final TextButton addTowt = new TextButton("TugOfWar", skin);
		final TextButton addDodge = new TextButton("Dodge Ball", skin);
		TextButton exitw = new TextButton("Back", skin);
		TextButton check = new TextButton("Check teams", skin);
		TextButton delete = new TextButton("Delete existing team", skin);
		final TextButton checkVb = new TextButton("VolleyBall teams", skin);
		final TextButton checkTowt = new TextButton("TugOfWar teams", skin);
		final TextButton checkDodge = new TextButton("DodgeBall teams", skin);
		final TextField vbName = new TextField("", skin);
		final TextField dodgeName = new TextField("", skin);
		final TextField tugName = new TextField("", skin);
		final TextField teamNameDelete = new TextField("", skin);
		vTeams = new Label(vbTeams, skin);
		tTeams = new Label(towtTeams, skin);
		dTeams = new Label(dodgeTeams, skin);
		windowTeams.setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		add.setBounds(0 + add.getWidth(), windowTeams.getHeight() / 2, Gdx.graphics.getWidth() / 5,
				add.getPrefHeight());
		check.setBounds(add.getX(), add.getY() - add.getHeight(), add.getWidth(), add.getHeight());
		checkVb.setBounds(check.getX() + check.getWidth(), check.getY() + check.getHeight(), check.getWidth(),
				check.getHeight());
		checkDodge.setBounds(check.getX() + check.getWidth(), check.getY() - check.getHeight(), check.getWidth(),
				check.getHeight());
		checkTowt.setBounds(check.getX() + check.getWidth(), check.getY(), check.getWidth(), check.getHeight());
		delete.setBounds(check.getX(), check.getY() - check.getHeight(), add.getWidth(), add.getHeight());
		exitw.setBounds(windowTeams.getWidth() / 2, 0, exitw.getPrefWidth(), exitw.getPrefHeight());
		vbName.setBounds(add.getX() + add.getWidth() * 2, add.getY() + add.getHeight(), vbName.getPrefWidth(),
				add.getHeight());
		dodgeName.setBounds(add.getX() + add.getWidth() * 2, add.getY() - add.getHeight(), dodgeName.getPrefWidth(),
				addDodge.getHeight());
		tugName.setBounds(add.getX() + add.getWidth() * 2, add.getY(), dodgeName.getPrefWidth(), addDodge.getHeight());
		addVb.setBounds(add.getX() + add.getWidth(), add.getY() + add.getHeight(), add.getWidth(), add.getHeight());
		addTowt.setBounds(add.getX() + add.getWidth(), add.getY(), add.getWidth(), add.getHeight());
		addDodge.setBounds(add.getX() + add.getWidth(), add.getY() - add.getHeight(), add.getWidth(), add.getHeight());

		teamNameDelete.setBounds(delete.getX() + delete.getWidth(), delete.getY(), teamNameDelete.getPrefWidth() * 1.5f,
				delete.getHeight());

		vTeams.setBounds(windowTeams.getWidth() - windowTeams.getWidth() / 3,
				windowTeams.getHeight() - windowTeams.getHeight() / 3, vTeams.getPrefWidth(), vTeams.getPrefHeight());
		tTeams.setBounds(windowTeams.getWidth() - windowTeams.getWidth() / 3,
				windowTeams.getHeight() - windowTeams.getHeight() / 3, vTeams.getPrefWidth(), vTeams.getPrefHeight());
		dTeams.setBounds(windowTeams.getWidth() - windowTeams.getWidth() / 3,
				windowTeams.getHeight() - windowTeams.getHeight() / 3, vTeams.getPrefWidth(), vTeams.getPrefHeight());
		// teamName changing
		vbName.setVisible(false);
		vbName.setMessageText("New Team name");
		dodgeName.setVisible(false);
		dodgeName.setMessageText("New team name");
		tugName.setVisible(false);
		tugName.setMessageText("New team name");

		checkDodge.setVisible(false);
		checkTowt.setVisible(false);
		checkVb.setVisible(false);
		vTeams.setVisible(false);
		tTeams.setVisible(false);
		dTeams.setVisible(false);
		addDodge.setVisible(false);
		addTowt.setVisible(false);
		addVb.setVisible(false);

		teamNameDelete.setVisible(false);
		teamNameDelete.setMessageText("Name of team to delete");

		// Adding input listeners

		teamNameDelete.addListener(new InputListener() {

			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Input.Keys.ENTER) {
					for (int i = 0; i < vbTeamList.size(); i++) {
						if (vbTeamList.get(i).getTeamName().contains(teamNameDelete.getText()))
							vbTeamList.remove(i);
					}
					for (int i = 0; i < dodgeTeamList.size(); i++) {
						if (dodgeTeamList.get(i).getTeamName().contains(teamNameDelete.getText()))
							dodgeTeamList.remove(i);
					}
					for (int i = 0; i < towTeamList.size(); i++) {
						if (towTeamList.get(i).getTeamName().contains(teamNameDelete.getText()))
							towTeamList.remove(i);
					}
				}
				vbTeams = new String("Name    Wins    Loses \n");
				for (VolleyBallTeam team : vbTeamList) {
					vbTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
				}
				vTeams.setText(vbTeams);

				dodgeTeams = new String("Name    Wins    Loses \n");
				for (DodgeBallTeam team : dodgeTeamList) {
					dodgeTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
				}
				dTeams.setText(dodgeTeams);

				towtTeams = new String("Name    Wins    Loses \n");
				for (TugOfWarTeam team : towTeamList) {
					towtTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
				}
				tTeams.setText(towtTeams);
				return false;
			}
		});

		dodgeName.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Input.Keys.ENTER) {
					for (DodgeBallTeam dodgeBallTeam : dodgeTeamList) {
						if (dodgeBallTeam.getTeamName().equals(dodgeName.getText())) {
							try {
								throw (new SameNameException("There exist team with this name"));
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}
					if (dodgeTeamList.size() < 10) {
						dodgeTeamList.add(new DodgeBallTeam(dodgeName.getText()));
						dodgeName.setText(null);
						dodgeName.setMessageText("Dodano");
						dTeams.setText(dodgeTeams);
					} else
						dodgeName.setText("Brak miejsc");
					dodgeTeams = new String("Name    Wins    Loses \n");
					for (DodgeBallTeam team : dodgeTeamList) {
						dodgeTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					dTeams.setText(dodgeTeams);
				}
				return false;
			}
		});
		tugName.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Input.Keys.ENTER) {
					for (TugOfWarTeam tugTeam : towTeamList) {
						if (tugTeam.getTeamName() == tugName.getText()) {
							try {
								throw (new SameNameException("There exist team with this name"));
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}
					if (towTeamList.size() < 10) {
						towTeamList.add(new TugOfWarTeam(tugName.getText()));
						tugName.setText(null);
						tugName.setMessageText("Dodano");
						tTeams.setText(towtTeams);
					} else
						vbName.setText("Brak miejsc");
					towtTeams = new String("Name    Wins    Loses \n");
					for (TugOfWarTeam team : towTeamList) {
						towtTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					tTeams.setText(towtTeams);
				}
				return false;
			}
		});
		vbName.addListener(new InputListener() {

			@Override
			public boolean keyDown(InputEvent event, int keycode) {

				if (keycode == Input.Keys.ENTER) {
					for (VolleyBallTeam team : vbTeamList) {
						if (team.getTeamName() == vbName.getText()) {
							try {
								throw (new SameNameException("There exist team with this name"));
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							break;
						}
					}
					if (vbTeamList.size() < 10) {
						vbTeamList.add(new VolleyBallTeam(vbName.getText()));
						vbName.setText(null);
						vbName.setMessageText("Dodano");
						vTeams.setText(vbTeams);
					} else
						vbName.setText("Brak miejsc");
					vbTeams = new String("Name    Wins    Loses \n");
					for (VolleyBallTeam team : vbTeamList) {
						vbTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					vTeams.setText(vbTeams);
				}
				return false;
			}
		});

		// Click listeners for buttons
		check.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				if (checkVb.isVisible() == false && checkDodge.isVisible() == false && checkTowt.isVisible() == false) {
					checkVb.setVisible(true);
					checkDodge.setVisible(true);
					checkTowt.setVisible(true);
					if (addDodge.isVisible() == true && addTowt.isVisible() == true && addVb.isVisible() == true) {
						addDodge.setVisible(false);
						addTowt.setVisible(false);
						addVb.setVisible(false);
					}
				} else {
					checkVb.setVisible(false);
					checkDodge.setVisible(false);
					checkTowt.setVisible(false);
				}

			}
		});
		checkDodge.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (tTeams.isVisible() == true || vTeams.isVisible() == true) {
					tTeams.setVisible(false);
					vTeams.setVisible(false);
				}
				if (dTeams.isVisible() == false)
					dTeams.setVisible(true);
				else
					dTeams.setVisible(false);
			}
		});
		checkTowt.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (dTeams.isVisible() == true || vTeams.isVisible() == true) {
					dTeams.setVisible(false);
					vTeams.setVisible(false);
				}
				if (tTeams.isVisible() == false)
					tTeams.setVisible(true);
				else
					tTeams.setVisible(false);
			}
		});
		checkVb.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (tTeams.isVisible() == true || dTeams.isVisible() == true) {
					tTeams.setVisible(false);
					dTeams.setVisible(false);
				}
				if (vTeams.isVisible() == false)
					vTeams.setVisible(true);
				else
					vTeams.setVisible(false);
			}
		});
		exitw.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				waves.play();
				windowTeams.setVisible(false);
			}
		});
		add.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				if (addDodge.isVisible() == false && addVb.isVisible() == false && addTowt.isVisible() == false) {
					addVb.setVisible(true);
					addDodge.setVisible(true);
					addTowt.setVisible(true);
					if (checkDodge.isVisible() == true && checkVb.isVisible() == true
							&& checkTowt.isVisible() == true) {
						checkDodge.setVisible(false);
						checkVb.setVisible(false);
						checkTowt.setVisible(false);
					}
				} else {
					addDodge.setVisible(false);
					addVb.setVisible(false);
					addTowt.setVisible(false);
				}

			}
		});
		delete.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (teamNameDelete.isVisible() == false)
					teamNameDelete.setVisible(true);
				else
					teamNameDelete.setVisible(false);
			}
		});
		addVb.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (vbName.isVisible() == false)
					vbName.setVisible(true);
				else
					vbName.setVisible(false);
			}
		});
		addDodge.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (dodgeName.isVisible() == false)
					dodgeName.setVisible(true);
				else
					dodgeName.setVisible(false);
			}
		});
		addTowt.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (tugName.isVisible() == false)
					tugName.setVisible(true);
				else
					tugName.setVisible(false);
			}
		});
		// adding actors to window
		Texture team = new Texture("team.jpg");
		windowTeams.setBackground(new TextureRegionDrawable(new TextureRegion(team)));
		windowTeams.addActor(checkDodge);
		windowTeams.addActor(checkTowt);
		windowTeams.addActor(checkVb);
		windowTeams.addActor(tugName);
		windowTeams.addActor(addDodge);
		windowTeams.addActor(addTowt);
		windowTeams.addActor(addVb);
		windowTeams.addActor(vbName);
		windowTeams.addActor(dodgeName);
		windowTeams.addActor(add);
		windowTeams.addActor(exitw);
		windowTeams.addActor(vTeams);
		windowTeams.addActor(dTeams);
		windowTeams.addActor(tTeams);
		windowTeams.addActor(check);
		windowTeams.addActor(delete);
		windowTeams.addActor(teamNameDelete);
	}

	private void WindowRefsPreferences() {
		TextButton add = new TextButton("Add new Ref", skin);
		TextButton exitw = new TextButton("Back", skin);
		TextButton delete = new TextButton("Delete ref", skin);
		final TextField refName = new TextField("", skin);
		final TextField refDelete = new TextField("", skin);
		final Label refs = new Label(allRefs, skin);

		// setting Bounds
		windowRefs.setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		add.setBounds(0 + add.getWidth(), windowRefs.getHeight() / 2, Gdx.graphics.getWidth() / 5, add.getPrefHeight());

		delete.setBounds(add.getX(), add.getY() - add.getHeight(), add.getWidth(), add.getHeight());

		exitw.setBounds(windowRefs.getWidth() / 2, 0, exitw.getPrefWidth(), exitw.getPrefHeight());

		refName.setBounds(add.getX() + add.getWidth(), add.getY(), refName.getPrefWidth() * 2, add.getHeight());

		refDelete.setBounds(delete.getX() + delete.getWidth(), delete.getY(), refDelete.getPrefWidth() * 1.5f,
				delete.getHeight());

		refs.setBounds(windowRefs.getWidth() - windowRefs.getWidth() / 3,
				windowRefs.getHeight() - windowRefs.getHeight() / 3, refs.getPrefWidth(), refs.getPrefHeight());

		// teamName changing
		refName.setVisible(false);
		refName.setMessageText("New referee name and surname");
		refName.setFocusTraversal(false);
		refDelete.setVisible(false);
		refDelete.setMessageText("Surname of ref to delete");

		// Adding input listeners
		refDelete.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Input.Keys.ENTER) {
					System.out.println(refDelete.getText());
					for (int i = 0; i < refList.size(); i++) {
						System.out.println(i + " " + refList.get(i).getSurname());
						if (refList.get(i).getSurname().contains(refDelete.getText()))
							refList.remove(i);
					}
					allRefs = new String("Name  Surname \n");
					for (Referee ref : refList) {
						allRefs += "\n" + ref.getName() + "   " + ref.getSurname();
					}
					refs.setText(allRefs);
				}
				return false;
			}
		});

		refName.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Input.Keys.ENTER) {
					if (refList.size() < 10) {
						if (refName.getText().equals(" ")) {
							int x = refName.getText().lastIndexOf(" ");
							String name = refName.getText().substring(0, x);
							String surname = refName.getText().substring(x);
							refList.add(new Referee(name, surname));
						} else {
							refList.add(new Referee("", refName.getText()));
						}
						refName.setText(null);
						refName.setMessageText("Dodano");
						refs.setText(allRefs);
					} else
						refName.setText("Brak miejsc");
					allRefs = new String("Name Surname \n");
					for (Referee ref : refList) {
						allRefs += "\n" + ref.getName() + "   " + ref.getSurname();
					}
					refs.setText(allRefs);
				}
				return false;
			}
		});
		exitw.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				waves.play();
				windowRefs.setVisible(false);
			}
		});
		add.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				if (refName.isVisible() == false)
					refName.setVisible(true);
				else
					refName.setVisible(false);
				refName.setText("");

			}
		});
		delete.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (refDelete.isVisible() == false)
					refDelete.setVisible(true);
				else
					refDelete.setVisible(false);
			}
		});

		// adding actors to window

		windowRefs.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("ref.jpg"))));
		windowRefs.addActor(refName);
		windowRefs.addActor(add);
		windowRefs.addActor(exitw);
		windowRefs.addActor(refs);
		windowRefs.addActor(delete);
		windowRefs.addActor(refDelete);
	}

	public void WindowPreferences() {
		TextButton exitw = new TextButton("Exit", skin);

		final TextButton startVb = new TextButton("Start VolleyBall games!", skin);
		final TextButton startDodge = new TextButton("Start DodgeBall games!", skin);
		final TextButton startTug = new TextButton("Start TugOfWar games!", skin);
		final TextButton startVbHalfFinals = new TextButton("Start VolleyBall half-finals", skin);
		final TextButton startDodgeHalfFinals = new TextButton("Start DodgeBall half-finals", skin);
		final TextButton startTugHalfFinals = new TextButton("Start TugOfWar half-finals", skin);
		final TextButton startVbFinal = new TextButton("Start VolleyBall Final!", skin);
		final TextButton startDodgeFinal = new TextButton("Start DodgeBall Final!", skin);
		final TextButton startTugFinal = new TextButton("Start TugOfWar Final!", skin);

		final Label labelVb = new Label("The winner of \n " + "Volley Ball tournament is \n " + "team ", skin);
		final Label labelDodge = new Label("The winner of \n " + "Dodge Ball tournament is \n " + "team ", skin);
		final Label labelTug = new Label("The winner of \n " + "Tug Of War tournament is \n " + "team ", skin);
		labelVb.setVisible(false);
		labelDodge.setVisible(false);
		labelTug.setVisible(false);

		exitw.setBounds(window.getWidth() / 2, window.getHeight() / 30f, exitw.getPrefWidth(), exitw.getPrefHeight());

		startVb.setBounds(Gdx.graphics.getWidth() / 2 - startVb.getWidth() * 2, Gdx.graphics.getHeight() / 2, 200, 80);

		startDodge.setBounds(startVb.getX(), startVb.getY() - startVb.getHeight(), startVb.getWidth(),
				startVb.getHeight());
		startTug.setBounds(startVb.getX(), startVb.getY() - startVb.getHeight() * 2, startVb.getWidth(),
				startVb.getHeight());

		startVbHalfFinals.setBounds(startVb.getX() + startVb.getWidth() * 1.2f, startVb.getY(), startVb.getWidth(),
				startVb.getHeight());
		startDodgeHalfFinals.setBounds(startDodge.getX() + startDodge.getWidth() * 1.2f, startDodge.getY(),
				startDodge.getWidth(), startDodge.getHeight());
		startTugHalfFinals.setBounds(startTug.getX() + startTug.getWidth() * 1.2f, startTug.getY(), startTug.getWidth(),
				startTug.getHeight());
		startVbFinal.setBounds(startVbHalfFinals.getX() + startVbHalfFinals.getWidth() * 1.2f, startVb.getY(),
				startVb.getWidth(), startVb.getHeight());
		startDodgeFinal.setBounds(startDodgeHalfFinals.getX() + startDodgeHalfFinals.getWidth() * 1.2f,
				startDodge.getY(), startDodge.getWidth(), startDodge.getHeight());
		startTugFinal.setBounds(startTugHalfFinals.getX() + startTugHalfFinals.getWidth() * 1.2f, startTug.getY(),
				startTug.getWidth(), startTug.getHeight());
		window.setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		labelVb.setBounds(startVb.getX(), startVb.getY() + startVb.getHeight() * 2, labelVb.getPrefWidth(),
				labelVb.getPrefHeight());
		labelDodge.setBounds(startDodgeHalfFinals.getX(), startVb.getY() + startVb.getHeight() * 2,
				labelDodge.getPrefWidth(), labelDodge.getPrefHeight());
		labelTug.setBounds(startTugFinal.getX(), startVb.getY() + startVb.getHeight() * 2, labelTug.getPrefWidth(),
				labelTug.getPrefHeight());

		exitw.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				window.setVisible(false);
			}
		});
		startVb.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (vbTeamList.size() >= 2 && refList.size() >= 3) {
					whistle.play();
					for (int i = 0; i < vbTeamList.size(); i++)
						for (int j = i + 1; j < vbTeamList.size(); j++) {
							if (i != j) {
								VolleyBallGame match = new VolleyBallGame(vbTeamList.get(i), vbTeamList.get(j),
										refList);
							}
						}
					vbTeams = new String("Name    Wins    Loses \n");
					for (VolleyBallTeam team : vbTeamList) {
						vbTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					vTeams.setText(vbTeams);

					startVb.clearListeners();

				} else
					try {
						throw (new NotEnoughSizeException("Size of some list is not enough"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		});
		startVbHalfFinals.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (vbTeamList.size() >= 4 && (vbTeamList.get((int) Math.random() * vbTeamList.size()).getWins() > 0
						|| vbTeamList.get((int) Math.random() * vbTeamList.size()).getLoses() > 0)) {
					whistle.play();
					vbHalf = new vbHalfFinals(vbTeamList, refList);
				}
			}
		});
		startVbFinal.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (vbHalf != null) {
					vbf = new vbFinal(vbHalf.getM1().getWhoWon(), vbHalf.getM2().getWhoWon(), refList);
					whistle.play();
					labelVb.setText(labelVb.getText() + vbf.getWhoWon().toString());
					labelVb.setVisible(true);
				}

			}
		});

		startDodge.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (dodgeTeamList.size() >= 2 && refList.size() >= 1) {
					whistle.play();
					for (int i = 0; i < dodgeTeamList.size(); i++)
						for (int j = i + 1; j < dodgeTeamList.size(); j++) {
							if (i != j) {
								DodgeBallGame match = new DodgeBallGame(dodgeTeamList.get(i), dodgeTeamList.get(j),
										refList);
							}
						}
					dodgeTeams = new String("Name    Wins    Loses \n");
					for (DodgeBallTeam team : dodgeTeamList) {
						dodgeTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					dTeams.setText(dodgeTeams);

					startDodge.clearListeners();
				} else
					try {
						throw (new NotEnoughSizeException("Size of some list is not enough"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		});
		startDodgeHalfFinals.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (dodgeTeamList.size() >= 4
						&& (dodgeTeamList.get((int) Math.random() * dodgeTeamList.size()).getWins() > 0
								|| dodgeTeamList.get((int) Math.random() * dodgeTeamList.size()).getLoses() > 0)) {
					whistle.play();
					dodgeHalf = new dodgeHalfFinals(dodgeTeamList, refList);
				}
			}
		});
		startDodgeFinal.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (dodgeHalf != null) {
					whistle.play();
					dodgeFinal = new DodgeFinal(dodgeHalf.getM1().getWhoWon(), dodgeHalf.getM2().getWhoWon(), refList);
					labelDodge.setText(labelDodge.getText() + dodgeFinal.getWhoWon().toString());
					labelDodge.setVisible(true);
				}

			}
		});
		startTug.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (towTeamList.size() >= 2 && refList.size() >= 1) {
					whistle.play();
					for (int i = 0; i < towTeamList.size(); i++)
						for (int j = i + 1; j < towTeamList.size(); j++) {
							if (i != j) {
								TugOfWarGame match = new TugOfWarGame(towTeamList.get(i), towTeamList.get(j), refList);
							}
						}
					towtTeams = new String("Name    Wins    Loses \n");
					for (TugOfWarTeam team : towTeamList) {
						towtTeams += "\n" + team.getTeamName() + "   " + team.getWins() + "   " + team.getLoses();
					}
					tTeams.setText(towtTeams);

					startTug.clearListeners();
				} else
					try {
						throw (new NotEnoughSizeException("Size of some list is not enough"));
					} catch (Exception e) {
						e.printStackTrace();
					}
			}

		});
		startTugHalfFinals.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (towTeamList.size() >= 4 && (towTeamList.get((int) Math.random() * towTeamList.size()).getWins() > 0
						|| towTeamList.get((int) Math.random() * towTeamList.size()).getLoses() > 0)) {
					whistle.play();
					tugHalf = new tugHalfFinals(towTeamList, refList);
				}
			}
		});
		startTugFinal.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (tugHalf != null) {
					whistle.play();
					tugFinal = new TugFinal(tugHalf.getM1().getWhoWon(), tugHalf.getM2().getWhoWon(), refList);
					labelTug.setText(labelTug.getText() + tugFinal.getWhoWon().toString());
					labelTug.setVisible(true);
				}

			}
		});

		window.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("games.jpg"))));
		window.addActor(startDodge);
		window.addActor(startVb);
		window.addActor(startTug);
		window.addActor(exitw);
		window.addActor(startVbHalfFinals);
		window.addActor(startTugHalfFinals);
		window.addActor(startDodgeHalfFinals);
		window.addActor(startTugFinal);
		window.addActor(startDodgeFinal);
		window.addActor(startVbFinal);
		window.addActor(labelVb);
		window.addActor(labelDodge);
		window.addActor(labelTug);
	}
}