package source.components.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import source.components.another.Window;
import source.components.another.FileLoader;
import source.components.another.Game;
import source.components.another.MyButton;

public class MenuScr extends Screen{
	
	private BufferedImage backGround;
	private BufferedImage speak;
	private BufferedImage guide;
	private BufferedImage sllv;
	
	private ArrayList<MyButton> buttons = new ArrayList<MyButton>();
	private MyButton btnNewGame;
	private MyButton btnContinue;
	private MyButton btnHowToPlay;
	private MyButton btnQuit;
	private MyButton btnDone;
	private MyButton btnPlay;
	private MyButton btnCancel;
	
	private int level = 1;
	
	private boolean isGuide = false;
	
	public MenuScr(Game game) {
		super(game);
		backGround = FileLoader.loadImage("/bgm.png");
		guide = FileLoader.loadImage("/guide.png");
		
		btnContinue = new MyButton(game, FileLoader.loadImage("/continue.png"), 240, 300, 180, 53);
		btnNewGame = new MyButton(game, FileLoader.loadImage("/newgame.png"), 240, 370, 180, 53);
		btnHowToPlay = new MyButton(game, FileLoader.loadImage("/howtoplay.png"), 240, 440, 180, 53);
		btnQuit = new MyButton(game, FileLoader.loadImage("/quit.png"), 240, 510, 180, 53);
		btnDone = new MyButton(game, FileLoader.loadImage("/done.png"), 161, 355, 128, 53);
		btnCancel = new MyButton(game, FileLoader.loadImage("/cancel.png"), 235, 355, 128, 53);
		
		buttons.add(btnContinue);
		buttons.add(btnNewGame);
		buttons.add(btnHowToPlay);
		buttons.add(btnQuit);
	}

	@Override
	public void update() {
		if(btnNewGame.isMouseUp()) {
			game.getWindow().getGameScr().setNewGame(1);
			game.getWindow().setScreen(Window.Screen.Game);
		}

		else if (isGuide) {
			btnDone.update();
			if(btnDone.isMouseUp()) {
				isGuide = false;
			}
		}
		else {
			if(buttons != null) {
				for (MyButton button : buttons) {
					if (button == btnContinue) {
						if (game.getWindow().getGameScr().isPause()) {
							button.update();
						}
					} else {
						button.update();
					}				
				}
			}
			if(btnQuit.isMouseUp()) {
				System.exit(0);
			}
			if(btnHowToPlay.isMouseUp()) {
				isGuide = true;
			}
			if (btnContinue.isMouseUp()&&game.getWindow().getGameScr().isPause()) {
				game.getWindow().getGameScr().setPause(false);
				game.getWindow().setScreen(Window.Screen.Game);
			}
		} 
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(backGround, 0, 0, game.getWindow().getCanvas().getWidth(), game.getWindow().getCanvas().getHeight(), null);	

		if (isGuide) {
			g.drawImage(guide, 60, 150, 330, 236, null);
			btnDone.paint(g);
		}
		else {
			if(buttons != null) {
				for (MyButton button : buttons) {
					if (button == btnContinue) {
						if (game.getWindow().getGameScr().isPause()) {
							button.paint(g);
						}
					} else {
						button.paint(g);
					}
				}
			}
		}
	}

}
