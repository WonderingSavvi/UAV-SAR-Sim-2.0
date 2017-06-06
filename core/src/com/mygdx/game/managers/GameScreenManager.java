package com.mygdx.game.managers;

import java.util.HashMap;

import com.mygdx.game.GameState;
import com.mygdx.game.screens.AbstractScreen;
import com.mygdx.game.screens.GameScreen;

public class GameScreenManager {
	
	public final GameState app;
	
	private HashMap <STATE, AbstractScreen> gameScreens;
	
	// Basic screen enumerators
	public enum STATE {
		MAIN_MENU,
		SETTINGS,
		PLAY
	}
	
	
	public GameScreenManager(final GameState app){
		this.app = app;
		
		initScreens();
		
		//Instantiate the play screen
		setScreen(STATE.PLAY);
	}

	
	//Screen initialization
	private void initScreens() {
		this.gameScreens = new HashMap <STATE, AbstractScreen>();
		this.gameScreens.put(STATE.PLAY, new GameScreen(app));
	}

	public void setScreen(STATE nextScreen){
		app.setScreen(gameScreens.get(nextScreen));
	
	}
	
	public void dispose(){
		for (AbstractScreen screen : gameScreens.values()) {
			if (screen != null){
				screen.dispose();
			}
		}
	}
}
