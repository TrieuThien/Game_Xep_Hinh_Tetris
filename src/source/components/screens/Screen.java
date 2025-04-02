package source.components.screens;

import java.awt.Graphics;

import source.components.another.Game;

public abstract class Screen {
	
protected Game game;
	
	public Screen(Game game) {
		this.game = game;
	}
	
	abstract public void update();
	abstract public void paint(Graphics g);

	public Game getGame() {
		return game;
	}

}
